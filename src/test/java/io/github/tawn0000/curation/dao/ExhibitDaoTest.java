package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Exhibit;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
@MapperScan("io.github.tawn0000.curation")
public class ExhibitDaoTest {
    @Autowired
    private ExhibitDao exhibitDao;
    @Test
    public void testQueryExhibit() {
        List<Exhibit> exhibitList = exhibitDao.queryExhibit();
        for(Exhibit x : exhibitList)
            System.out.println(x.getE1Name()+ " "+ x.getE1Description() + " " + x.getE1Date()+ x.getE1Author());
    }


    //通过展览id获得所有展品信息
    //List<Exhibit> queryExhibitByEid(Long exhibitionId);

    @Test
    public void testQueryExhibitByEid()
    {
        List<Exhibit> exhibitList = exhibitDao.queryExhibitByEid(1L);
        for(Exhibit x : exhibitList)
        System.out.println(x.getE1Author());
    }

    //通过展览id删除所有的展品信息
    //int deleteExhibitByEid(Long exhibitionId);

    @Test
    public void testDeleteExhibitionByEid()
    {
        exhibitDao.deleteExhibitByEid(1L);
        testQueryExhibit();
    }

    @Test
    public void testQueryExhibitById() {
        System.out.println(exhibitDao.queryExhibitById(2L).getE1Author());
    }

    @Test
    public void testInsertExhibit() {
        exhibitDao.insertExhibit(new Exhibit(1L,"xxxx","xxxx", new GregorianCalendar(1998,5,3).getTime(),"xx.jpg","fafafj;jaf"));
    }

    @Test
    public void testUpdateExhibit() {
        exhibitDao.updateExhibit(new Exhibit(1L,1L,"xxxx","张宇", new GregorianCalendar(1998,5,3).getTime(),"xx.jpg","fafafj;jaf"));
        testQueryExhibit();
    }

    @Test
    public void testDeleteExhibit() {
        exhibitDao.deleteExhibit(1L);
        testQueryExhibit();
    }
}