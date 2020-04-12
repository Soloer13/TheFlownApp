package com.theflown.theflownapp.data.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Issue.class, User.class, NewHijjLog.class}, version = 1)
public abstract class FlownRoomDB extends RoomDatabase {

    public abstract IssueDAO issueDAO();
    public abstract UserDAO UserDAO(); //I didn't get this and the above also but required!! IDK why
    public abstract NewHijjLogDAO NewHijjLogDAO();

    private static volatile FlownRoomDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FlownRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FlownRoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FlownRoomDB.class, "issue_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    //callBack method return onCreate for first time and onOpen for all following times!!
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            //new populateDbAsyncTask(INSTANCE).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };



    //public abstract UserDAO UserDAO();

//
//    //AsyncTask allow to perform tasks in background and display in current UI
//    private static class populateDbAsyncTask extends AsyncTask<Void, Void, Void> {
//        private IssueDAO issueDao;
//
//        private populateDbAsyncTask(FlownRoomDB db) {
//            issueDao = db.issueDAO();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            return null;
//        }
//    }

}

