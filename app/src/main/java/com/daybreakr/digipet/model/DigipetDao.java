package com.daybreakr.digipet.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DigipetDao {

    @Query("SELECT * FROM digipets")
    List<Digipet> getDigipets();

    @Query("SELECT * FROM digipets WHERE _id = :id")
    Digipet getDigipet(long id);

    @Query("SELECT * FROM digipets WHERE family_id = :familyId")
    List<Digipet> getDigipetsForFamily(long familyId);

    @Insert
    long insertDigipet(Digipet digipet);
}
