package com.theflown.theflownapp.data.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class IssueViewModel extends AndroidViewModel {
//ViewModel isolates the UI from repository

    private IssueRepository mRepository;
    private LiveData<List<Issue>> mAllIssues;

    public IssueViewModel(@NonNull Application application) {
        super(application);
        mRepository = new IssueRepository(application);
        mAllIssues = mRepository.getAllIssues();
    }


    public LiveData<List<Issue>> getAllIssues() { return mAllIssues; }

    public void insert(Issue issue) { mRepository.insert(issue); }

   // public void update(Issue issue) { mRepository.update(issue); }

    public void delete(Issue issue) { mRepository.delete(issue); }

    public  void deleteAllIssues() { mRepository.deleteAllIssues(); }
}
