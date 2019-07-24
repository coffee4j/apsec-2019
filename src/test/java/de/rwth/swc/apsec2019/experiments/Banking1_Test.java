package de.rwth.swc.apsec2019.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Test;

import static de.rwth.swc.apsec2019.experiments.TestHelper.*;
import static de.rwth.swc.apsec2019.experiments.models.Banking1_TestModel.*;

class Banking1_Test {

    @Test
    void testBanking1() {
        final InputParameterModel model = buildModel_Banking1_Correct(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testBanking1_Diagnose() {
        final InputParameterModel model = buildModel_Banking1_Incorrect(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testBanking1_Repair1() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair1(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair2() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair2(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair3() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair3(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair4() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair4(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair5() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair5(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair6() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair6(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair7() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair7(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair8() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair8(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair9() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair9(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair10() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair10(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair11() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair11(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair12() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair12(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair13() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair13(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair14() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair14(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair15() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair15(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_Repair16() {
        final InputParameterModel repairedModel = buildModel_Banking1_Repair16(1);
        final InputParameterModel correctModel = buildModel_Banking1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking1_DiagnosePerformance_Incorrect() {
        final InputParameterModel model = buildModel_Banking1_Incorrect(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }

    @Test
    void testBanking1_DiagnosePerformance_Correct() {
        final InputParameterModel model = buildModel_Banking1_Correct(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }
}
