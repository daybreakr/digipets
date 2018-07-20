package com.daybreakr.digipet.model;

import com.daybreakr.digipet.utilities.AppExecutors;

import java.util.Date;
import java.util.List;

public class DigipetRepository {
    private final DigipetDao mDao;

    public DigipetRepository(DigipetDao dao) {
        mDao = dao;
    }

    public void createDigipet(final long familyId, final String firstName, final String lastName) {
        AppExecutors.runOnIoThread(new Runnable() {
            @Override
            public void run() {
                Digipet digipet = new Digipet();
                digipet.familyId = familyId;
                digipet.firstName = firstName;
                digipet.lastName = lastName;
                digipet.birthday = new Date(); // now
                digipet.lastFeedDate = new Date(0); // not fed yet
                mDao.insertDigipet(digipet);
            }
        });
    }

    public List<Digipet> getDigipets() {
        return mDao.getDigipets();
    }

    public Digipet getDigipet(long id) {
        return mDao.getDigipet(id);
    }

    public List<Digipet> getDigipetsForFamily(long familyId) {
        return mDao.getDigipetsForFamily(familyId);
    }
}
