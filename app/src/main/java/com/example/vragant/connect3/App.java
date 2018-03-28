package com.example.vragant.connect3;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by fat_o on 27/03/2018.
 */

public class App {
    public static void finishApp(AppCompatActivity appCompatActivity) {
        appCompatActivity.finish();
    }

    public static void refreshApp(AppCompatActivity appCompatActivity) {
        appCompatActivity.recreate();
    }
}