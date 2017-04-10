/**
 * Created by theo on 04.04.17.
 */

Scenario: Main elements are displayed when open Calculator app

Given the calculator app is open
Then main elements should be displayed

Scenario: Main elements are preserved when we rotate display

Given the calculator app is open
When the user rotates display to landscape
Then main elements should be displayed
When the user rotates display to portrait
Then main elements should be displayed

Scenario: Test labels preserve values when tap ADD or SUB buttons

Given the calculator app is open
When the user taps the ADD button
Then label values are preserved
When the user taps the SUB button
Then label values are preserved

Scenario: Test ADD button functionality

Given the calculator app is open
When the user taps the ADD button
Then result displayed should be 1
When the user taps the ADD button again
Then result displayed should be 2

Scenario: Test SUB button functionality

Given the calculator app is open
When the user taps the SUB button
Then result displayed should be -1
When the user taps the SUB button again
Then result displayed should be -2

Scenario: Result should be preserved when rotating screen

Given the calculator app is open
When the user taps the SUB button
Then result displayed should be -1
When the user rotates display to landscape
Then result displayed should still be -1