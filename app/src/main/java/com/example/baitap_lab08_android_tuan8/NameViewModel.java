package com.example.baitap_lab08_android_tuan8;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NameViewModel extends AndroidViewModel {
    private NameRepository mRepository;

    private LiveData<List<Name>> mAllNames;
    public NameViewModel(@NonNull Application application) {
        super(application);
        mRepository = new NameRepository(application);
        mAllNames = mRepository.getAllNames();
    }
    LiveData<List<Name>> getAllNames(){
        return mAllNames;
    }
    public void insert(Name name){
        mRepository.insert(name);
    }
}
