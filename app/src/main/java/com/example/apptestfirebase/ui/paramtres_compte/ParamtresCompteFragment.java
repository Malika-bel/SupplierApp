package com.example.apptestfirebase.ui.paramtres_compte;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.apptestfirebase.Inscription;
import com.example.apptestfirebase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.concurrent.Executor;


public class ParamtresCompteFragment extends Fragment {

    private ParamtresCompteViewModel paramtresCompteViewModel;
    public static final String TAG = "TAG";
    EditText fnom,femail,fprenom,fpassword;
    Button MettreAjour;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        paramtresCompteViewModel =
                new ViewModelProvider(this).get(ParamtresCompteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_paramtres_compte, container, false);
        fnom = root.findViewById(R.id.NomFournisseurModification);
        fprenom = root.findViewById(R.id.PrenomFournisseurModification);
        femail = root.findViewById(R.id.AdresseEmailModification);
        fpassword = root.findViewById(R.id.MotDePasseModification);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("fournisseurs").document(userId);
        documentReference.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                fnom.setText(documentSnapshot.getString("fName"),TextView.BufferType.EDITABLE);
                fprenom.setText(documentSnapshot.getString("prenom"),TextView.BufferType.EDITABLE);
                femail.setText(documentSnapshot.getString("email"),TextView.BufferType.EDITABLE);
            }
        });
        MettreAjour = root.findViewById(R.id.ModifierProfil);
        MettreAjour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = femail.getText().toString().trim();
                final String password = fpassword.getText().toString().trim();
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
                    femail.setError("Veulliez entrez votre email ! ");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    fpassword.setError("Veulliez entrez votre mot de passe ! ");
                    return;
                }
               MettreAjour.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       FirebaseUser firebaseUser = fAuth.getCurrentUser();
                       UserProfileChangeRequest request=null;
                       firebaseUser.updateProfile(request);
                       fAuth.updateCurrentUser(firebaseUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void aVoid) {
                               Toast.makeText(getActivity(),"Votre profil a été .",Toast.LENGTH_SHORT).show();
                           }
                       });
                   }
               });




            }
        });


        return root;
    }
}