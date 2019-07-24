package de.rwth.swc.apsec2019.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Test;

import static de.rwth.swc.apsec2019.experiments.TestHelper.*;
import static de.rwth.swc.apsec2019.experiments.models.Registration_TestModel.*;

class Registration_Test {

    @Test
    void testRegistration() {
        final InputParameterModel model = buildModel_Registration_Correct(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testRegistration_Diagnose() {
        final InputParameterModel model = buildModel_Registration_Incorrect(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testRegistration_Repair1() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair1(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair2() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair2(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair3() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair3(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair4() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair4(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair5() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair5(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair6() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair6(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair7() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair7(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair8() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair8(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair9() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair9(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair10() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair10(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair11() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair11(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair12() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair12(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair13() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair13(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair14() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair14(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair15() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair15(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair16() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair16(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair17() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair17(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair18() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair18(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair19() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair19(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair20() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair20(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair21() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair21(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair22() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair22(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair23() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair23(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair24() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair24(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair25() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair25(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair26() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair26(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair27() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair27(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair28() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair28(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair29() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair29(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair30() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair30(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair31() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair31(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_Repair32() {
        final InputParameterModel repairedModel = buildModel_Registration_Repair32(1);
        final InputParameterModel correctModel = buildModel_Registration_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testRegistration_DiagnosePerformance_Incorrect() {
        final InputParameterModel model = buildModel_Registration_Incorrect(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }

    @Test
    void testRegistration_DiagnosePerformance_Correct() {
        final InputParameterModel model = buildModel_Registration_Correct(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }
}
