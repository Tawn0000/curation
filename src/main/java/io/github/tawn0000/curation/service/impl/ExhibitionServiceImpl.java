package io.github.tawn0000.curation.service.impl;

import io.github.tawn0000.curation.dao.ExhibitDao;
import io.github.tawn0000.curation.dao.ExhibitionDao;
import io.github.tawn0000.curation.entity.Exhibit;
import io.github.tawn0000.curation.entity.Exhibition;
import io.github.tawn0000.curation.entity.ExhibitionToken;
import io.github.tawn0000.curation.service.ExhibitionService;
import io.github.tawn0000.curation.utils.KMPUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Service
@MapperScan("io.github.tawn0000.curation")

public class ExhibitionServiceImpl implements ExhibitionService {

    @Autowired
    private ExhibitionDao exhibitionDao;
    @Autowired
    private ExhibitDao exhibitDao;

    @Override
    public List<Exhibition> queryExhibition(){
        return exhibitionDao.queryExhibition();
    }

    @Override
    public Exhibition queryExhibitionById(Long exhibitionId){
        return exhibitionDao.queryExhibitionById(exhibitionId);
    }

    @Override
    public List<Exhibit> queryExhibitByEid(Long exhibitionId){
        return exhibitDao.queryExhibitByEid(exhibitionId);
    }


    @Override
    public List<ExhibitionToken> queryExhibitionByAddress(String address){

        List<Exhibition> exhibitionList = exhibitionDao.queryExhibition();
        List<ExhibitionToken> exhibitionTokenList = new ArrayList<>();
        for(Exhibition x: exhibitionList)
        {
            String str = x.geteAddress();
            if(KMPUtil.kmpStringMatch(str,address) == false)
                exhibitionTokenList.add(new ExhibitionToken(x));
        }
        return exhibitionTokenList;
    }

    @Transient
    @Override
    public int addExhibition(Exhibition exhibition,List<Exhibit> exhibitList){

        exhibitionDao.insertExhibition(exhibition);
        for(Exhibit x : exhibitList)
        {
            exhibitDao.insertExhibit(x);
        }
        return 1;
    }

    @Transient
    @Override
    public int modifyExhibition(Exhibition exhibition){
        return exhibitionDao.updateExhibition((exhibition));
    }

    public int modifyExhibit(Exhibit exhibit){
        return exhibitDao.updateExhibit(exhibit);
    }

     @Transient
     @Override
    public int deleteExhibition(Long exhibitionId)
    {
         exhibitionDao.deleteExhibition(exhibitionId);
         exhibitDao.deleteExhibitByEid(exhibitionId);
         return 1;
    }
}
