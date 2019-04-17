package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> queryComment();

    //根据展览ID查询所有该展览的评论信息
    List<Comment> queryCommentByEid(Long exhibitionId);

    Comment queryCommentById(Long commentId);

    //添加评论信息
    Boolean addComment(Comment comment);

    Boolean modifyComment(Comment comment);

    Boolean deleteComment(Long commentId);
}
