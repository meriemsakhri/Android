package com.example.tp_android;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class JeuActivity extends AppCompatActivity {
    private int nbr_essai = 1;
    private static final int MAX_ESSAI = 10;
    private static final String KEY_NBR_ESSAI = "nbr_essai";
    private static final String KEY_NOMBRE_MYSTERE = "nombre_mystere";

    private Button btnValider;
    private EditText Edt_nbr_user;
    private TextView txtNbrEssai;
    private TextView txtInfo;
    private int nombreMystere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu_constraint);

        // Lier les éléments graphiques aux variables Java
        Edt_nbr_user = findViewById(R.id.Edt_nombre_user);
        btnValider = findViewById(R.id.Btn_valider);
        txtNbrEssai = findViewById(R.id.Txt_nbr_essai);
        txtInfo = findViewById(R.id.Txt_info);

        // RESTAURATION de l'état (NOUVEAU CODE)
        if (savedInstanceState != null) {
            nbr_essai = savedInstanceState.getInt(KEY_NBR_ESSAI, 1);
            nombreMystere = savedInstanceState.getInt(KEY_NOMBRE_MYSTERE);
            Log.i("JeuActivity", "Restauration: essai=" + nbr_essai + ", nombre=" + nombreMystere);
        } else {
            // Générer un nouveau nombre seulement si pas de sauvegarde
            Random rand = new Random();
            nombreMystere = rand.nextInt(900) + 100;
        }

        Log.d("Jeu", "Nombre mystère = " + nombreMystere);

        // Mettre à jour l'affichage du nombre d'essais
        txtNbrEssai.setText("Tentative " + nbr_essai + "/" + MAX_ESSAI);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nbr = Edt_nbr_user.getText().toString();

                if (nbr.length() == 0) {
                    txtInfo.setText("Vous devez saisir un nombre");
                } else {
                    if (nbr_essai <= MAX_ESSAI) {
                        int nbr_saisi = Integer.parseInt(nbr);

                        if (nbr_saisi < 100 || nbr_saisi > 999) {
                            txtInfo.setText("Veuillez saisir un nombre entre 100 et 999");
                        } else {
                            if (nbr_saisi == nombreMystere) {
                                txtInfo.setText("Bravo! Vous avez deviné le nombre!");
                                btnValider.setEnabled(false);
                            } else {
                                nbr_essai++;
                                txtNbrEssai.setText("Tentative " + nbr_essai + "/" + MAX_ESSAI);

                                if (nbr_essai > MAX_ESSAI) {
                                    txtInfo.setText("Échec, limite atteinte. Le nombre était " + nombreMystere);
                                    btnValider.setEnabled(false);
                                } else {
                                    txtInfo.setText("Nombre incorrect, essayez encore.");
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    // SAUVEGARDE de l'état (NOUVELLE MÉTHODE)
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_NBR_ESSAI, nbr_essai);
        outState.putInt(KEY_NOMBRE_MYSTERE, nombreMystere);
        Log.i("JeuActivity", "Sauvegarde: essai=" + nbr_essai + ", nombre=" + nombreMystere);
    }
}