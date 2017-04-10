package com.itheo.r3pi.appium.calculator;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.ScreenOrientation;

/**
 * Created by theo on 04.04.17.
 */
public class GenericPage extends PageObject {

    public void rotateScreenTo (ScreenOrientation screenOrientation) {
        ((AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).rotate(screenOrientation);
    }
}
