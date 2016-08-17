package com.example.user.helloandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by user on 15/08/2016.
 */
public class HelloAndroid extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Hello Android:", "on create has been called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void clicker(){
        Log.d("Click","CLICK CLICK CLICK");
    }

}
