package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Feedback;

import java.sql.Timestamp;
import java.util.List;

public interface FeedbackDao {
    List<Feedback> queryFeedback();

    List<Feedback> queryFeedbackByTime(Timestamp beginTime, Timestamp endTime);

    Feedback queryFeedbackByUid(Long userId);

    Feedback queryFeedbackById(Long feedbackId);

    int insertFeedback(Feedback feedback);

    int updateFeedback(Feedback feedback);

    int deleteFeedback(Long feedbackId);
}
