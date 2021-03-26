package com.example.apptestfirebase.ui.paramtres_compte;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.apptestfirebase.R;


public class ParamtresCompteFragment extends Fragment {

    private ParamtresCompteViewModel paramtresCompteViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        paramtresCompteViewModel =
                new ViewModelProvider(this).get(ParamtresCompteViewModel.class);
        View root = inflater.inflate(R.layout.fragment_paramtres_compte, container, false);
        return root;
    }
}