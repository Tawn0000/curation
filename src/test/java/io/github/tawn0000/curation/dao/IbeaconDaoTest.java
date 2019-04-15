package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Ibeacon;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@MapperScan("io.github.tawn0000.curation")

public class IbeaconDaoTest {

    @Autowired
    private IbeaconDao ibeaconDao;
    @Test
    public void testQeryIbeacon() {
        List<Ibeacon> ibeaconList = ibeaconDao.queryIbeacon();
        System.out.println(ibeaconList.size());
    }

    @Test
    public void testQueryIbeaconByid() {
        Ibeacon ibeacon = ibeaconDao.queryIbeaconByid(1L);
        System.out.println(ibeacon.getiUid() + " " + ibeacon.getiMajor() + " " + ibeacon.getiMinor() + " " + ibeacon.getiMeasuredPower());
    }

    @Test
    public void testInsertIbeacon() {
        Ibeacon ibeacon = new Ibeacon("111","222","333","23",true,1L,0.5D);
        ibeaconDao.insertIbeacon(ibeacon);
        testQeryIbeacon();
    }

    @Test
    public void testUpdateIbeacon() {
        Ibeacon ibeacon = new Ibeacon(1L,"111","222","333","55",false,1L,0.5D);
        ibeaconDao.updateIbeacon(ibeacon);
        testQueryIbeaconByid();
    }

    @Test
    public void testDeleteIbeacon() {
        ibeaconDao.deleteIbeacon(1L);
        testQeryIbeacon();
    }
}