package Testowanko.steps;


import Testowanko.Calc.Calc;
import org.jbehave.core.annotations.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySteps {
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
    public void wytwarzamNowyKalkulator(){
        testCalc = new Calc();
    }
    @When("dodam liczby 3i7")
    public void dodamLiczby3i7(){
        result = testCalc.add(3, 7);
    }
    @Then("wynik wyniesie 10")
    public void wynikWyniesie10(){
        assertEquals(10, result);
    }

    @When("odejme liczby 12i3")
    public void odejmeLiczby12i3(){
        result = testCalc.sub(12,3);
    }
    @Then("wynik wyniesie 9")
    public void wynikWyniesie9(){
        assertEquals(9, result);
    }

    @When("pomnoze liczby 15i3")
    public void pomnozeLiczby15i3(){
        result = testCalc.multi(15,3);
    }
    @Then("wynik wyniesie 45")
    public void wynikWyniesie45(){
        assertEquals(45, result);
    }

    @When("podziele liczby 15i4")
    public void podzieleLiczby15i4(){
        result = testCalc.div(15,4);
    }
    @Then("wynik wyniesie 3.75")
    public void wynikWyniesie3_75(){
        assertEquals(3.75, result);
    }

    @When("dodam liczby <value1> i <value2>")
    public void dodamLiczbyvalue1Ivalue2(@Named("value1") double a,
                                           @Named("value2") double b) {
        result = testCalc.add(a, b);
    }
    @When("odejmuje liczby <value1> i <value2>")
    public void odejmujeLiczbyvalue1Ivalue2(@Named("value1") double a,
                                           @Named("value2") double b) {
        result = testCalc.sub(a, b);
    }
    @Then("wynik wyniesie <resultValue>")
    @Alias("wynik bedzie wynosil <resultValue>")
    public void wynikWyniesieResultValue(@Named("resultValue") double resultValue) {
        assertEquals(resultValue, result);
    }

    @When("porownam czy 5 wiekszy od 2")
    public void porownamCzy5WiekszyOd2(){
        booleanResult = testCalc.greater(5, 2);
    }
    @Then("jezeli wiekszy zwracam true")
    public void jezeliWiekszyZwracamTrue(){
        assertTrue(booleanResult);
    }
    @Then("jezeli mniejszy zwracam false")
    public void jezeliMniejszyZwracamFalse(){
        assertFalse(booleanResult);
    }
}
