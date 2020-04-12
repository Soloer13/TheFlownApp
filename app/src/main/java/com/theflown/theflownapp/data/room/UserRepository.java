package com.theflown.theflownapp.data.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {

    private UserDAO mUserDAO;
    private LiveData<List<User>> mAllUsers;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    public UserRepository(Application application) {
        FlownRoomDB db = FlownRoomDB.getDatabase(application);
        mUserDAO = db.UserDAO(); //I didn't get this!!
        mAllUsers = mUserDAO.getUsers();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public void insert(User user){ new UserRepository.InsertNotAsyncTask(mUserDAO).execute(user); }

    public void update(User user){
        new UpdateNotAsyncTask(mUserDAO).execute(user);
    }

    public void delete(User user){
        new DeleteNotAsyncTask(mUserDAO).execute(user);
    }

    public void deleteAllUsers(){ new DeleteAllNotAsyncTask(mUserDAO).execute(); }


    private static class InsertNotAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDao;

        private InsertNotAsyncTask(UserDAO userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    private static class UpdateNotAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDao;

        private UpdateNotAsyncTask(UserDAO userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users[0]);
            return null;
        }
    }

    private static class DeleteNotAsyncTask extends AsyncTask<User, Void, Void> {
        private UserDAO userDao;

        private DeleteNotAsyncTask(UserDAO userDAO){
            this.userDao = userDAO;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users[0]);
            return null;
        }
    }

    private static class DeleteAllNotAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDAO userDao;

        private DeleteAllNotAsyncTask(UserDAO userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(Void... Voids) {
            userDao.deleteAll();
            return null;
        }
    }


}
