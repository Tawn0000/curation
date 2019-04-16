package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> queryComment();

    Comment queryCommentByid(int commentId);

    Boolean insertComment(Comment comment);

    Boolean updateComment(Comment comment);

    Boolean deleteComment(int commentId);
}
