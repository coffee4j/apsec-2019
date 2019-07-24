package de.rwth.swc.apsec2019.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Test;

import static de.rwth.swc.apsec2019.experiments.TestHelper.*;
import static de.rwth.swc.apsec2019.experiments.models.Banking1_TestModel.*;
import static de.rwth.swc.apsec2019.experiments.models.HealthCare3_TestModel.*;

class HealthCare3_Test {

    @Test
    void testHealthCare3() {
        final InputParameterModel model = buildModel_HealthCare3_Correct(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testHealthCare3_Diagnose() {
        final InputParameterModel model = buildModel_HealthCare3_Incorrect(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testHealthCare3_Repair1() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair1(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_Repair2() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair2(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_Repair3() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair3(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_Repair4() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair4(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_Repair5() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair5(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_Repair6() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair6(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_Repair7() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair7(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_Repair8() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair8(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_Repair9() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair9(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_Repair10() {
        final InputParameterModel repairedModel = buildModel_HealthCare3_Repair10(1);
        final InputParameterModel correctModel = buildModel_HealthCare3_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare3_DiagnosePerformance_Incorrect() {
        final InputParameterModel model = buildModel_HealthCare3_Incorrect(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }

    @Test
    void testHealthCare3_DiagnosePerformance_Correct() {
        final InputParameterModel model = buildModel_HealthCare3_Correct(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }
}
