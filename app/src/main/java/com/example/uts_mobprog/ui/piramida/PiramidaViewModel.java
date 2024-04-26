package com.example.uts_mobprog.ui.piramida;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PiramidaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PiramidaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Piramida");
    }

    public LiveData<String> getText() {
        return mText;
    }
}