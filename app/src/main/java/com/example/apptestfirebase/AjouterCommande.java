package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AjouterCommande extends AppCompatActivity {
    Commande commande ;
    Button ajouter;
    EditText Commande, TypeProduit, DateLivraison,Client, Consigne ;
    FirebaseDatabase database ;
    DatabaseReference ref_commande;
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

        commande = new Commande() ;
        database= FirebaseDatabase.getInstance();
        ref_commande=FirebaseDatabase.getInstance().getReference().child("Commande");
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AjouterCommande.this, ConfirmationAjoutCommande.class);
                startActivity(intent);
                String key =  ref_commande.push().getKey() ;
                commande.setCommande( Commande.getText().toString().trim());
                commande.setCommande( TypeProduit.getText().toString().trim());
                commande.setCommande( DateLivraison .getText().toString().trim());
                commande.setCommande(Client.getText().toString().trim());
                commande.setCommande( Consigne .getText().toString().trim());
                commande.setKey(key) ;

                ref_commande.child(key).setValue(commande);

                Toast.makeText(AjouterCommande.this, "Votre commande a été enregistrée", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
    }
}

