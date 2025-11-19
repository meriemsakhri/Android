package com.example.tp_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalculerActivity extends AppCompatActivity {

    private TextView tvValeurA, tvValeurB, tvResultatCalc;
    private Button btnRetourResultat;

    private double nombreA, nombreB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculer);

        tvValeurA = findViewById(R.id.tv_valeur_a);
        tvValeurB = findViewById(R.id.tv_valeur_b);
        tvResultatCalc = findViewById(R.id.tv_resultat_calc);
        btnRetourResultat = findViewById(R.id.btn_retour_resultat);

        // Récupérer les données passées depuis CalculatriceActivity
        Intent intent = getIntent();
        if (intent != null) {
            nombreA = intent.getDoubleExtra("NOMBRE_A", 0);
            nombreB = intent.getDoubleExtra("NOMBRE_B", 0);

            // Afficher les valeurs
            tvValeurA.setText("Valeur A = " + nombreA);
            tvValeurB.setText("Valeur B = " + nombreB);

            // Effectuer le calcul (addition pour l'exemple)
            double resultat = nombreA + nombreB;
            tvResultatCalc.setText("Somme = " + resultat);
        }

        btnRetourResultat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Retourner le résultat à CalculatriceActivity
                double resultat = nombreA + nombreB;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("RESULTAT", resultat);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}