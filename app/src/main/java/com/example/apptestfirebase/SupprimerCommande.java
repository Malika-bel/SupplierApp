package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SupprimerCommande extends AppCompatActivity {
Button Oui, Non ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_commande);

        Oui = findViewById(R.id.Oui);
        Non = findViewById(R.id.Non);

        Oui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // requete pour supprimer l'objet
            }
        });

        Non.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SupprimerCommande.this, AjouterCommande.class);
                startActivity(intent);
            }
        });

    }
}


