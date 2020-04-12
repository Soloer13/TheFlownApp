package com.theflown.theflownapp.data.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class IssueRepository {

    private IssueDAO mIssueDAO;
    private LiveData<List<Issue>> mAllIssues;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public IssueRepository(Application application) {
        FlownRoomDB db = FlownRoomDB.getDatabase(application);
        mIssueDAO = db.issueDAO();
        mAllIssues = mIssueDAO.getIssues();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Issue>> getAllIssues() {
        return mAllIssues;
    }

    public void insert(Issue issue){ new InsertNotAsyncTask(mIssueDAO).execute(issue); }

    public void update(Issue issue){
        new UpdateNotAsyncTask(mIssueDAO).execute(issue);
    }

    public void delete(Issue issue){
        new DeleteNotAsyncTask(mIssueDAO).execute(issue);
    }

    public void deleteAllIssues(){ new DeleteAllNotAsyncTask(mIssueDAO).execute(); }


    private static class InsertNotAsyncTask extends AsyncTask<Issue, Void, Void> {
        private IssueDAO issueDao;

        private InsertNotAsyncTask(IssueDAO issueDao){
            this.issueDao = issueDao;
        }

        @Override
        protected Void doInBackground(Issue... issues) {
            issueDao.insert(issues[0]);
            return null;
        }
    }

    private static class UpdateNotAsyncTask extends AsyncTask<Issue, Void, Void> {
        private IssueDAO issueDao;

        private UpdateNotAsyncTask(IssueDAO issueDao){
            this.issueDao = issueDao;
        }

        @Override
        protected Void doInBackground(Issue... issues) {
            issueDao.update(issues[0]);
            return null;
        }
    }

    private static class DeleteNotAsyncTask extends AsyncTask<Issue, Void, Void> {
        private IssueDAO issueDao;

        private DeleteNotAsyncTask(IssueDAO issueDao){
            this.issueDao = issueDao;
        }

        @Override
        protected Void doInBackground(Issue... issues) {
            issueDao.delete(issues[0]);
            return null;
        }
    }

    private static class DeleteAllNotAsyncTask extends AsyncTask<Void, Void, Void> {
        private IssueDAO issueDao;

        private DeleteAllNotAsyncTask(IssueDAO issueDao){
            this.issueDao = issueDao;
        }

        @Override
        protected Void doInBackground(Void... Voids) {
            issueDao.deleteAll();
            return null;
        }
    }


    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
//    void insert(Issue issue) {
//        FlownRoomDB.databaseWriteExecutor.execute(() -> {
//            mIssueDAO.insert(issue);
//        });
//    }
}
