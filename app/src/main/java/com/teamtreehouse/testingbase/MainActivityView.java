package com.teamtreehouse.testingbase;

/**
 * Created by Eric De Wildt on 2016-06-14.
 */

public interface MainActivityView {

    void changeTextViewText(String text);
    void changeBackgroundColor(int color);
    void launchOtherActivity(Class activity);

}
