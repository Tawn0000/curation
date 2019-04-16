package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.UE;

import java.util.List;

public interface UEDao {
    List<UE> queryUE();

    //查询用户的所有访问过的展览
    List<UE> queryUEByUid(Long uid);

    //查询所有收藏的展览的ID
    List<Long> queryExhibitionByUid(Long uid);

    //查询用户某种状态的展览
    List<Long> queryUEByUeStatus(Long uid, Integer ueStatus);

    UE queryUEById(Long ueId);

    int insertUE(UE ue);

    int updateUE(UE ue);

    int deleteUE(Long ueId);
}
