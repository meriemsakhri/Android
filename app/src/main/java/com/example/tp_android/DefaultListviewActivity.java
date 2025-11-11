package com.example.tp_android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;

public class DefaultListviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_listview);

        // 1. création d'un objet listview qui pointe sur l'objet listview du layout récupération
        ListView listView = (ListView) findViewById(R.id.listView1);

        // 2. création des valeurs à afficher dans un tableau de chaine de caractère
        String[] villes = { "Sousse", "Mahdia", "Tunis", "Gabes", "Jerba", "Kef", "Monastir", "Gaïsa", "Nabeul", "Ariana" };

        // 3. Définition de l'adapter qui va relier la listview avec les éléments du tableau à afficher
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                villes
        );

        // 4. on assigne l'adapter à notre liste
        listView.setAdapter(adapter);

        // 5. Récupération de l'élément sélectionné
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // l'index de l'item dans notre ListView
                int itemPosition = position;

                // On récupère le texte de l'item cliqué
                String itemValue = (String) listView.getItemAtPosition(position);

                // On affiche ce texte avec un Toast
                Toast.makeText(getApplicationContext(),
                        "Position : " + itemPosition + " Element : " + itemValue,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}