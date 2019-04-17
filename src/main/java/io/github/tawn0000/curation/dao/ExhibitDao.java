package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Exhibit;

import java.util.List;

public interface ExhibitDao {

    List<Exhibit> queryExhibit();

    //通过展览id获得所有展品信息
    List<Exhibit> queryExhibitByEid(Long exhibitionId);

    //通过展览id删除所有的展品信息
    int deleteExhibitByEid(Long exhibitionId);

    Exhibit queryExhibitById(Long exhibitId);

    int insertExhibit(Exhibit exhibit);

    int updateExhibit(Exhibit exhibit);

    int deleteExhibit(Long exhibitId);
}

