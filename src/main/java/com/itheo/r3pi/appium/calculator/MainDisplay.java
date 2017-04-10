package com.itheo.r3pi.appium.calculator;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


/**
 * Created by theo on 04.04.17.
 */
public class MainDisplay extends GenericPage {

    @FindBy(id = "tv1")
    private WebElementFacade display1;

    @FindBy(id = "tv2")
    private WebElementFacade display2;

    @FindBy(id = "add_b")
    private WebElementFacade addButton;

    @FindBy(id = "sub_b")
    private WebElementFacade subButton;

    public String getDisplay1 () {
        return display1.then().getText();
    }

    public String getDisplay2 () {
        return display2.then().getText();
    }

    public boolean isAddButtonDisplayed () {
        return addButton.isDisplayed();
    }

    public void touchAdd () {
        addButton.then().click();
    }

    public boolean isSubButtonDisplayed () {
        return subButton.isDisplayed();
    }

    public void touchSub () {
        subButton.then().click();
    }
}
