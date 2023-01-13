package com.example.pergidulu.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Travel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TravelDao userDao();
}
