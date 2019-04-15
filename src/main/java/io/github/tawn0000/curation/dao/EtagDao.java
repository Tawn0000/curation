package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Etag;

import java.util.List;

public interface EtagDao {
    List<Etag> queryEtag();

    Etag queryEtagByid(Long etagId);

    int insertEtag(Etag etag);

    int updateEtag(Etag etag);

    int deleteEtag(Long etagId);
}
