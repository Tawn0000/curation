package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.UE;
import io.github.tawn0000.curation.utils.DateUtil;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.GregorianCalendar;
import java.util.List;

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
    //查询用户的所有访问过的展览
    public void testQueryUEByUid(){
     List<UE> ueList = ueDao.queryUEByUid(1L);
     System.out.println(ueList.size());
    }

    @Test
    //查询所有收藏的展览的ID
    public void testQueryExhibitionByUid(){
        List<Long> ueList = ueDao.queryExhibitionByUid(1L);
        System.out.println(ueList.size());
    }

    @Test
    //查询用户某种状态的展览
    public void testQueryUEByUeStatus(){
        List<Long> ueList = ueDao.queryUEByUeStatus(1L,0);
        System.out.println(ueList.size());
        System.out.println(ueList);
    }

    @Test
    public void testQueryUEByUidEid(){
        UE ue = ueDao.queryUEByUidEid(1L,1L);
        System.out.println(ue.getUeTime());
    }

    @Test
    public void testQueryUEById() {
        UE ue = ueDao.queryUEById(1L);
        System.out.println(ue.geteId() + " " + ue.geteId() + " " + ue.getUeStatus());
    }

    @Test
    public void testInsertUE() {
        UE ue = new UE(1L,1L,0,0, DateUtil.dateToTime(GregorianCalendar.getInstance().getTime()),null,null,null,null);
        ueDao.insertUE(ue);
        testQueryUE();
    }

    @Test
    public void testUpdateUE() {
        UE ue = new UE(1L,null,1,0, DateUtil.dateToTime(GregorianCalendar.getInstance().getTime()),null,null,null,null);
        ueDao.updateUE(ue);
        testQueryUEById();
    }

    @Test
    public void testDeleteUE() {
        ueDao.deleteUE(1L);
        testQueryUE();
    }
}