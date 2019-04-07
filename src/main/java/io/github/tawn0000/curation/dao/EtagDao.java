package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Etag;

import java.util.List;

public interface EtagDao {
    List<Etag> queryEtag();

    Etag queryE_agByid(int etagId);

    int insertEtag(Etag etag);

    int updateEtag(Etag etag);

    int deleteEtag(int etagId);
}
