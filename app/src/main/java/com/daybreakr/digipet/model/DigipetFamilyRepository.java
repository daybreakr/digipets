package com.daybreakr.digipet.model;

import java.util.List;

public class DigipetFamilyRepository {
    private final DigipetFamilyDao mDao;

    public DigipetFamilyRepository(DigipetFamilyDao dao) {
        mDao = dao;
    }

    public List<DigipetFamily> getDigipetFamilies() {
        return mDao.getDigipetFamilies();
    }

    public DigipetFamily getDigipetFamily(long familyId) {
        return mDao.getDigipetFamily(familyId);
    }

    public List<DigipetFamily> getDigipetFamiliesWithGrowZoneNumber(int growZoneNumber) {
        return mDao.getDigipetFamiliesWithGrowZoneNumber(growZoneNumber);
    }
}
