package exampleTableJBehabe.steps;


import exampleTableJBehabe.Calc;
import org.jbehave.core.annotations.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalcSteps {
    private Calc testCalc;
    private double result;
    private boolean booleanResult;

    @BeforeScenario(uponType = ScenarioType.ANY)
    public void welcome() {
        System.out.println("Siema. Tutaj testuje.");
    }

    @AfterScenario(uponType = ScenarioType.ANY)
    public void success() {
        if (result != 0)
            System.out.println("Dzialanie przebieglo pomyslnie.");
    }
    @AfterScenario(uponType = ScenarioType.ANY)
    public void fail() {
        if (result == 0){
            System.out.println("Cos?? Cos nie zadzialalo.");
        }
    }

    @Given("Wytwarzam nowy kalkulator")
    @Alias("Wytwarzam kolejny kalkulator")
    public void givenWytwarzamNowyKalkulator(){
        testCalc = new Calc();
    }


    @When("dodam liczby <value1> i <value2>")
    public void whenDodamLiczbyvalue1Ivalue2(@Named("value1") double a,
                                         @Named("value2") double b) {
        result = testCalc.add(a, b);
    }
    @When("odejmuje liczby <value1> i <value2>")
    public void whenOdejmujeLiczbyvalue1Ivalue2(@Named("value1") double a,
                                            @Named("value2") double b) {
        result = testCalc.sub(a, b);
    }
    @Then("wynik wyniesie <resultValue>")
    @Alias("wynik bedzie wynosil <resultValue>")
    public void thenWynikWyniesieResultValue(@Named("resultValue") double resultValue) {
        assertEquals(resultValue, result);
    }
}
