package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ModifierCommande extends AppCompatActivity {
    Button ModifierCommandeFinal ;
    EditText Commande,TypeProduit, DateLivraison, Client, Consigne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_commande);
      /*  Intent intent = getIntent();
        String Commande = intent.getStringExtra("commande"); */
        ModifierCommandeFinal = findViewById(R.id.ModifierCommandeFinal);

        Commande = findViewById(R.id.Commande);
        TypeProduit = findViewById(R.id.TypeProduit);
        DateLivraison = findViewById(R.id.DateLivraison);
        Consigne= findViewById(R.id.Consigne);
        Client= findViewById(R.id.Client);

        ModifierCommandeFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifierCommande.this, ConfirmationAjoutCommande.class);
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

