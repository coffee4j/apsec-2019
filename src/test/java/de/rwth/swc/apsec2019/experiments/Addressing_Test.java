package de.rwth.swc.apsec2019.experiments;

import de.rwth.swc.coffee4j.model.InputParameterModel;
import org.junit.jupiter.api.Test;

import static de.rwth.swc.apsec2019.experiments.TestHelper.*;
import static de.rwth.swc.apsec2019.experiments.models.Addressing_TestModel.*;

class Addressing_Test {

    @Test
    void testAddressing() {
        final InputParameterModel model = buildModel_Addressing_Correct(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testAddressing_Diagnose() {
        final InputParameterModel model = buildModel_Addressing_Incorrect(1);

        runConflictDiagnosis(model);
    }

    @Test
    void testAddressing_Repair1() {
        final InputParameterModel repairedModel = buildModel_Addressing_Repair1(1);
        final InputParameterModel correctModel = buildModel_Addressing_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testAddressing_Repair2() {
        final InputParameterModel repairedModel = buildModel_Addressing_Repair2(1);
        final InputParameterModel correctModel = buildModel_Addressing_Correct(1);

        evaluateRepair(repairedModel, correctModel);
    }

    @Test
    void testAddressing_DiagnosePerformance_Incorrect() {
        final InputParameterModel model = buildModel_Addressing_Incorrect(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }

    @Test
    void testAddressing_DiagnosePerformance_Correct() {
        final InputParameterModel model = buildModel_Addressing_Correct(1);

        final double time = runPerformance(model);

        System.out.println(time + " ms.");
    }
}
