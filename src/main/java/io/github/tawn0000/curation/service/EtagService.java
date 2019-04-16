package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.Etag;

import java.util.List;

public interface EtagService {
    List<Etag> queryEtag();

    Etag queryEtagByid(Long etagId);

    int insertEtag(Etag etag);

    int updateEtag(Etag etag);

    int deleteEtag(Long etagId);
}
