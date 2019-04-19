package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.Feedback;

import java.sql.Timestamp;
import java.util.List;

public interface FeedbackService {
    List<Feedback> queryFeedback();

    //查询一段时间内的用户反馈
    List<Feedback> queryFeedbackByTime(Timestamp beginTime, Timestamp endTime);

    //查询某个用户的反馈
    List<Feedback> queryFeedbackByUid(Long userId);

    //Feedback queryFeedbackById(Long feedbackId);

    //添加用户反馈
    int addFeedback(Feedback feedback);

    //int modifyFeedback(Feedback feedback);

   // int deleteFeedback(Long feedbackId);
}
