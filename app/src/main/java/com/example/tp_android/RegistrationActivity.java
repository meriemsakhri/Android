package com.example.tp_android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {
    private EditText editNom;
    private EditText editTelephone;
    private RadioGroup radioGroupParcours;
    private CheckBox checkboxClub1;
    private CheckBox checkboxClub2;
    private CheckBox checkboxClub3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize views
        editNom = findViewById(R.id.edit_nom);
        editTelephone = findViewById(R.id.edit_telephone);
        radioGroupParcours = findViewById(R.id.radio_group_parcours);
        checkboxClub1 = findViewById(R.id.checkbox_club1);
        checkboxClub2 = findViewById(R.id.checkbox_club2);
        checkboxClub3 = findViewById(R.id.checkbox_club3);

        // Setup button click listener
        Button btnValider = findViewById(R.id.btn_valider);
        btnValider.setOnClickListener(v -> {
            validerDonnees();
        });
    }

    private void validerDonnees() {
        // Récupération et validation des données
        String nomComplet = editNom.getText().toString().trim();
        String telephone = editTelephone.getText().toString().trim();

        // Validation du nom
        if (nomComplet.isEmpty()) {
            editNom.setError("Veuillez saisir votre nom et prénom");
            return;
        } else {
            editNom.setError(null); // Clear error if valid
        }

        // Validation du téléphone
        if (telephone.isEmpty()) {
            editTelephone.setError("Veuillez saisir votre numéro de téléphone");
            return;
        } else {
            editTelephone.setError(null); // Clear error if valid
        }

        // Récupération et validation du parcours
        int selectedId = radioGroupParcours.getCheckedRadioButtonId();
        String parcoursChoisi = "Non sélectionné";

        if (selectedId != -1) {
            if (selectedId == R.id.radio_parcours_gl) {
                parcoursChoisi = "GL";
            } else if (selectedId == R.id.radio_parcours_ia) {
                parcoursChoisi = "IA";
            } else if (selectedId == R.id.radio_parcours_iot) {
                parcoursChoisi = "IOT";
            } else if (selectedId == R.id.radio_parcours_ds) {
                parcoursChoisi = "DS";
            }
        } else {
            // Aucun parcours sélectionné
            Toast.makeText(this, "Veuillez sélectionner un parcours", Toast.LENGTH_SHORT).show();
            return;
        }

        // Récupération des clubs sélectionnés
        StringBuilder clubsChoisis = new StringBuilder();

        if (checkboxClub1.isChecked()) {
            clubsChoisis.append("CLUB 1, ");
        }
        if (checkboxClub2.isChecked()) {
            clubsChoisis.append("CLUB 2, ");
        }
        if (checkboxClub3.isChecked()) {
            clubsChoisis.append("CLUB 3, ");
        }

        String clubs = "";
        if (clubsChoisis.length() > 0) {
            clubs = clubsChoisis.substring(0, clubsChoisis.length() - 2);
        } else {
            clubs = "Aucun club sélectionné";
        }

        // If we reach here, all fields are valid
        String messageFinal = "Inscription validée!\n" +
                "Nom: " + nomComplet + "\n" +
                "Téléphone: " + telephone + "\n" +
                "Parcours: " + parcoursChoisi + "\n" +
                "Clubs: " + clubs;

        // PARTIE 3: Utilisation des boites de dialogues

        // Étape 1: Instanciation d'un objet de type AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationActivity.this);

        // Étape 2: Configuration de l'objet et le personnaliser
        builder.setTitle("Confirmation d'inscription")  // b. Spécification du Titre
                .setMessage(messageFinal)                // c. Spécification du message
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Traitement à faire - User confirmed
                        dialog.dismiss(); // Fermer la boite de dialogue
                    }
                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        dialog.dismiss(); // Fermer la boite de dialogue
                    }
                });

        // Étape 3: Création de l'objet alertdialog
        AlertDialog dialog = builder.create();

        // Étape 4: Affichage de l'objet
        dialog.show();
    }
}