package com.daybreakr.digipet.model;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class Converters {

    @TypeConverter
    public static Long dateToLong(Date date) {
        return date == null ? 0 : date.getTime();
    }

    @TypeConverter
    public static Date dateFromLong(Long date) {
        return date == null ? null : new Date(date);
    }
}
