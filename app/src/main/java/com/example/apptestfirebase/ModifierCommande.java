package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ModifierCommande extends AppCompatActivity {
    EditText commande;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_commande);
        Intent intent = getIntent();
        String Commande = intent.getStringExtra("commande");
        commande = findViewById(R.id.Commande);
        commande.setText("Commande : " + Commande);
    }
}