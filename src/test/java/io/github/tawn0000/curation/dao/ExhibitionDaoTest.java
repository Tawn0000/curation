package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Exhibition;
import io.github.tawn0000.curation.utils.DateUtil;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.internal.verification.Times;
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
public class ExhibitionDaoTest {

    @Autowired
    private ExhibitionDao exhibitionDao;
    @Test
    public void testQueryExhibition() {
        List<Exhibition> exhibitionList = exhibitionDao.queryExhibition();
        System.out.println(exhibitionList.size());
    }

    @Test
    public void testQueryExhibitionById() {
        Exhibition exhibition = exhibitionDao.queryExhibitionById(1L);
        System.out.println(exhibition.geteName() + " " + DateUtil.timeToDate(exhibition.geteDate()).toString());
    }

    @Test
    public void testInsertExhibition() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(2020,06,1,13,00);
        Exhibition exhibition = new Exhibition("张宇画展","江苏省无锡市江南大学桃园", new Timestamp(calendar.getTimeInMillis()),50,"张宇的个人画展","1.jpg","1.mp4","张宇");
        exhibitionDao.insertExhibition(exhibition);
        System.out.println(exhibition.geteId());
        testQueryExhibition();
    }

    @Test
    public void testUpdateExhibition() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(2020,03,1,13,00);
        Exhibition exhibition = new Exhibition(1L,"张宇画展","江苏省无锡市江南大学李园25-206", DateUtil.dateToTime(calendar.getTime()),50,"张宇的个人画展","1.jpg","1.mp4","张宇");
        exhibitionDao.updateExhibition(exhibition);
        testQueryExhibitionById();
    }


    @Test
    public void testDeleteExhibition() {
        exhibitionDao.deleteExhibition(1L);
        testQueryExhibition();
    }
}