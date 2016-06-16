package com.teamtreehouse.testingbase;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Eric De Wildt on 2016-06-14.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {
    MainActivity mMainActivity;

    @Before
    public void setUp() {
        mMainActivity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void editTextUpdatesTextView() throws Exception {
        //Arrange
        String givenString = "test123";
        mMainActivity.editText.setText(givenString);

        //Act
        mMainActivity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        //Assert
        String actualString = mMainActivity.textView.getText().toString();
        assertEquals(givenString, actualString);

    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        //Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        //Act
        mMainActivity.colorSpinner.setSelection(index);

        //Assert
        int actualColor = ((ColorDrawable)mMainActivity.linearLayout.getBackground()).getColor();
        assertEquals(givenColor, actualColor);
    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        //Arrange
        Class clazz = OtherActivity.class;
        Intent expectedIntent = new Intent(mMainActivity, clazz);
        //Act
        mMainActivity.launchActivityButton.callOnClick();
        ShadowActivity shadowActivity = Shadows.shadowOf(mMainActivity);
        //Assert
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(expectedIntent.filterEquals(actualIntent));
    }
}
