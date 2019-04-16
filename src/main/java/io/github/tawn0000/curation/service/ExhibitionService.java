package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.Exhibition;

import java.util.List;

public interface ExhibitionService {
    List<Exhibition> queryExhibition();

    Exhibition queryExhibitionById(Long exhibitionId);

    int insertExhibition(Exhibition exhibition);

    int updateExhibition(Exhibition exhibition);

    int deleteExhibition(Long exhibitionId);
}
