package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@MapperScan("io.github.tawn0000.curation")
public class RecordDaoTest {
    @Autowired
    private RecordDao recordDao;
    @Test
    public void testQueryRecord() {
        List<Record> recordList = recordDao.queryRecord();
        System.out.println(recordList.size());
    }

    @Test
    public void testQueryRecordById() {
        List<Record> recordList = recordDao.queryRecordById(1L,1L);
        System.out.println(recordList.size());
    }

    @Test
    //根据userId,exhibitionId和exhibitId获得特定展品的Record
    public void testQueryRecordByAllId(){
         Record record = recordDao.queryRecordByAllId(1L,1L,1L);
         System.out.println(record.getrInterval());
    }

    @Test
    public void testInsertRecord() {
        Record record = new Record(1L,1L,1L, new Timestamp(System.currentTimeMillis()),null,null,null);
        recordDao.insertRecord(record);
        testQueryRecord();
   }

    @Test
    public void testUpdateRecord() {
        Record record = new Record(1L,1L,1L,1L, new Timestamp(System.currentTimeMillis()),null,null,null);
        //Record record = new Record(1L,1L,1L,1L, null,new Timestamp(System.currentTimeMillis()),null,null);
        recordDao.updateRecord(record);
        testQueryRecordById();
    }


    @Test
    public void testDeleteRecord() {
        recordDao.deleteRecord(1L);
        testQueryRecord();
    }
}