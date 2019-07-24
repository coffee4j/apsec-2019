package de.rwth.swc.apsec2019.example;

import de.rwth.swc.coffee4j.engine.generator.ipog.Ipog;
import de.rwth.swc.coffee4j.engine.generator.ipogneg.IpogNeg;
import de.rwth.swc.coffee4j.junit.CombinatorialTest;
import de.rwth.swc.coffee4j.junit.provider.configuration.diagnosis.EnableConflictDetection;
import de.rwth.swc.coffee4j.junit.provider.configuration.generator.Generator;
import de.rwth.swc.coffee4j.junit.provider.model.ModelFromMethod;
import de.rwth.swc.coffee4j.model.InputParameterModel;

import static de.rwth.swc.coffee4j.model.InputParameterModel.inputParameterModel;
import static de.rwth.swc.coffee4j.model.Parameter.parameter;
import static de.rwth.swc.coffee4j.model.constraints.ConstraintBuilder.constrain;

class ExampleTest {

    @CombinatorialTest
    @ModelFromMethod("model")
    @Generator({Ipog.class, IpogNeg.class})
    /* Enable Constraint Diagnosis but do not skip generation if conflicts are detected */
    @EnableConflictDetection(shouldAbort = false, explainConflicts = true, diagnoseConflicts = true)
    void testExample(String title, String givenName, String familyName) {
        /* Stimulate the System under Test */
    }

    static InputParameterModel model() {
        return inputParameterModel("example")
                .parameters(
                        parameter("Title").values("Mr", "Mrs", "123"),
                        parameter("GivenName").values("John", "Jane", "123"),
                        parameter("FamilyName").values("Doe", "123")
                ).errorConstraints(
                        constrain("Title").withName("valid-title")
                                .by((String title) -> !title.equals("123")),
                        constrain("GivenName").withName("valid-firstname")
                                .by((String givenName) -> !givenName.equals("123")),
                        constrain("FamilyName").withName("valid-givenname")
                                .by((String familyName) -> !familyName.equals("123")),
                        constrain("Title", "GivenName").withName("valid-mr")
                                .by((String title, String givenName) ->
                                        !(title.equals("Mr") && givenName.equals("Jane"))
                                     && !(title.equals("Mr") && givenName.equals("123"))),
                        constrain("Title", "GivenName").withName("valid-mrs")
                                .by((String title, String givenName) ->
                                        !(title.equals("Mrs") && givenName.equals("John"))
                                     && !(title.equals("Mrs") && givenName.equals("123")))
                )
               .build();
    }
}
