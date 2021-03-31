package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SupprimerCommande extends AppCompatActivity {
Button Oui, Non ;
    FirebaseDatabase database ;
    DatabaseReference ref_commande_suppr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer_commande);
        database= FirebaseDatabase.getInstance();

        ref_commande_suppr=FirebaseDatabase.getInstance().getReference("Commande").child(" ");

        Oui = findViewById(R.id.Oui);
        Non = findViewById(R.id.Non);

        Oui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ref_commande_suppr.removeValue() ;

                Toast.makeText(SupprimerCommande.this, "Votre commande a été supprimée", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

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


