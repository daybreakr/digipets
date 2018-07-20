package com.daybreakr.digipet.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.ArrayList;
import java.util.List;

public class DigipetFamilyAndDigipet {

    @Embedded
    public DigipetFamily digipetFamily;

    @Relation(parentColumn = "_id", entityColumn = "family_id")
    public List<Digipet> digipets = new ArrayList<>();
}
