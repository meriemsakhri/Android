package com.example.tp3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

// Déclaration de l’activité principale du jeu
public class JeuActivity extends AppCompatActivity {

    // Déclaration des variables pour les éléments graphiques
    private Button btnValider; // Bouton pour valider la saisie
    private EditText Edt_nbr_user; // Champ de saisie du nombre par l’utilisateur

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Liaison de l’activité avec son layout XML
        setContentView(R.layout.activity_jeu_constraint);

        // Association des éléments graphiques aux variables Java
        Edt_nbr_user = findViewById(R.id.Edt_nombre_user);
        btnValider = findViewById(R.id.Btn_valider);

        // Définition de l’action lors du clic sur le bouton "VERIFIER"
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                // Récupération du texte saisi par l’utilisateur
                String nbr = Edt_nbr_user.getText().toString();
                // Vérification si le champ est vide
                if(nbr.length() == 0)
                    Log.e("Jeu","Vous devez saisir un nombre"); // Message d’erreur dans le log
                else {
                    // Conversion du texte en entier
                    int nbr_saisi = Integer.parseInt(nbr);
                    // Vérification que le nombre est bien compris entre 100 et 999
                    if(nbr_saisi < 100 || nbr_saisi > 999)
                        Log.e("Jeu","veuillez saisir un nombre : 100..999"); // Message d’erreur
                    else
                        // Affichage du nombre saisi dans le log (valide)
                        Log.e("Jeu","Nombre saisi est =" +nbr_saisi);
                }
            }
        });
    }

}