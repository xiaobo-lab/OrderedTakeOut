package com.r948.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.r948.data.local.dao.AddressDao;
import com.r948.data.local.dao.UserDao;
import com.r948.data.model.Address;
import com.r948.data.model.User;

@Database(entities = {User.class, Address.class}, version = 1, exportSchema = false)
public abstract class LocalDataSource extends RoomDatabase {
    private static LocalDataSource appDatabase;

    public static LocalDataSource getInstance(Context context) {
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context, LocalDataSource.class, "database").build();
        return appDatabase;
    }

    public abstract UserDao getUserDao();

    public abstract AddressDao getAddressDao();
}
