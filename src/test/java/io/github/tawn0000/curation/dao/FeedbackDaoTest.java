package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;
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

public class FeedbackDaoTest {

    @Autowired
    private FeedbackDao feedbackDao;
    @Test
    public void testQueryFeedback() {
        List<Feedback> feedbackList = feedbackDao.queryFeedback();
        System.out.println(feedbackList.size());
    }

    @Test
    public void testQueryFeedbackByid() {
        Feedback feedback = feedbackDao.queryFeedbackByid(1L);
        System.out.println(feedback.getuId().toString() + " " + feedback.getfContent());
    }

    @Test
    public void testInsertFeedback() {
        Feedback feedback = new Feedback(1L, "非常好！ I like it", "1.jpg");
        feedbackDao.insertFeedback(feedback);
        testQueryFeedback();
    }

    @Test
    public void testUpdateFeedback() {
        Feedback feedback = new Feedback(1L,1L, "很好！ I like it", "1.jpg");
        feedbackDao.updateFeedback(feedback);
        testQueryFeedbackByid();
    }

    @Test
    public void testDeleteFeedback() {
        feedbackDao.deleteFeedback(1L);
        testQueryFeedback();
    }
}