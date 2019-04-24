package io.github.tawn0000.curation.service.impl;

import io.github.tawn0000.curation.dao.RecordDao;
import io.github.tawn0000.curation.entity.Record;
import io.github.tawn0000.curation.service.RecordService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
//@MapperScan("io.github.tawn0000.curation")
public class RecordServiceImpl implements RecordService {


    @Autowired
    private RecordDao recordDao ;

    @Override
    //根据userId和exhibitionId获得所有的Record
    public List<Record> queryRecordById(Long userId, Long exhibitionId){
        return recordDao.queryRecordById(userId,exhibitionId);
    }

    @Override
    //根据userId,exhibitionId和exhibitId获得特定展品的Record
    public Record queryRecordByAllId(Long userId, Long exhibitionId, Long exhibitId){
        return recordDao.queryRecordByAllId(userId,exhibitionId,exhibitId);
    }
    @Transactional
    @Override
    //根据userId,exhibitionId和exhibitId插入记录
    public int addRecord(Record record){
        return recordDao.insertRecord(record);
    }

    @Transactional
    @Override
    //根据userId,exhibitionId和exhibitIdg更新记录
    public int modifyRecord(Record record){
        return recordDao.updateRecord(record);
    }

}
