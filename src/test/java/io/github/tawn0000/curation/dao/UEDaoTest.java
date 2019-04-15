package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.UE;
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
public class UEDaoTest {
    @Autowired
    private UEDao ueDao;
    @Test
    public void testQueryUE() {
        List<UE> ueList = ueDao.queryUE();
        System.out.println(ueList.size());
    }

    @Test
    public void testQueryUEByid() {
        UE ue = ueDao.queryUEByid(2L);
        System.out.println(ue.geteId() + " " + ue.geteId() + " " + ue.getUeStatus());
    }

    @Test
    public void testInsertUE() {
        UE ue = new UE(1L,1L,0);
        ueDao.insertUE(ue);
        testQueryUE();
    }

    @Test
    public void testUpdateUE() {
        UE ue = new UE(2L,null,null,1);
        ueDao.updateUE(ue);
        testQueryUEByid();
    }

    @Test
    public void testDeleteUE() {
        ueDao.deleteUE(1L);
        testQueryUE();
    }
}