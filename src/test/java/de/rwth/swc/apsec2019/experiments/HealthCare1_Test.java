package de.rwth.swc.apsec2019.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Test;

import static de.rwth.swc.apsec2019.experiments.TestHelper.*;
import static de.rwth.swc.apsec2019.experiments.models.HealthCare1_TestModel.*;

class HealthCare1_Test {

    @Test
    void testHealthCare1() {
        final InputParameterModel model = buildModel_HealthCare1_Correct(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testHealthCare1_Diagnose() {
        final InputParameterModel model = buildModel_HealthCare1_Incorrect(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testHealthCare1_Repair1() {
        final InputParameterModel repairedModel = buildModel_HealthCare1_Repair1(1);
        final InputParameterModel correctModel = buildModel_HealthCare1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare1_Repair2() {
        final InputParameterModel repairedModel = buildModel_HealthCare1_Repair2(1);
        final InputParameterModel correctModel = buildModel_HealthCare1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare1_Repair3() {
        final InputParameterModel repairedModel = buildModel_HealthCare1_Repair3(1);
        final InputParameterModel correctModel = buildModel_HealthCare1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare1_Repair4() {
        final InputParameterModel repairedModel = buildModel_HealthCare1_Repair4(1);
        final InputParameterModel correctModel = buildModel_HealthCare1_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testHealthCare1_DiagnosePerformance_Incorrect() {
        final InputParameterModel model = buildModel_HealthCare1_Incorrect(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }

    @Test
    void testHealthCare1_DiagnosePerformance_Correct() {
        final InputParameterModel model = buildModel_HealthCare1_Correct(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }
}
