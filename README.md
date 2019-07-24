This is the companion website to the paper **Semi-Automatic Repair of Over-Constrained Models for Combinatorial Robustness Testing** by Konrad Fögen and Horst Lichter. It is submitted to the 26th Asia-Pacific Software Engineering Conference [(APSEC-2019)](https://seminar.utmspace.edu.my/apsec2019/index.html) and currently in review.

- *src/main/java/de/rwth/swc/apsec2019* contains source code which implements the system models used for experimentation
- *src/test/java/de/rwth/swc/apsec2019/experiments* contains the test to execute the experiment
- *src/test/java/de/rwth/swc/apsec2019/example* contains an example test to illustrate the usage of **@EnableConflictDetection**
- *results* contains the results from an execution of the tests

To obtain more detailed reports, the test methods must be executed either individually in the IDE or via `mvn clean test`. Please keep in mind that executing all scenarios might take some time. 

Reference implementations of the algorithms presented in the paper are also published. See https://coffee4j.github.io/ for more information.

```java
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
}```

