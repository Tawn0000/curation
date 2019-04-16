package io.github.tawn0000.curation.service.impl;

import io.github.tawn0000.curation.dao.UEDao;
import io.github.tawn0000.curation.entity.UE;
import io.github.tawn0000.curation.service.UEService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@MapperScan("io.github.tawn0000.curation")
public class UEServiceImpl implements UEService {


    @Autowired
    private UEDao ueDao;

    public List<UE> getUEList()
    {
        return ueDao.queryUE();
    }
    
    //查询用户所有收藏展览ID
    public List<Long> queryExhibitionByUid(Long uid)
    {
        return ueDao.queryExhibitionByUid(uid);
    }

    //查询用户的所有访问过的展览
    public List<UE> queryUEByUid(Long uid)
    {
        return ueDao.queryUEByUid(uid);
    }

    //查询用户某种状态的展览
    public List<Long> queryUEByUeStatus(Long uid, Integer ueStatus)
    {
        return ueDao.queryUEByUeStatus(uid,ueStatus);
    }

    public UE getUEById(Long ueId)
    {
        return ueDao.queryUEById(ueId);
    }

    public boolean addUE(UE ue){
        ueDao.insertUE(ue);
        return true;
    }

    public boolean modifyUE(UE ue){
        ueDao.updateUE(ue);
        return true;
    }
    

    public boolean deleteUE(Long ueId) {
        if (ueId != null) {
            ueDao.deleteUE(ueId);
            return true;
        }
        return false;
    }
}
