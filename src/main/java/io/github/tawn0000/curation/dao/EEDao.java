package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.EE;

import java.util.List;

public interface EEDao {
    List<EE> queryEE();

    EE queryEEByid(int eeId);

    int insertEE(EE ee);

    int updateEE(EE ee);

    int deleteEE(int eeId);
}
