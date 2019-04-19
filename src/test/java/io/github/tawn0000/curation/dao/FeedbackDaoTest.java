package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Feedback;
import io.github.tawn0000.curation.utils.DateUtil;
import org.apache.ibatis.annotations.Mapper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.internal.verification.Times;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@MapperScan("io.github.tawn0000.curation")

public class FeedbackDaoTest {

    @Autowired
    private FeedbackDao feedbackDao;
    @Test
    public void testQueryFeedback() {
        List<Feedback> feedbackList = feedbackDao.queryFeedback();
        System.out.println(feedbackList.size());
    }

    @Test
    public void testQueryFeedbackByTime()
    {
        Timestamp beginTime = new Timestamp(new GregorianCalendar(2018,0,1).getTimeInMillis());
        List<Feedback> feedbackList = feedbackDao.queryFeedbackByTime(beginTime,new Timestamp(GregorianCalendar.getInstance().getTimeInMillis()));
        for(Feedback x : feedbackList) System.out.println(x.getuId().toString() + " " + x.getfContent());

    }

    @Test
    public void testQueryFeedbackByUuid() {
        List<Feedback> feedbackList = feedbackDao.queryFeedbackByUid(1L);
        for(Feedback x : feedbackList) System.out.println(x.getuId().toString() + " " + x.getfContent());
    }

    @Test
    public void testInsertFeedback() {
        Feedback feedback = new Feedback(1L, "非常好！ I like it", "1.jpg","131555555", DateUtil.dateToTime(GregorianCalendar.getInstance().getTime()));
        feedbackDao.insertFeedback(feedback);
        testQueryFeedback();
    }

    @Test
    public void testDeleteFeedback() {
        feedbackDao.deleteFeedback(1L);
        testQueryFeedback();
    }
}