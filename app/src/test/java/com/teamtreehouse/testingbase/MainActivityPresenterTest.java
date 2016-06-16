package com.teamtreehouse.testingbase;

import android.graphics.Color;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by Eric De Wildt on 2016-06-15.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    MainActivityPresenter mMainActivityPresenter;

    @Mock
    MainActivityView mMainActivityView;

    @Before
    public void setUp() throws Exception {

        mMainActivityPresenter = new MainActivityPresenter(mMainActivityView);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void editTextUpdated() throws Exception {
        //Arrange
        String givienString = "test123";

        //Act
        mMainActivityPresenter.editTextUpdated(givienString);

        //Assert
        Mockito.verify(mMainActivityView).changeTextViewText(givienString);
    }

    @Test
    public void colorSelected() throws Exception {
        //Arrange
        int index = 2;
        int givenColor = Color.GREEN;

        //Act
        mMainActivityPresenter.colorSelected(index);

        //Assert
        Mockito.verify(mMainActivityView).changeBackgroundColor(givenColor);
    }

    @Test
    public void launchActivityButtonClicked() throws Exception {
        //Arrange
        Class clazz = OtherActivity.class;

        //Act
        mMainActivityPresenter.launchActivityButtonClicked(clazz);

        //Assert
        Mockito.verify(mMainActivityView).launchOtherActivity(clazz);
    }

}