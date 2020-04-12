package com.theflown.theflownapp.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IssueDAO {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert//(onConflict = OnConflictStrategy.IGNORE)
    void insert(Issue issue);

    @Update
    void update(Issue issue);

    @Delete
    void delete(Issue issue); //most likely this 1 won't be used sooner or later

    @Query("DELETE FROM issue_table")
    void deleteAll();

    @Query("SELECT * from issue_table ORDER BY id ASC")
    LiveData<List<Issue>> getIssues();

    @Query("SELECT * from issue_table WHERE id = :id")
    Issue getIssue(int id); //not tested need to check it..
    //https://developer.android.com/training/data-storage/room/accessing-data.html

}
