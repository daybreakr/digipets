package com.daybreakr.digipet.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Database represents a SQLite database in local storage, contains several relative tables.
 */
@Database(entities = {DigipetFamily.class, Digipet.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class DigipetDatabase extends RoomDatabase {

    public abstract DigipetFamilyDao digipetFamilyDao();

    public abstract DigipetDao digipetDao();

    private static volatile DigipetDatabase sInstance;

    public static DigipetDatabase get(Context context) {
        if (sInstance == null) {
            synchronized (DigipetDatabase.class) {
                if (sInstance == null) {
                    sInstance = create(context);
                }
            }
        }
        return sInstance;
    }

    private static DigipetDatabase create(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                DigipetDatabase.class, ModelConstants.DATABASE_NAME)
                .build();
    }
}
