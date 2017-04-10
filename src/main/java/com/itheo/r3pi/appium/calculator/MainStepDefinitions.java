package com.itheo.r3pi.appium.calculator;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.ScreenOrientation;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by theo on 04.04.17.
 */
public class MainStepDefinitions {

    @Steps
    private MainSteps mainSteps;

    private final static String ADD_TEXT = "Islam_Hamdy";
    private final static String SUB_TEXT = "Sarah Osama";
    private final static String RESULT_TEXT = "new number =";

    @Given("the calculator app is open")
    public void openApp () {
    }

    @When("the user rotates display to $orientation")
    public void rotateDisplayTo (String orientation) {
        switch (orientation.toUpperCase()) {
            case "LANDSCAPE":
                mainSteps.rotateTo(ScreenOrientation.LANDSCAPE);
            case "PORTRAIT":
                mainSteps.rotateTo(ScreenOrientation.PORTRAIT);
        }
    }

    @When("the user taps $button {button|again|}")
    public void tapButton (String button) {
        switch (button.toUpperCase()) {
            case "ADD":
                mainSteps.tapAdd();
            case "SUB":
                mainSteps.tapSub();
        }
    }

    @Then("main elements should be displayed")
    public void shouldDisplayMainElements () {
        assertThat(mainSteps.isAddButtonDisplayed()).isTrue();
        assertThat(mainSteps.isSubButtonDisplayed()).isTrue();
        assertThat(mainSteps.getDisplay1()).isEqualTo(ADD_TEXT);
        assertThat(mainSteps.getDisplay2()).isEqualTo(SUB_TEXT);
    }

    @Then(("label values are preserved"))
    public void shouldPreserveLabelsText () {
        assertThat(mainSteps.getDisplay1()).isEqualTo(ADD_TEXT);
        assertThat(mainSteps.getDisplay2()).isEqualTo(SUB_TEXT);
    }

    @Then("result displayed should {still|be|} $result")
    public void shouldDisplayResult (String result)
    {
        assertThat(mainSteps.getDisplay2()).isEqualTo(RESULT_TEXT + result);
    }
}
