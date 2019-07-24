package de.rwth.swc.apsec2019.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Test;

import static de.rwth.swc.apsec2019.experiments.TestHelper.*;
import static de.rwth.swc.apsec2019.experiments.models.HealthCare2_TestModel.*;
import static de.rwth.swc.apsec2019.experiments.models.HealthCare3_TestModel.*;

class HealthCare2_Test {

    @Test
    void testHealthCare2() {
        final InputParameterModel model = buildModel_HealthCare2_Correct(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testHealthCare2_Diagnose() {
        final InputParameterModel model = buildModel_HealthCare2_Incorrect(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testHealthCare2_Repair1() {
        final InputParameterModel repairedModel = buildModel_HealthCare2_Repair1(1);
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare2_Repair2() {
        final InputParameterModel repairedModel = buildModel_HealthCare2_Repair2(1);
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare2_Repair3() {
        final InputParameterModel repairedModel = buildModel_HealthCare2_Repair3(1);
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare2_Repair4() {
        final InputParameterModel repairedModel = buildModel_HealthCare2_Repair4(1);
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare2_Repair5() {
        final InputParameterModel repairedModel = buildModel_HealthCare2_Repair5(1);
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare2_Repair6() {
        final InputParameterModel repairedModel = buildModel_HealthCare2_Repair6(1);
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare2_Repair7() {
        final InputParameterModel repairedModel = buildModel_HealthCare2_Repair7(1);
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare2_Repair8() {
        final InputParameterModel repairedModel = buildModel_HealthCare2_Repair8(1);
        final InputParameterModel correctModel = buildModel_HealthCare2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare2_DiagnosePerformance_Incorrect() {
        final InputParameterModel model = buildModel_HealthCare2_Incorrect(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }

    @Test
    void testHealthCare2_DiagnosePerformance_Correct() {
        final InputParameterModel model = buildModel_HealthCare2_Correct(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }
}
