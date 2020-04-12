package com.theflown.theflownapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.theflown.theflownapp.data.room.NewHijjLog;
import com.theflown.theflownapp.data.room.NewHijjLogRepository;
import com.theflown.theflownapp.data.room.User;
import com.theflown.theflownapp.data.room.UserRepository;

import java.util.List;

public class NewHijjLogViewModel extends AndroidViewModel {
    //ViewModel isolates the UI from repository
    private NewHijjLogRepository mRepository;
    private LiveData<List<NewHijjLog>> mAllLogs;

    public NewHijjLogViewModel(@NonNull Application application) {
        super(application);
        mRepository = new NewHijjLogRepository(application);
        mAllLogs = mRepository.getAllNewHijjLogs();
    }

    public LiveData<List<NewHijjLog>> getAllLogs() {
        return mAllLogs;
    }

    public void insert(NewHijjLog log) {
        mRepository.insert(log);
    }

    public void update(NewHijjLog log) {
        mRepository.update(log);
    }

    public void delete(NewHijjLog log) {
        mRepository.delete(log);
    }

    public void deleteAllUsers() {
        mRepository.deleteAllNewHijjLogs();
    }
}
