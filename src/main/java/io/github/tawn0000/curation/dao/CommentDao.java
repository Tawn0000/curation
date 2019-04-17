package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> queryComment();

    List<Comment> queryCommentByEid(Long exhibitionId);

    Comment queryCommentById(Long commentId);

    void insertComment(Comment comment);

    void updateComment(Comment comment);

    void deleteComment(Long commentId);
}
