package com.example.apptestfirebase.ui.aide_commentaire;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AideCommentairesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AideCommentairesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aide et commentaires");
    }

    public LiveData<String> getText() {
        return mText;
    }
}