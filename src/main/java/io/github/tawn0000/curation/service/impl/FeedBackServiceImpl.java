package io.github.tawn0000.curation.service.impl;

import io.github.tawn0000.curation.dao.FeedbackDao;
import io.github.tawn0000.curation.entity.Feedback;
import io.github.tawn0000.curation.service.FeedbackService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.sql.Timestamp;
import java.util.List;
@Service
@MapperScan("io.github.tawn0000.curation")
public class FeedBackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDao feedbackDao;

    @Override
    public List<Feedback> queryFeedback(){
        return feedbackDao.queryFeedback();
    }

    @Override
    public List<Feedback> queryFeedbackByTime(Timestamp beginTime, Timestamp endTime){
        return feedbackDao.queryFeedbackByTime(beginTime,endTime);
    }

    @Override
    public Feedback queryFeedbackByUid(Long userId){
        return feedbackDao.queryFeedbackByUid(userId);
    }
    @Transient
    @Override
    public int addFeedback(Feedback feedback){
        return feedbackDao.insertFeedback(feedback);
    }
}
