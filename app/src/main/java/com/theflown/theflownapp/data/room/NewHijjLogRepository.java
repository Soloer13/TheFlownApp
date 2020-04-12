package com.theflown.theflownapp.data.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NewHijjLogRepository {

    private NewHijjLogDAO mNewHijjLogDAO;
    private LiveData<List<NewHijjLog>> mAllHijjLog;

    public NewHijjLogRepository(Application application) {
        FlownRoomDB db = FlownRoomDB.getDatabase(application);
        mNewHijjLogDAO = db.NewHijjLogDAO(); //I didn't get this!!
        this.mAllHijjLog = mNewHijjLogDAO.getNewHijjLogs();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<NewHijjLog>> getAllNewHijjLogs() {
        return mAllHijjLog;
    }

    public void insert(NewHijjLog log){ new NewHijjLogRepository.InsertNotAsyncTask(mNewHijjLogDAO).execute(log); }

    public void update(NewHijjLog log){
        new NewHijjLogRepository.UpdateNotAsyncTask(mNewHijjLogDAO).execute(log);
    }

    public void delete(NewHijjLog log){
        new NewHijjLogRepository.DeleteNotAsyncTask(mNewHijjLogDAO).execute(log);
    }

    public void deleteAllNewHijjLogs(){ new NewHijjLogRepository.DeleteAllNotAsyncTask(mNewHijjLogDAO).execute(); }


    private static class InsertNotAsyncTask extends AsyncTask<NewHijjLog, Void, Void> {
        private NewHijjLogDAO logDao;

        private InsertNotAsyncTask(NewHijjLogDAO logDao){
            this.logDao = logDao;
        }

        @Override
        protected Void doInBackground(NewHijjLog... newHijjLogs) {
            logDao.insert(newHijjLogs[0]);
            return null;
        }
    }

    private static class UpdateNotAsyncTask extends AsyncTask<NewHijjLog, Void, Void> {
        private NewHijjLogDAO logDao;

        private UpdateNotAsyncTask(NewHijjLogDAO logDao){
            this.logDao = logDao;
        }

        @Override
        protected Void doInBackground(NewHijjLog... newHijjLogs) {
            logDao.update(newHijjLogs[0]);
            return null;
        }
    }

    private static class DeleteNotAsyncTask extends AsyncTask<NewHijjLog, Void, Void> {
        private NewHijjLogDAO logDao;

        private DeleteNotAsyncTask(NewHijjLogDAO logDAO){
            this.logDao = logDAO;
        }

        @Override
        protected Void doInBackground(NewHijjLog... newHijjLogs) {
            logDao.delete(newHijjLogs[0]);
            return null;
        }
    }

    private static class DeleteAllNotAsyncTask extends AsyncTask<Void, Void, Void> {
        private NewHijjLogDAO logDao;

        private DeleteAllNotAsyncTask(NewHijjLogDAO logDao){
            this.logDao = logDao;
        }

        @Override
        protected Void doInBackground(Void... Voids) {
            logDao.deleteAll();
            return null;
        }
    }
}
