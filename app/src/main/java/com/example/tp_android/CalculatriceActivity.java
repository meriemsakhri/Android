package com.example.tp_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatriceActivity extends AppCompatActivity {

    private EditText etNombreA, etNombreB;
    private Button btnCalculer;
    private TextView tvResultat;

    private static final int REQUEST_CODE_CALCUL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        etNombreA = findViewById(R.id.et_nombre_a);
        etNombreB = findViewById(R.id.et_nombre_b);
        btnCalculer = findViewById(R.id.btn_calculer);
        tvResultat = findViewById(R.id.tv_resultat);

        btnCalculer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Vérifier si les champs ne sont pas vides
                if (etNombreA.getText().toString().isEmpty() || etNombreB.getText().toString().isEmpty()) {
                    Toast.makeText(CalculatriceActivity.this, "Veuillez remplir les deux nombres", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Récupérer les valeurs
                double nombreA = Double.parseDouble(etNombreA.getText().toString());
                double nombreB = Double.parseDouble(etNombreB.getText().toString());

                // Créer l'intent et passer les données
                Intent intent = new Intent(CalculatriceActivity.this, CalculerActivity.class);
                intent.putExtra("NOMBRE_A", nombreA);
                intent.putExtra("NOMBRE_B", nombreB);

                // Démarrer l'activité en attendant un résultat
                startActivityForResult(intent, REQUEST_CODE_CALCUL);
            }
        });

        Button btnFermer = findViewById(R.id.btn_fermer);
        btnFermer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Cette méthode est appelée quand CalculerActivity retourne un résultat
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CALCUL && resultCode == RESULT_OK) {
            if (data != null) {
                double resultat = data.getDoubleExtra("RESULTAT", 0);
                tvResultat.setText("Résultat = " + resultat);
            }
        }
    }
}