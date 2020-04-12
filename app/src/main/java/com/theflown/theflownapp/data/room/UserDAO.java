package com.theflown.theflownapp.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDAO {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert //(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user); //most likely this 1 won't be used sooner or later

    @Query("DELETE FROM user_table")
    void deleteAll();

    @Query("SELECT * from user_table ORDER BY id ASC")
    LiveData<List<User>> getUsers();

    @Query("SELECT * from user_table WHERE id = :id")
    User getUser(int id); //not tested need to check it..
    //https://developer.android.com/training/data-storage/room/accessing-data.html

}
