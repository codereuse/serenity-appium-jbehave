package com.itheo.r3pi.appium.calculator;

import net.serenitybdd.jbehave.SerenityStories;

/**
 * Created by theo on 04.04.17.
 */
public class R3piStories extends SerenityStories {
    public R3piStories () {
        findStoriesCalled("R3piSmokeTest.story");
    }
}
