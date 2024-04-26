package com.example.uts_mobprog.ui.bola;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BolaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BolaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Bola");
    }

    public LiveData<String> getText() {
        return mText;
    }
}