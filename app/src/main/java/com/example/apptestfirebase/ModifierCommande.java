package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ModifierCommande extends AppCompatActivity {
    Button ModifierCommandeFinal ;
    EditText Commande,TypeProduit, DateLivraison, Client, Consigne;
    FirebaseDatabase database ;
    DatabaseReference ref_commande_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_commande);

        ModifierCommandeFinal = findViewById(R.id.ModifierCommandeFinal);

        Commande = findViewById(R.id.Commande);
        TypeProduit = findViewById(R.id.TypeProduit);
        DateLivraison = findViewById(R.id.DateLivraison);
        Consigne= findViewById(R.id.Consigne);
        Client= findViewById(R.id.Client);

        ref_commande_update = FirebaseDatabase.getInstance().getReference("Commande").child(" ");

        ModifierCommandeFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String commande = Commande.getText().toString().trim();
                 String typeProduit = TypeProduit.getText().toString().trim();
                 String dateLivraison  = DateLivraison .getText().toString().trim();
                 String client = Client.getText().toString().trim();
                 String consigne  = Consigne .getText().toString().trim();

                 ref_commande_update.child("Commande").setValue(commande) ;
                ref_commande_update.child("TypeProduit").setValue(typeProduit) ;
                ref_commande_update.child("DateLivraison").setValue(dateLivraison) ;
                ref_commande_update.child("Client").setValue(client) ;
                ref_commande_update.child("Consigne").setValue(consigne) ;

                Toast.makeText(ModifierCommande.this, "Votre commande a été mise à jours", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),HomeAppNavigationDrawer.class));

            }
        });

    }
}

