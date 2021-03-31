package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Inscription extends AppCompatActivity {
    public static final String TAG = "TAG";
    TextView seConnecter;
    EditText fnom, fprenom, fmail, motDePasse;
    Button inscriptionButton;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        fnom = findViewById(R.id.NomFournisseur);
        fprenom = findViewById(R.id.PrenomFournisseur);
        fmail = findViewById(R.id.Email);
        motDePasse = findViewById(R.id.MotDePasse);
        inscriptionButton = findViewById(R.id.inscrire);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();


        //dans le cas ou l'utilisateur est déja inscrit il sera rediregé vers la page de connexion
        if(fAuth.getCurrentUser() != null){
            Intent intent = new Intent(Inscription.this, SeConnecter.class);
            startActivity(intent);
        }

        inscriptionButton.setOnClickListener(new View.OnClickListener() {
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
                //ajouter l'utilisateur à la base de données
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser fuser = fAuth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(Inscription.this,"Un email de vérification vous a été envoyé.",Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "L'email de confirmation n'a pas été envoyé" + e.getMessage() );
                                }
                            });
                            Toast.makeText(Inscription.this, "Votre compte a été bien crée, un email de vérification vous a été envoyé. .", Toast.LENGTH_SHORT).show();
                            userID = fAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = fStore.collection("fournisseurs").document(userID);
                            Map<String,Object> fournisseurs = new HashMap<>();
                            fournisseurs.put("fName",nom);
                            fournisseurs.put("prenom",prenom);
                            fournisseurs.put("email",email);
                            documentReference.set(fournisseurs).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Log.d(TAG,"profil cré avec succes " + userID);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG,"la création a échoué" + e.toString());
                                }
                            });
                            startActivity(new Intent(getApplicationContext(),SeConnecter.class));
                        }else{
                            Toast.makeText(Inscription.this,"une erreur a été détcté ! " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });

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