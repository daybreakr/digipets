package com.daybreakr.digipet.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * DAO declares the way to access the entities in database.
 */
@Dao
public interface DigipetFamilyDao {

    @Query("SELECT * FROM digipet_families ORDER BY name")
    List<DigipetFamily> getDigipetFamilies();

    @Query("SELECT * FROM digipet_families WHERE growZoneNumber = :growZoneNumber ORDER BY name")
    List<DigipetFamily> getDigipetFamiliesWithGrowZoneNumber(int growZoneNumber);

    @Query("SELECT * FROM digipet_families WHERE _id = :familyId")
    DigipetFamily getDigipetFamily(long familyId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<DigipetFamily> digipetFamilies);
}
