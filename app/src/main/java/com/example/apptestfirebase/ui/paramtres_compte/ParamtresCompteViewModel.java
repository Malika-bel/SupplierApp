package com.example.apptestfirebase.ui.paramtres_compte;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ParamtresCompteViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ParamtresCompteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Paramètres Compte");
    }

    public LiveData<String> getText() {
        return mText;
    }
}