package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Inscription extends AppCompatActivity {
    TextView seConnecter;
    EditText fnom, fprenom, fmail, motDePasse;
    Button inscription;
    /*FirebaseAuth fAuth;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        fnom = findViewById(R.id.NomFournisseur);
        fprenom = findViewById(R.id.PrenomFournisseur);
        fmail = findViewById(R.id.Email);
        motDePasse = findViewById(R.id.MotDePasse);
        inscription = findViewById(R.id.inscrire);
       /* fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            Intent intent = new Intent(Inscription.this, SeConnecter.class);
            startActivity(intent);

        }*/

        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = fmail.getText().toString().trim();
                final String password = motDePasse.getText().toString().trim();
                final String nom = fnom.getText().toString().trim();
                final String prenom = fprenom.getText().toString().trim();


                if(TextUtils.isEmpty(nom)){
                    fnom.setError("Veulliez entrez votre nom ! ");
                    return;
                }

                if(TextUtils.isEmpty(prenom)){
                    fprenom.setError("Veulliez entrez votre prenom ! ");
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    fmail.setError("Veulliez entrez votre email ! ");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    motDePasse.setError("Veulliez entrez votre mot de passe ! ");
                    return;
                }

                if(password.length() < 10){
                    motDePasse.setError("Votre mot de passe doit contenir plus de 10 caractères ! ");
                    return;
                }


            }
        });





        seConnecter = findViewById(R.id.ConnectezVous);
        seConnecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inscription.this, SeConnecter.class);
                startActivity(intent);
            }
        });
    }
}