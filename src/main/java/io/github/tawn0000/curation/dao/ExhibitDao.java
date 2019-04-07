package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Exhibit;

import java.util.List;

public interface ExhibitDao {
    List<Exhibit> queryExhibit();

    Exhibit queryExhibitByid(int exhibitId);

    int insertExhibit(Exhibit exhibit);

    int updateExhibit(Exhibit exhibit);

    int deleteExhibit(int exhibitId);
}

