package com.example.baitap_lab08_android_tuan8;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Name.class}, version = 1, exportSchema = false)
public abstract class NameRoomDatabase extends RoomDatabase {
    public abstract NameDAO nameDAO();
    private static volatile NameRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    static NameRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (NameRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NameRoomDatabase.class,"name_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                NameDAO dao = INSTANCE.nameDAO();
                dao.deleteAll();

                Name name = new Name("Nguyễn Văn Hùng");
                dao.insert(name);
                name = new Name("Nguyễn Văn Anh");
                dao.insert(name);
            });
        }
    };

}
