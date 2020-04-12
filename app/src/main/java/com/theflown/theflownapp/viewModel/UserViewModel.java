package com.theflown.theflownapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.theflown.theflownapp.data.room.User;
import com.theflown.theflownapp.data.room.UserRepository;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    //ViewModel isolates the UI from repository
    private UserRepository mRepository;
    private LiveData<List<User>> mAllUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        mRepository = new UserRepository(application);
        mAllUsers = mRepository.getAllUsers();
    }


    public LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public void insert(User user) {
        mRepository.insert(user);
    }

    public void update(User user) {
        mRepository.update(user);
    }

    public void delete(User user) {
        mRepository.delete(user);
    }

    public void deleteAllUsers() {
        mRepository.deleteAllUsers();
    }
}
