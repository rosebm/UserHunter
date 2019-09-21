package com.rosalyn.userhunter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.rosalyn.userhunter.Activities.MenuActivity;

public class MainActivity extends AppCompatActivity {
    private String _TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Thread.sleep(2000);
        }catch(InterruptedException ie){
            Log.e(_TAG, "Error: " + ie.getMessage());
        }
        callMenuScreen();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(MainActivity.this);
    }

    /**
     * Calls Menu Screen
     */
    protected void callMenuScreen(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
