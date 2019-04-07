package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Exhibition;

import java.util.List;

public interface ExhibitionDao {
    List<Exhibition> queryExhibition();

    Exhibition queryExhibitionByid(int exhibitionId);

    int insertExhibition(Exhibition exhibition);

    int updateExhibition(Exhibition exhibition);

    int deleteExhibition(int exhibitionId);
}
