package com.daybreakr.digipet.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.daybreakr.digipet.utilities.Constants;

/**
 * Database represents a SQLite database in local storage, contains several relative tables.
 */
@Database(entities = {DigipetFamily.class, Digipet.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class DigipetsDatabase extends RoomDatabase {

    public abstract DigipetFamilyDao digipetFamilyDao();

    public abstract DigipetDao digipetDao();

    private static volatile DigipetsDatabase sInstance;

    public static DigipetsDatabase get(Context context) {
        if (sInstance == null) {
            synchronized (DigipetsDatabase.class) {
                if (sInstance == null) {
                    sInstance = create(context);
                }
            }
        }
        return sInstance;
    }

    private static DigipetsDatabase create(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                DigipetsDatabase.class, Constants.DATABASE_NAME)
                .build();
    }
}
