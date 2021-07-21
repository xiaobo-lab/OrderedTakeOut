package com.r948.orderedtakeout.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.r948.orderedtakeout.data.local.dao.UserDao;
import com.r948.orderedtakeout.data.model.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class DataSource extends RoomDatabase {
    private static DataSource appDatabase;

    public static DataSource getInstance(Context context) {
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context, DataSource.class, "database").build();
        return appDatabase;
    }

    public abstract UserDao userDao();
}
