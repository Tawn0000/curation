package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Ibeacon;

import java.util.List;

public interface IbeaconDao {
    List<Ibeacon> queryIbeacon();

    List<Ibeacon> queryIbeaconByStatus(boolean status);

    Ibeacon queryIbeaconById(Long ibeaconId);

    Long queryExhibitByUuid(String uuid);

    int insertIbeacon(Ibeacon ibeacon);

    int updateIbeacon(Ibeacon ibeacon);

    int deleteIbeacon(Long ibeaconId);
}
