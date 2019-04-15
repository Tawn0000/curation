package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Comment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class CommentDaoTest {
    @Autowired
    private CommentDao commentDao;

    @Test
    public void queryComment() {
        List<Comment> commentList = commentDao.queryComment();
        System.out.println(commentList.get(0).getcId());
        assertEquals(2,commentList.size());
    }

    @Test
    public void queryCommentByid() {
        Comment comment = commentDao.queryCommentByid(2);
        System.out.println(comment.getcContent());
        assertEquals(Long.valueOf(2),comment.getcId());

    }

    @Test
    public void insertComment() {
        List<Comment> commentList1  = commentDao.queryComment();
        Comment comment = new Comment(1,1,1,Date(2019,4,12),"very good","1.jpg");
        commentDao.insertComment(comment);
        List<Comment> commentList2 = commentDao.queryComment();
        assertEquals(commentList1.size()+1,commentList2.size());
    }

    @Test
    public void updateComment() {
        Comment comment = new Comment(1,1,1,1,Date(2019, 4, 11),"very good","1.jpg");
        commentDao.updateComment(comment);
        System.out.println(commentDao.queryCommentByid(1).getcDate());
    }

    @Test
    public void deleteComment() {
        commentDao.deleteComment(1);
        queryComment();
    }
}