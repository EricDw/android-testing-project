package com.teamtreehouse.testingbase;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.LinearLayout;

import org.hamcrest.Description;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by Eric De Wildt on 2016-06-15.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void editTextUpdatesTextView() throws Exception {
        // Arrange
        String givenString = "test123";
        onView(withId(R.id.editText)).perform(typeText(givenString));

        // Act
        onView(withId(R.id.editText)).perform(pressImeActionButton());

        // Assert
        onView(withId(R.id.textView)).check(matches(withText(givenString)));
    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        // Arrange
        final int givenColor = Color.GREEN;
        String spinnerItemText = "Green";

        // Act
        onView(withId(R.id.colorSpinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)),is(spinnerItemText))).perform(click());


        // Assert
        BoundedMatcher<View, LinearLayout> backGroundColorMather = new BoundedMatcher<View, LinearLayout>(LinearLayout.class) {
            @Override
            protected boolean matchesSafely(LinearLayout linearLayout) {
                int actualColor = ((ColorDrawable)linearLayout.getBackground()).getColor();
                return givenColor == actualColor;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("background color should equal: " + givenColor);
            }
        };

        onView(withId(R.id.linearLayout)).check(matches(backGroundColorMather));

    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        // Arrange
        String otherActivityString = "Other Activity";

        // Act
        onView(withId(R.id.launchActivityButton)).perform(click());

        // Assert
        onView(withText(otherActivityString)).check(matches(notNullValue()));

    }
}
