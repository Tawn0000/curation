package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Feedback;

import java.util.List;

public interface FeedbackDao {
    List<Feedback> queryFeedback();

    Feedback queryFeedbackByid(Long feedbackId);

    int insertFeedback(Feedback feedback);

    int updateFeedback(Feedback feedback);

    int deleteFeedback(Long feedbackId);
}
