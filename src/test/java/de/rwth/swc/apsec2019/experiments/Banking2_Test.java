package de.rwth.swc.apsec2019.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Test;

import static de.rwth.swc.apsec2019.experiments.TestHelper.*;
import static de.rwth.swc.apsec2019.experiments.models.Banking2_TestModel.*;

class Banking2_Test {

    @Test
    void testBanking2() {
        final InputParameterModel model = buildModel_Banking2_Correct(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testBanking2_Diagnose() {
        final InputParameterModel model = buildModel_Banking2_Incorrect(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testBanking2_Repair1() {
        final InputParameterModel repairedModel = buildModel_Banking2_Repair1(1);
        final InputParameterModel correctModel = buildModel_Banking2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking2_Repair2() {
        final InputParameterModel repairedModel = buildModel_Banking2_Repair2(1);
        final InputParameterModel correctModel = buildModel_Banking2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking2_Repair3() {
        final InputParameterModel repairedModel = buildModel_Banking2_Repair3(1);
        final InputParameterModel correctModel = buildModel_Banking2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking2_Repair4() {
        final InputParameterModel repairedModel = buildModel_Banking2_Repair4(1);
        final InputParameterModel correctModel = buildModel_Banking2_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testBanking2_DiagnosePerformance_Incorrect() {
        final InputParameterModel model = buildModel_Banking2_Incorrect(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }

    @Test
    void testBanking2_DiagnosePerformance_Correct() {
        final InputParameterModel model = buildModel_Banking2_Correct(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }
}
