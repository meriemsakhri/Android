package com.example.tp_android;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewPersonnaliseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_personnalise);

        // 1. Get the ListView from layout
        ListView malistView = findViewById(R.id.List_view_perso);

        // 2. Create ArrayList of HashMaps
        ArrayList<HashMap<String, String>> ma_liste = new ArrayList<>();

        // 3. Prepare data to display
        HashMap<String, String> logiciel1 = new HashMap<>();
        logiciel1.put("icone", String.valueOf(R.drawable.word));
        logiciel1.put("titre", "Word");
        logiciel1.put("description", "Traitement de Texte, suite Microsoft");

        HashMap<String, String> logiciel2 = new HashMap<>();
        logiciel2.put("icone", String.valueOf(R.drawable.excel));
        logiciel2.put("titre", "Excel");
        logiciel2.put("description", "Tableur de la suite Microsoft");

        HashMap<String, String> logiciel3 = new HashMap<>();
        logiciel3.put("icone", String.valueOf(R.drawable.winrar));
        logiciel3.put("titre", "Winrar");
        logiciel3.put("description", "Logiciel de compression");

        HashMap<String, String> logiciel4 = new HashMap<>();
        logiciel4.put("icone", String.valueOf(R.drawable.kis));
        logiciel4.put("titre", "Kaspersky");
        logiciel4.put("description", "Antivirus");

        HashMap<String, String> logiciel5 = new HashMap<>();
        logiciel5.put("icone", String.valueOf(R.drawable.sublime));
        logiciel5.put("titre", "Sublime");
        logiciel5.put("description", "Éditeur de texte");

        HashMap<String, String> logiciel6 = new HashMap<>();
        logiciel6.put("icone", String.valueOf(R.drawable.utorrent));
        logiciel6.put("titre", "Utorrent");
        logiciel6.put("description", "Client de téléchargement torrent");

        // Add all to the list
        ma_liste.add(logiciel1);
        ma_liste.add(logiciel2);
        ma_liste.add(logiciel3);
        ma_liste.add(logiciel4);
        ma_liste.add(logiciel5);
        ma_liste.add(logiciel6);

        // 6. utilisation de l'objet Adapter
        SimpleAdapter mSchedule = new SimpleAdapter(
                this.getBaseContext(),
                ma_liste,
                R.layout.item_logiciel,
                new String[] {"icone", "titre", "description"},
                new int[] {R.id.Icone, R.id.nom, R.id.description}
        ) {
            @Override
            public void setViewImage(ImageView v, String value) {
                v.setImageResource(Integer.parseInt(value));
            }
        };

        //On attribut à notre listView l'adapter que l'on vient de créer
        malistView.setAdapter(mSchedule);
    }
}