package com.example.pergidulu.room;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TravelDao {

    @Insert
    void insertUser(Travel travel);

    @Query("SELECT EXISTS (SELECT * FROM Travel WHERE email= :email)")
    boolean is_taken(String email);

    @Query("SELECT EXISTS (SELECT * FROM Travel WHERE email= :email AND password= :password)")
    boolean is_login(String email, String password);



    @Delete
    public void deleteUsers(Travel users);

    @Update
    public void update(Travel travel);

    @Delete
    public void deleteUser(Travel user1, Travel user2);

}
