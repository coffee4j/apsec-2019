package de.rwth.swc.apsec2019.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Test;

import static de.rwth.swc.apsec2019.experiments.TestHelper.*;
import static de.rwth.swc.apsec2019.experiments.models.HealthCare4_TestModel.*;

class HealthCare4_Test {

    @Test
    void testHealthCare4() {
        final InputParameterModel model = buildModel_HealthCare4_Correct(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testHealthCare4_Diagnose() {
        final InputParameterModel model = buildModel_HealthCare4_Incorrect(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testHealthCare4_Repair1() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair1(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair2() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair2(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair3() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair3(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair4() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair4(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair5() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair5(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair6() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair6(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair7() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair7(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair8() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair8(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair9() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair9(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair10() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair10(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair11() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair11(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair12() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair12(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair13() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair13(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair14() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair14(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair15() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair15(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_Repair16() {
        final InputParameterModel repairedModel = buildModel_HealthCare4_Repair16(1);
        final InputParameterModel correctModel = buildModel_HealthCare4_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare4_DiagnosePerformance_Incorrect() {
        final InputParameterModel model = buildModel_HealthCare4_Incorrect(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }

    @Test
    void testHealthCare4_DiagnosePerformance_Correct() {
        final InputParameterModel model = buildModel_HealthCare4_Correct(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }
}
