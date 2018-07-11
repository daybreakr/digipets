package com.daybreakr.digipet.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "digipets",
        foreignKeys = {@ForeignKey(entity = DigipetFamily.class, parentColumns = {"_id"}, childColumns = {"family_id"})})
public class Digipet {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    public long id = -1;

    @ColumnInfo(name = "family_id")
    public long familyId;

    public String firstName;

    public String lastName;

    public Date birthday;

    @ColumnInfo(name = "last_feed_date")
    public Date lastFeedDate;
}
