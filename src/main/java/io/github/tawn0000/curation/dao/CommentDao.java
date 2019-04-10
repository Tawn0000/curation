package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> queryComment();

    Comment queryCommentByid(int commentId);

    void insertComment(CommentDao comment);

    void updateComment(CommentDao comment);

    void deleteComment(int commentId);
}
