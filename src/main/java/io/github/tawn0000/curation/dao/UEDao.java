package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.UE;

import java.util.List;

public interface UEDao {
    List<UE> queryUE();

    UE queryUEByid(int ueId);

    int insertUE(UE ue);

    int updateUE(UE ue);

    int deleteUE(int ueId);
}
