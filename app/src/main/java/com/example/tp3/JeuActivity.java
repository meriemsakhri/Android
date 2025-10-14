package com.example.tp3;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

// Déclaration de l’activité principale du jeu
public class JeuActivity extends AppCompatActivity {
    private int nbr_essai = 1;
    private static final int MAX_ESSAI = 10;

    // Déclaration des variables pour les éléments graphiques
    private Button btnValider;       // Bouton pour valider la saisie
    private EditText Edt_nbr_user;   // Champ de saisie du nombre par l’utilisateur
    private TextView txtNbrEssai;    // Affiche le nombre de tentatives
    private TextView txtInfo;        // Affiche les messages d'erreur ou succès
    private int nombreMystere;       // The random number to guess

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu_constraint);

        // Lier les éléments graphiques aux variables Java
        Edt_nbr_user = findViewById(R.id.Edt_nombre_user);
        btnValider = findViewById(R.id.Btn_valider);
        txtNbrEssai = findViewById(R.id.Txt_nbr_essai);
        txtInfo = findViewById(R.id.Txt_info); // NEW

        // Générer le nombre aléatoire
        Random rand = new Random();
        nombreMystere = rand.nextInt(900) + 100; // 100..999
        Log.d("Jeu", "Nombre mystère (for testing) = " + nombreMystere);
        // Initialiser le texte de la tentative
        // txtNbrEssai.setText("Tentative " + nbr_essai + "/" + MAX_ESSAI);

        // Définition de l’action lors du clic sur le bouton "VERIFIER"
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nbr = Edt_nbr_user.getText().toString();

                if (nbr.length() == 0) {
                    txtInfo.setText("Vous devez saisir un nombre"); // show message
                } else {
                    if (nbr_essai <= MAX_ESSAI) {
                        int nbr_saisi = Integer.parseInt(nbr);

                        if (nbr_saisi < 100 || nbr_saisi > 999) {
                            txtInfo.setText("Veuillez saisir un nombre entre 100 et 999");
                        } else {
                            if (nbr_saisi == nombreMystere) {
                                txtInfo.setText("Bravo! Vous avez deviné le nombre!");
                                btnValider.setEnabled(false); // Stop further attempts
                            } else {
                                nbr_essai++;
                                txtNbrEssai.setText("Tentative " + nbr_essai + "/" + MAX_ESSAI);

                                if (nbr_essai > MAX_ESSAI) {
                                    txtNbrEssai.setText("Échec, vous avez atteint la limite de tentative. Le nombre était " + nombreMystere);
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
}
