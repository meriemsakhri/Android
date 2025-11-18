package com.example.tp_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;


public class ListelntentActivity extends AppCompatActivity {
    Button btnIntentExplicite, btnCalculatrice, btnIntentImplicite, btnFermer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listelntent);

        btnIntentExplicite = findViewById(R.id.btn_intent_explicite);
        btnCalculatrice = findViewById(R.id.btn_calculatrice);
        btnIntentImplicite = findViewById(R.id.btn_intent_implicite);
        btnFermer = findViewById(R.id.btn_fermer);

        // Intent Explicite Button - va à IntentSimpleRetourActivity
        btnIntentExplicite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(
                        ListelntentActivity.this,
                        IntentSimpleRetourActivity.class
                );
                startActivity(intent);
            }
        });


    }
}