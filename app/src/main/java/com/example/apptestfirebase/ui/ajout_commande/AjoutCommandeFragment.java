package com.example.apptestfirebase.ui.ajout_commande;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.apptestfirebase.R;


public class AjoutCommandeFragment extends Fragment {

    private AjoutCommandeViewModel ajoutCommandeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ajoutCommandeViewModel =
                new ViewModelProvider(this).get(AjoutCommandeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ajout_commande, container, false);
        return root;
    }
}