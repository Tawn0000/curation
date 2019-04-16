package io.github.tawn0000.curation.service.impl;

import io.github.tawn0000.curation.dao.ExhibitionDao;
import io.github.tawn0000.curation.entity.Exhibition;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@MapperScan("io.github.tawn0000.curation")

public class ExhibitionServiceImpl {

    @Autowired
    private ExhibitionDao exhibitionDao;

    public List<Exhibition> queryExhibition(){
        return exhibitionDao.queryExhibition();
    }

    public Exhibition queryExhibitionById(Long exhibitionId){
        return exhibitionDao.queryExhibitionById(exhibitionId);
    }

    public int insertExhibition(Exhibition exhibition){
        return exhibitionDao.insertExhibition(exhibition);
    }

    public int updateExhibition(Exhibition exhibition){
        return exhibitionDao.updateExhibition((exhibition));
    }

    int deleteExhibition(Long exhibitionId)
    {
        return exhibitionDao.deleteExhibition(exhibitionId);
    }
}
