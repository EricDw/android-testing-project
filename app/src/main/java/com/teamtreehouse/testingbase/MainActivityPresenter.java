package com.teamtreehouse.testingbase;

import android.graphics.Color;

/**
 * Created by Eric De Wildt on 2016-06-14.
 */

public class MainActivityPresenter {
    MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    public void editTextUpdated(String text){
        view.changeTextViewText(text);
    }

    public void colorSelected(int index){
        switch (index) {
            case 0:
                view.changeBackgroundColor(Color.WHITE);
                break;
            case 1:
                view.changeBackgroundColor(Color.MAGENTA);
                break;
            case 2:
                view.changeBackgroundColor(Color.GREEN);
                break;
            case 3:
                view.changeBackgroundColor(Color.CYAN);
                break;
        }
    }

    public void launchActivityButtonClicked(Class activity){
        view.launchOtherActivity(activity);
    }
}
