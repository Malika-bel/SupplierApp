package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AjouterCommande extends AppCompatActivity {
    Commande commande ;
    Button ajouter,backHome;
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
                final String commandeName = Commande.getText().toString().trim();
                final String typeProduit = TypeProduit.getText().toString().trim();
                final String dateLivraison = DateLivraison.getText().toString().trim();
                final String adresseLivraison = Client.getText().toString().trim();
                final String consignes = Consigne.getText().toString().trim();

                if(TextUtils.isEmpty(commandeName)){
                    Commande.setError("Veulliez entrez le nom de votre commande ! ");
                    return;
                }

                if(TextUtils.isEmpty(typeProduit)){
                    TypeProduit.setError("Veulliez préciser le type de produit ! ");
                    return;
                }

                if(TextUtils.isEmpty(dateLivraison)){
                    DateLivraison.setError("Veulliez entrez la date de livraison! ");
                    return;
                }
                if(TextUtils.isEmpty(adresseLivraison)){
                    Client.setError("Veulliez entrez l'adresse de livraison ! ");
                    return;
                }

                String key =  ref_commande.push().getKey() ;
                commande.setCommande( Commande.getText().toString().trim());
                commande.setTypeProduit( TypeProduit.getText().toString().trim());
                commande.setDateLivraison( DateLivraison .getText().toString().trim());
                commande.setAdresseLivraison(Client.getText().toString().trim());
                commande.setConsigne( Consigne .getText().toString().trim());
                commande.setKey(key) ;

                ref_commande.child(key).setValue(commande);

                Toast.makeText(AjouterCommande.this, "Votre commande a été enregistrée", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), HomeAppNavigationDrawer.class));

            }
        });
        backHome = findViewById(R.id.backHome);
        backHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeAppNavigationDrawer.class));
            }
        });
    }
}

