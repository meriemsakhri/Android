package com.example.tp_android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LiveCycleActivity extends AppCompatActivity {

    private static final String TAG = "LifeCycle";
    private static final String KEY_COMPTEUR = "compteur"; // Clé pour sauvegarder le compteur
    private TextView txtCompteur;
    private Button btnIncrementer;
    private int cpt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_cycle);

        txtCompteur = findViewById(R.id.TXT_Compteur);
        btnIncrementer = findViewById(R.id.BTN_Incrementer);

        if (savedInstanceState != null) {
            cpt = savedInstanceState.getInt(KEY_COMPTEUR, 0);
            txtCompteur.setText("Compteur = " + cpt);

        }
        // Gestion du clic sur le bouton
        btnIncrementer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cpt++;
                txtCompteur.setText("Compteur = " + cpt);
            }
        });

        Log.i(TAG, "Activité onCreate");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COMPTEUR, cpt);
        Log.i(TAG, "SAUVEGARDE: cpt = " + cpt);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Activité onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Activité onResume");
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "Activité onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "Activité onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "Activité onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "Activité onRestart");
    }
}