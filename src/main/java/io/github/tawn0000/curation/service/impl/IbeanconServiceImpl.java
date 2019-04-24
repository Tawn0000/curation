package io.github.tawn0000.curation.service.impl;

import io.github.tawn0000.curation.dao.IbeaconDao;
import io.github.tawn0000.curation.entity.Ibeacon;
import io.github.tawn0000.curation.service.IbeaconService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
@Service
//@MapperScan("io.github.tawn0000.curation")

public class IbeanconServiceImpl implements IbeaconService {

    @Autowired
    private IbeaconDao ibeaconDao;

    @Override
    public List<Ibeacon> queryIbeacon(){return ibeaconDao.queryIbeacon();}

    @Override
    public List<Ibeacon> queryIbeaconByStatus(Integer status){return ibeaconDao.queryIbeaconByStatus(status);}

    @Override
    public Ibeacon queryIbeaconById(Long ibeaconId){return ibeaconDao.queryIbeaconById(ibeaconId);}

    @Override
    public Long queryExhibitByUuid(String uuid){return ibeaconDao.queryExhibitByUuid(uuid);}

    @Transactional
    @Override
    public int addIbeacon(Ibeacon ibeacon){return ibeaconDao.insertIbeacon(ibeacon);}

    @Transactional
    @Override
    public int modifyIbeacon(Ibeacon ibeacon){return ibeaconDao.updateIbeacon(ibeacon);}

    @Transient
    @Override
    public int deleteIbeacon(Long ibeaconId){return ibeaconDao.deleteIbeacon(ibeaconId);}

}
