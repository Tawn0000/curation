package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Ibeacon;

import java.util.List;

public interface IbeaconDao {
    List<Ibeacon> queryIbeacon();

    //获取空闲或则忙碌的蓝牙Ibeacon
    List<Ibeacon> queryIbeaconByStatus(Integer status);

    //通过IbeaconId获得Ibeacon的所有信息
    Ibeacon queryIbeaconById(Long ibeaconId);

    //通过扫描到底uuid信息得到展览品exhibitId
    Long queryExhibitByUuid(String uuid);

    int insertIbeacon(Ibeacon ibeacon);

    int updateIbeacon(Ibeacon ibeacon);

    int deleteIbeacon(Long ibeaconId);
}
