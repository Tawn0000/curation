package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.Exhibit;
import io.github.tawn0000.curation.entity.Exhibition;
import io.github.tawn0000.curation.entity.ExhibitionToken;

import java.util.List;

public interface ExhibitionService {

    //获得所有的展览信息
    List<Exhibition> queryExhibition();

    //通过某一展览id获得该展览的除展品外的所有信息
    Exhibition queryExhibitionById(Long exhibitionId);

    //通过展览id获得该展览的所有展品信息
    List<Exhibit> queryExhibitByEid(Long exhibitionId);

    //通过指定地址的所有展览简要信息
    List<ExhibitionToken> queryExhibitionByAddress(String address);

    //添加展览信息
    List<Long> addExhibition(Exhibition exhibition, List<Exhibit> exhibitList);

    //修改除展品外的展览信息
    Long modifyExhibition(Exhibition exhibition);

    //修改展品信息
    Long modifyExhibit(Exhibit exhibit);

    //删除展览信息
    int deleteExhibition(Long exhibitionId);
}
