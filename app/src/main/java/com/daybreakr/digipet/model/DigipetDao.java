package com.daybreakr.digipet.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DigipetDao {

    @Query("SELECT * FROM digipets")
    LiveData<List<Digipet>> getDigipets();

    @Query("SELECT * FROM digipets WHERE _id = :id")
    LiveData<Digipet> getDigipet(long id);

    @Query("SELECT * FROM digipets WHERE family_id = :familyId")
    LiveData<List<Digipet>> getDigipetsForFamily(long familyId);

    @Insert
    long insertDigipet(Digipet digipet);
}
