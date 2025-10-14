package com.example.tp3;

import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;


public class LiveCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_cycle);
        Log.e("LiveCycleActivity", "On est dans l'état onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("LiveCycleActivity", "On est dans l'état onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("LiveCycleActivity", "On est dans l'état onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("LiveCycleActivity", "On est dans l'état onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("LiveCycleActivity", "On est dans l'état onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("LiveCycleActivity", "On est dans l'état onDestroy");
    }
}