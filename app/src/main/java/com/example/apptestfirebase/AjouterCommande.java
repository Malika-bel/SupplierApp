package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AjouterCommande extends AppCompatActivity {
    Button ajouter;
    EditText Commande, TypeProduit, DateLivraison,Client, Consigne ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_commande);

        Commande = findViewById(R.id.Commande);
        TypeProduit = findViewById(R.id.TypeProduit);
        DateLivraison = findViewById(R.id.DateLivraison);
        Client = findViewById(R.id.Client);
        Consigne  = findViewById(R.id.Consigne );

        ajouter = findViewById(R.id.AjouterCommande);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AjouterCommande.this, ConfirmationAjoutCommande.class);
                startActivity(intent);

                final String commande = Commande.getText().toString().trim();
                final String typeProduit = TypeProduit.getText().toString().trim();
                final String dateLivraison  = DateLivraison .getText().toString().trim();
                final String client = Client.getText().toString().trim();
                final String consigne  = Consigne .getText().toString().trim();

            }
        });
    }
}

