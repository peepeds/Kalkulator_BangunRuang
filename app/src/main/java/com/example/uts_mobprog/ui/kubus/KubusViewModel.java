package com.example.uts_mobprog.ui.kubus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KubusViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public KubusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Kubus");
    }

    public LiveData<String> getText() {
        return mText;
    }
}