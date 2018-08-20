package com.daybreakr.digipet.model;

import android.arch.lifecycle.LiveData;

import com.daybreakr.digipet.utilities.AppExecutors;

import java.util.Date;
import java.util.List;

public class DigipetRepository {
    private final DigipetDao mDao;

    public DigipetRepository(DigipetDao dao) {
        mDao = dao;
    }

    public void createDigipet(final long familyId, final String firstName, final String lastName) {
        AppExecutors.runOnIoThread(() -> {
            Digipet digipet = new Digipet();
            digipet.familyId = familyId;
            digipet.firstName = firstName;
            digipet.lastName = lastName;
            digipet.birthday = new Date(); // now
            digipet.lastFeedDate = new Date(0); // not fed yet
            mDao.insertDigipet(digipet);
        });
    }

    public LiveData<List<Digipet>> getDigipets() {
        return mDao.getDigipets();
    }

    public LiveData<Digipet> getDigipet(long id) {
        return mDao.getDigipet(id);
    }

    public LiveData<List<Digipet>> getDigipetsForFamily(long familyId) {
        return mDao.getDigipetsForFamily(familyId);
    }
}
