package com.example.apptestfirebase;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SeConnecter extends AppCompatActivity {
    TextView inscrire, FMotDePasseOublie;
    Button connect;
    FirebaseAuth fAuth;
    EditText fEmail, FmotDePasse;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se_connecter);
        fAuth = FirebaseAuth.getInstance();
        inscrire = findViewById(R.id.InscrivezVous);
        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeConnecter.this, Inscription.class);
                startActivity(intent);
            }
        });
        connect = findViewById(R.id.SeConnecter);
        fEmail = findViewById(R.id.AdresseEmail);
        FmotDePasse = findViewById(R.id.MotDePasseConnexion);
        FMotDePasseOublie = findViewById(R.id.MotDePasseOublie);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = fEmail.getText().toString().trim();
                String password = FmotDePasse.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    fEmail.setError("Email is Required.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    FmotDePasse.setError("Password is Required.");
                    return;
                }

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SeConnecter.this, "Bienvenue, connexion réussi", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), HomeAppNavigationDrawer.class));
                        }else {
                            Toast.makeText(SeConnecter.this, "Une erreur a été détectée ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });
        FMotDePasseOublie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetMail = new EditText(v.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Voulez vous réinitialiser votre mot de passe ?");
                passwordResetDialog.setMessage("Entrez votre email pour recevoir le lien de réinitialisation !");
                passwordResetDialog.setView(resetMail);

                passwordResetDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(SeConnecter.this, "Le lien de réinitialisation vous a été envoyé.", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SeConnecter.this, "Erreur ! le lien de réinitialisation n'a pas été envoyé" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });

                passwordResetDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog
                    }
                });

                passwordResetDialog.create().show();

            }
        });

    }
}