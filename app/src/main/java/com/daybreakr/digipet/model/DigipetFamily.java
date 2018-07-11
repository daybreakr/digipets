package com.daybreakr.digipet.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * An entity represents a table in database, and describes the schema of this table.
 */
@Entity(tableName = "digipet_families")
public class DigipetFamily {
    @PrimaryKey
    @ColumnInfo(name = "_id")
    public long familyId = -1;

    public String name;

    public String description;

    public int growZoneNumber;

    public int feedInterval = 8; // how often the digipet should be fed

    @Override
    public String toString() {
        return name;
    }
}
