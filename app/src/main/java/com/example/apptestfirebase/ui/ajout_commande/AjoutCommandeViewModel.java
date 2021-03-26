package com.example.apptestfirebase.ui.ajout_commande;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AjoutCommandeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AjoutCommandeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ajouter Commande");
    }

    public LiveData<String> getText() {
        return mText;
    }
}