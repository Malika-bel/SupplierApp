package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AjouterCommande extends AppCompatActivity {
    Button ajouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_commande);
        ajouter = findViewById(R.id.AjouterCommande);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AjouterCommande.this, ConfirmationAjoutCommande.class);
                startActivity(intent);
                //ss
            }
        });
    }
}