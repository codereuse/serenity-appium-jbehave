package com.itheo.r3pi.appium.calculator;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;

import static com.google.common.truth.Truth.assertThat;


/**
 * Created by theo on 04.04.17.
 */
@RunWith(SerenityRunner.class)
public class R3piSmokeTest {

    @Managed()
    private WebDriver driver;

    @Steps
    private MainSteps mainSteps;

    private final static String ADD_TEXT = "Islam_Hamdy";
    private final static String SUB_TEXT = "Sarah Osama";
    private final static String RESULT_TEXT = "new number =";

    @Test
    public void testMainElementsAreDisplayedWhenOpenApp () {
        assertThat(mainSteps.isAddButtonDisplayed()).isTrue();
        assertThat(mainSteps.isSubButtonDisplayed()).isTrue();
        assertThat(mainSteps.getDisplay1()).isEqualTo(ADD_TEXT);
        assertThat(mainSteps.getDisplay2()).isEqualTo(SUB_TEXT);
    }

    @Test
    public void testMainElementsPreservedWhenRotateDisplay () {
        mainSteps.rotateTo(ScreenOrientation.LANDSCAPE);
        assertThat(mainSteps.isAddButtonDisplayed()).isTrue();
        assertThat(mainSteps.isSubButtonDisplayed()).isTrue();
        assertThat(mainSteps.getDisplay1()).isEqualTo(ADD_TEXT);
        assertThat(mainSteps.getDisplay2()).isEqualTo(SUB_TEXT);

        mainSteps.rotateTo(ScreenOrientation.PORTRAIT);
        assertThat(mainSteps.isAddButtonDisplayed()).isTrue();
        assertThat(mainSteps.isSubButtonDisplayed()).isTrue();
        assertThat(mainSteps.getDisplay1()).isEqualTo(ADD_TEXT);
        assertThat(mainSteps.getDisplay2()).isEqualTo(SUB_TEXT);
    }


    @Test
    public void testLabelsPreserveValueOnButtonActions () {
        mainSteps.tapAdd();
        assertThat(mainSteps.getDisplay1()).isEqualTo(ADD_TEXT);
        assertThat(mainSteps.getDisplay2()).isEqualTo(SUB_TEXT);

        mainSteps.tapSub();
        assertThat(mainSteps.getDisplay1()).isEqualTo(ADD_TEXT);
        assertThat(mainSteps.getDisplay2()).isEqualTo(SUB_TEXT);
    }

    @Test
    public void testAddButton () {
        mainSteps.tapAdd();
        assertThat(mainSteps.getDisplay2()).isEqualTo(RESULT_TEXT + "1");
        mainSteps.tapAdd();
        assertThat(mainSteps.getDisplay2()).isEqualTo(RESULT_TEXT + "2");
    }

    @Test
    public void testSubButton () {
        mainSteps.tapSub();
        assertThat(mainSteps.getDisplay2()).isEqualTo(RESULT_TEXT + "-1");
        mainSteps.tapSub();
        assertThat(mainSteps.getDisplay2()).isEqualTo(RESULT_TEXT + "-2");
    }

    @Test
    public void testResultIsPreservedOnRotatingScreen () {
        mainSteps.tapAdd();
        assertThat(mainSteps.getDisplay2()).isEqualTo(RESULT_TEXT + "1");
        mainSteps.rotateTo(ScreenOrientation.LANDSCAPE);
        assertThat(mainSteps.getDisplay2()).isEqualTo(RESULT_TEXT + "1");
    }
}
