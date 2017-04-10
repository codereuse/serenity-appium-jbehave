package com.itheo.r3pi.appium.calculator;

import org.openqa.selenium.ScreenOrientation;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by theo on 04.04.17.
 */
public class MainSteps extends ScenarioSteps {

    private MainDisplay mainDisplay;

    @Step
    public void tapAdd() {
        mainDisplay.touchAdd();
    }

    @Step
    public boolean isAddButtonDisplayed() {
        return mainDisplay.isAddButtonDisplayed();
    }

    @Step
    public void tapSub() {
        mainDisplay.touchSub();
    }

    @Step
    public boolean isSubButtonDisplayed() {
        return mainDisplay.isSubButtonDisplayed();
    }

    @Step
    public String getDisplay1() {
        return mainDisplay.getDisplay1();
    }

    @Step
    public String getDisplay2() {
        return mainDisplay.getDisplay2();
    }

    @Step
    public void rotateTo(ScreenOrientation screenOrientation) {
        mainDisplay.rotateScreenTo(screenOrientation);
    }
}
