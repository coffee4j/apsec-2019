package de.rwth.swc.apsec2019.experiments;

import de.rwth.swc.coffee4j.engine.TestModel;
import de.rwth.swc.coffee4j.engine.TupleList;
import de.rwth.swc.coffee4j.engine.conflict.ConflictDetectionConfiguration;
import de.rwth.swc.coffee4j.engine.conflict.DiagnosisHittingSet;
import de.rwth.swc.coffee4j.engine.conflict.MissingInvalidTuple;
import de.rwth.swc.coffee4j.engine.conflict.diagnosis.ExhaustiveConflictDiagnostician;
import de.rwth.swc.coffee4j.engine.conflict.explanation.QuickConflictExplainer;
import de.rwth.swc.coffee4j.engine.generator.ipog.Ipog;
import de.rwth.swc.coffee4j.engine.generator.ipogneg.IpogNeg;
import de.rwth.swc.coffee4j.engine.manager.BasicCombinatorialTestManager;
import de.rwth.swc.coffee4j.engine.manager.CombinatorialTestConfiguration;
import de.rwth.swc.coffee4j.model.InputParameterModel;
import de.rwth.swc.coffee4j.model.converter.IndexBasedModelConverter;
import de.rwth.swc.coffee4j.model.report.ConflictDetectionReporter;
import de.rwth.swc.coffee4j.model.report.PrintStreamConflictDetectionReporter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

class TestHelper {
    private static final int WARMUP = 30;
    private static final int REPETITIONS = 50;

    static void runConflictDiagnosis(InputParameterModel model) {
        final IndexBasedModelConverter converter = new IndexBasedModelConverter(model);

        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(true, false, true, QuickConflictExplainer.class, true, ExhaustiveConflictDiagnostician.class),
                Collections.emptyList(),
                null
        );

        final TestModel testModel = converter.getConvertedModel();

        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, testModel);

        final List<MissingInvalidTuple> mits = manager.checkConstraintsForConflicts();

        final List<DiagnosisHittingSet> dhss = mits.size() ==
                0 ? Collections.emptyList() : manager.computeMinimalDiagnosisHittingSets(mits);

        final ConflictDetectionReporter reporter = new PrintStreamConflictDetectionReporter(System.out, converter);

        System.out.println("#mits = " + mits.size());
        System.out.println("#dhs  = " + dhss.size());
        System.out.println();

        reporter.reportDetectedMissingInvalidTuples(mits);

        System.out.println();

        reporter.reportMinimalDiagnosisHittingSets(dhss);
    }

    static double runPerformance(InputParameterModel model) {
        final IndexBasedModelConverter converter = new IndexBasedModelConverter(model);
        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(true, false, true, QuickConflictExplainer.class, true, ExhaustiveConflictDiagnostician.class),
                Collections.emptyList(),
                null
        );

        final TestModel testModel = converter.getConvertedModel();
        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, testModel);

        System.out.println("EXPERIMENT: begin warmup");

        for(int i = 0; i < WARMUP; i++) {
            final List<MissingInvalidTuple> mits = manager.checkConstraintsForConflicts();

            if(mits.size() > 0) manager.computeMinimalDiagnosisHittingSets(mits);
        }

        System.out.println("EXPERIMENT: finish warmup");
        System.out.println("EXPERIMENT: begin execution");

        final long times[] = new long[REPETITIONS];

        for(int i = 0; i < REPETITIONS; i++) {
            final long begin = System.nanoTime();

            final List<MissingInvalidTuple> mits = manager.checkConstraintsForConflicts();
            if(mits.size() > 0) manager.computeMinimalDiagnosisHittingSets(mits);

            final long end = System.nanoTime() - begin;

            times[i] = TimeUnit.MILLISECONDS.convert(end, TimeUnit.NANOSECONDS);
        }

        System.out.println("EXPERIMENT: finish execution");

        return Arrays.stream(times).average().orElse(Double.NaN);
    }

    static void evaluateRepair(InputParameterModel repairedModel, InputParameterModel correctModel) {
        final TestModel modifiedTestModel = new IndexBasedModelConverter(repairedModel).getConvertedModel();
        final TestModel correctTestModel = new IndexBasedModelConverter(correctModel).getConvertedModel();

        runConflictDiagnosis(repairedModel);

        final int validSize = computeValidTestSuiteSize(modifiedTestModel);
        final int invalidSize = computeInvalidTestSuiteSize(modifiedTestModel);
        final long accCovered = computeAccidentsInValidTestInputs(modifiedTestModel, correctTestModel);
        final long missings = computeMissingsInvalidTestInputs(modifiedTestModel, correctTestModel);
        final long duplicates = computeDuplicatesInvalidTestInputs(modifiedTestModel, correctTestModel);
        final long notStrong = computeNotStrongInvalidTestInputs(modifiedTestModel, correctTestModel);
        final long notValid = computeNotValidTestInputs(modifiedTestModel, correctTestModel);

        System.out.println("test suite size: " + validSize + " " + invalidSize);
        System.out.println("acc. covered invalid tuples: " + accCovered);
        System.out.println("missing inv tuples: " + missings);
        System.out.println("duplicate inv tuples: " + duplicates);
        System.out.println("not strong inv test inputs: " + notStrong);
        System.out.println("not valid test inputs: " + notValid);
    }

    private static long computeAccidentsInValidTestInputs(TestModel repairedTestModel, TestModel correctTestModel) {
        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(true, false, true, QuickConflictExplainer.class, true, ExhaustiveConflictDiagnostician.class),
                Collections.singletonList(new Ipog()),
                null
        );

        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, repairedTestModel);

        final List<int[]> testSuite = manager.generateInitialTests();

        final List<TupleList> invalidTupleLists = correctTestModel.getErrorTupleLists();

        long accidentallyCoveredInvalidTuples = 0;
        for(TupleList invalidTupleList : invalidTupleLists) {
            for(int[] invalidTuple : invalidTupleList.getTuples()) {
                final long count = testSuite.stream().filter(testInput -> covers(testInput, invalidTupleList.getInvolvedParameters(), invalidTuple)).count();

                accidentallyCoveredInvalidTuples += count;
            }
        }
        return accidentallyCoveredInvalidTuples;
    }

    private static long computeMissingsInvalidTestInputs(TestModel repairedTestModel, TestModel correctTestModel) {
        repairedTestModel = new TestModel(0, repairedTestModel.getParameterSizes(), repairedTestModel.getForbiddenTupleLists(), repairedTestModel.getErrorTupleLists());

        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(true, false, true, QuickConflictExplainer.class, true, ExhaustiveConflictDiagnostician.class),
                Collections.singletonList(new IpogNeg()),
                null
        );

        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, repairedTestModel);

        final List<int[]> testSuite = manager.generateInitialTests();

        final List<TupleList> invalidTupleLists = correctTestModel.getErrorTupleLists();

        long missingInvalidTuples = 0;
        for(TupleList invalidTupleList : invalidTupleLists) {
            for(int[] invalidTuple : invalidTupleList.getTuples()) {
                final long count = testSuite.stream()
                        .filter(testInput -> covers(testInput, invalidTupleList.getInvolvedParameters(), invalidTuple))
                        .count();

                if(count == 0) {
                    System.out.println("INFO: missing invalid tuple " + Arrays.toString(invalidTuple) +
                            " of parameters " + Arrays.toString(invalidTupleList.getInvolvedParameters()));

                    missingInvalidTuples++;
                }
            }
        }

        return missingInvalidTuples;
    }

    private static long computeDuplicatesInvalidTestInputs(TestModel repairedTestModel, TestModel correctTestModel) {
        repairedTestModel = new TestModel(0, repairedTestModel.getParameterSizes(), repairedTestModel.getForbiddenTupleLists(), repairedTestModel.getErrorTupleLists());

        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(true, false, true, QuickConflictExplainer.class, true, ExhaustiveConflictDiagnostician.class),
                Arrays.asList( new IpogNeg()),
                null
        );

        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, repairedTestModel);

        final List<int[]> testSuite = manager.generateInitialTests();

        final List<TupleList> invalidTupleLists = correctTestModel.getErrorTupleLists();

        long redundancies = 0;
        for(TupleList invalidTupleList : invalidTupleLists) {
            for(int[] invalidTuple : invalidTupleList.getTuples()) {
                final long count = testSuite.stream()
                        .filter(testInput -> covers(testInput, invalidTupleList.getInvolvedParameters(), invalidTuple))
                        .count();

                if(count > 1) redundancies++;
            }
        }

        return redundancies;
    }

    private static long computeNotStrongInvalidTestInputs(TestModel repairedTestModel, TestModel correctTestModel) {
        repairedTestModel = new TestModel(0, repairedTestModel.getParameterSizes(), repairedTestModel.getForbiddenTupleLists(), repairedTestModel.getErrorTupleLists());

        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(true, false, true, QuickConflictExplainer.class, true, ExhaustiveConflictDiagnostician.class),
                Collections.singletonList(new IpogNeg()),
                null
        );

        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, repairedTestModel);

        final List<int[]> testSuite = manager.generateInitialTests();

        final List<TupleList> invalidTupleLists = correctTestModel.getErrorTupleLists();

        int notStrongInvalidTestInputs = 0;

        for(int[] testInput : testSuite) {
            int coveredInvalidTuples = 0;

            for(TupleList invalidTupleList : invalidTupleLists) {
                for(int[] invalidTuple : invalidTupleList.getTuples()) {
                    if(covers(testInput, invalidTupleList.getInvolvedParameters(), invalidTuple)) {
                        coveredInvalidTuples++;
                    }
                }
            }

            if(coveredInvalidTuples > 1) {
                notStrongInvalidTestInputs++;

                System.out.println("INFO: not strong invalid test input " + Arrays.toString(testInput));
            }
        }

        return notStrongInvalidTestInputs;
    }

    private static long computeNotValidTestInputs(TestModel repairedTestModel, TestModel correctTestModel) {
        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(true, false, true, QuickConflictExplainer.class, true, ExhaustiveConflictDiagnostician.class),
                Collections.singletonList(new Ipog()),
                null
        );

        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, repairedTestModel);

        final List<int[]> testSuite = manager.generateInitialTests();
        final List<TupleList> invalidTupleLists = correctTestModel.getErrorTupleLists();

        int notValidCounter = 0;
        for(int[] testInput : testSuite) {
            final boolean notValid = invalidTupleLists.stream()
                    .anyMatch(invalidTupleList ->
                            invalidTupleList.getTuples().stream().anyMatch(invalidTuple ->
                                    covers(testInput, invalidTupleList.getInvolvedParameters(), invalidTuple)));

            if(notValid) {
                notValidCounter++;
            }
        }

        return notValidCounter;
    }

    private static int computeValidTestSuiteSize(TestModel testModel) {
        final CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(true, false, true, QuickConflictExplainer.class, true, ExhaustiveConflictDiagnostician.class),
                Collections.singletonList(new Ipog()),
                null
        );

        final BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, testModel);

        final List<int[]> testSuite = manager.generateInitialTests();

        return testSuite.size();
    }

    private static int computeInvalidTestSuiteSize(TestModel testModel) {
        testModel = new TestModel(0, testModel.getParameterSizes(), testModel.getForbiddenTupleLists(), testModel.getErrorTupleLists());

        CombinatorialTestConfiguration configuration = new CombinatorialTestConfiguration(
                null,
                new ConflictDetectionConfiguration(true, false, true, QuickConflictExplainer.class, true, ExhaustiveConflictDiagnostician.class),
                Collections.singletonList(new IpogNeg()),
                null
        );

        BasicCombinatorialTestManager manager = new BasicCombinatorialTestManager(configuration, testModel);

        return manager.generateInitialTests().size();
    }

    private static boolean covers(int[] testInput, int[] involvedParameters, int[] invalidValues) {
        for(int i = 0; i < involvedParameters.length; i++) {
            final int parameter = involvedParameters[i];
            final int value = invalidValues[i];

            if(testInput[parameter] != value) {
                return false;
            }
        }

        return true;
    }
}
