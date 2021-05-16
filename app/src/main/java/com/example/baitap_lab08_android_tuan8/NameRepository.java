package com.example.baitap_lab08_android_tuan8;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NameRepository {
    private NameDAO mNameDao;
    private LiveData<List<Name>> mAllNames;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    NameRepository(Application application) {
        NameRoomDatabase db = NameRoomDatabase.getDatabase(application);
        mNameDao = db.nameDAO();
        mAllNames = mNameDao.getAlphabetizedNames();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Name>> getAllNames() {
        return mAllNames;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Name name) {
        NameRoomDatabase.databaseWriteExecutor.execute(() -> {
            mNameDao.insert(name);
        });
    }
}
