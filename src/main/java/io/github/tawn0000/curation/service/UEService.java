package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.UE;

import java.util.List;

public interface UEService {
    
    List<UE> getUEList();

    //查询用户的所有访问过的展览
    List<UE> queryUEByUid(Long uid);

    //查询所有收藏的展览的ID
    List<Long> queryExhibitionByUid(Long uid);

    //查询用户某种状态的展览
    List<Long> queryUEByUeStatus(Long uid, Integer ueStatus);

    UE queryUEByUidEid(Long userId, Long exhibitionId);

    UE getUEById(Long ueId);

    boolean addUE(UE ue);
    
    boolean modifyUE(UE ue);

    boolean deleteUE(Long ueId);

}
