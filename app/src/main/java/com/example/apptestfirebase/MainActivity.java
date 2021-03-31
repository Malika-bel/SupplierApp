package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button seConnecter, inscrire;
   /* FirebaseDatabase database;
    DatabaseReference ref_fournisseur;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*database= FirebaseDatabase.getInstance();
        ref_fournisseur = database.getReference().child("fournisseur");*/
        seConnecter = findViewById(R.id.SeConnecterMain);
        inscrire = findViewById(R.id.inscrireMain);
        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


             /*   //la creation d'un nouveau étudiant
                String key = ref_fournisseur.push().getKey();
                Fournisseur e = new Fournisseur(1,"MALIKA","belmokhtar");
                //l'ajouter dans la table des étudiants
                ref_fournisseur.push().setValue(e);*/

                Intent intent = new Intent(MainActivity.this, SeConnecter.class);
                startActivity(intent);
            }
        });
        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Inscription.class);
                startActivity(intent);
            }
        });

    }
}