package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CommandeInstance extends AppCompatActivity {
    TextView commande;
    Button modifier, supprimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commande_instance);
        //la récupération des données envoyées
        Intent intent = getIntent();
        String Commande = intent.getStringExtra("commande");
        commande = findViewById(R.id.Commande);
        commande.setText("Commande : " + Commande);
        //activation du button Modifier de commande
        modifier = findViewById(R.id.ModifierCommande);
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommandeInstance.this, ModifierCommande.class);
                intent.putExtra("commande",Commande);
                startActivity(intent);
            }
        });
        //activation du button supprimer commande
        supprimer = findViewById(R.id.SupprimerCommande);
        supprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommandeInstance.this, SupprimerCommande.class);
                startActivity(intent);
            }
        });

    }
}