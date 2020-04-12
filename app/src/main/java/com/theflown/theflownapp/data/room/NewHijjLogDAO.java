package com.theflown.theflownapp.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NewHijjLogDAO {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert
    //(onConflict = OnConflictStrategy.IGNORE)
    void insert(NewHijjLog newHijjLog);

    @Update
    void update(NewHijjLog newHijjLog);

    @Delete
    void delete(NewHijjLog newHijjLog); //most likely this 1 won't be used sooner or later

    @Query("DELETE FROM newhijjlog_table")
    void deleteAll();

    @Query("SELECT * from newhijjlog_table ORDER BY id ASC")
    LiveData<List<NewHijjLog>> getNewHijjLogs();

    @Query("SELECT * from newhijjlog_table WHERE id = :id")
    NewHijjLog getNewHijjLog(int id); //not tested need to check it..
    //https://developer.android.com/training/data-storage/room/accessing-data.html

}
