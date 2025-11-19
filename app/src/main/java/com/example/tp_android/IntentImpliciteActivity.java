package com.example.tp_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntentImpliciteActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CHOISIR_CONTACT = 1;
    private EditText etNumeroTelephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_implicite);

        // Initialiser les vues
        etNumeroTelephone = findViewById(R.id.et_numero_telephone);
        Button btnVisiterSite = findViewById(R.id.btn_visiter_site);
        Button btnComposerNumero = findViewById(R.id.btn_composer_numero);
        Button btnAfficherRepertoire = findViewById(R.id.btn_afficher_repertoire);
        Button btnChoisirContact = findViewById(R.id.btn_choisir_contact);
        Button btnRetourPrincipal = findViewById(R.id.btn_retour_principal);

        // 1. Visiter le site web - INTENT IMPLICITE
        btnVisiterSite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.polytecsousse.tn/"));
                startActivity(intent);
            }
        });

        // 2. Composer le numéro - INTENT IMPLICITE
        btnComposerNumero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String numero = etNumeroTelephone.getText().toString().trim();

                // Vérifier si le champ n'est pas vide
                if (numero.isEmpty()) {
                    Toast.makeText(IntentImpliciteActivity.this, "Veuillez entrer un numéro de téléphone", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Formater le numéro (ajouter tel:)
                String numeroFormate = "tel:" + numero;

                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(numeroFormate));
                startActivity(intent);
            }
        });

        // 3. Afficher le répertoire - INTENT IMPLICITE
        btnAfficherRepertoire.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
            }
        });

        // 4. Choisir un contact - INTENT IMPLICITE avec résultat
        btnChoisirContact.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts/people/"));
                startActivityForResult(intent, REQUEST_CODE_CHOISIR_CONTACT);
            }
        });

        // 5. Retour à l'activité principale
        btnRetourPrincipal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Méthode pour gérer le retour du choix de contact
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_CHOISIR_CONTACT && resultCode == RESULT_OK) {
            if (data != null) {
                Uri contactUri = data.getData();
                // Ici on pourrait récupérer les détails du contact, mais pour l'exemple on affiche juste un toast
                Toast.makeText(this, "Contact sélectionné avec succès", Toast.LENGTH_SHORT).show();
            }
        }
    }
}