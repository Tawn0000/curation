package io.github.tawn0000.curation.dao;

import java.util.List;

public interface CommentDao {
    List<CommentDao> queryComment();

    CommentDao queryCommentByid(int commentId);

    int insertComment(CommentDao comment);

    int updateComment(CommentDao comment);

    int deleteComment(int commentId);
}
