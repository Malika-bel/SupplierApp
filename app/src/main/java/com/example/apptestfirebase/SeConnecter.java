package com.example.apptestfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SeConnecter extends AppCompatActivity {
    TextView inscrire;
    Button connect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_se_connecter);
        inscrire = findViewById(R.id.InscrivezVous);
        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeConnecter.this, Inscription.class);
                startActivity(intent);
            }
        });
        connect = findViewById(R.id.SeConnecter);
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeConnecter.this, HomeAppNavigationDrawer.class);
                startActivity(intent);
            }
        });
    }
}