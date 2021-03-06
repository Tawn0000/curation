package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.Comment;
import io.github.tawn0000.curation.utils.DateUtil;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
@MapperScan("io.github.tawn0000.curation")
public class CommentDaoTest {
    @Autowired
    private CommentDao commentDao;

    @Test
    public void testQueryComment() {
        List<Comment> commentList = commentDao.queryComment();
        System.out.println(commentList.get(0).getcId());
        assertEquals(2,commentList.size());
    }

    //List<Comment> queryCommentByEid(Long exhibitionId);
    @Test
    public void testQueryCommentByEid() {
        List<Comment> commentList = commentDao.queryCommentByEid(1L);
        System.out.println(commentList.size());
    }

    @Test
    public void testQueryCommentById() {
        Comment comment = commentDao.queryCommentById(1L);
        System.out.println(comment.getcContent());
        assertEquals(Long.valueOf(1),comment.getcId());
    }

    @Test
    public void testInsertComment() {
        List<Comment> commentList1  = commentDao.queryComment();
        Comment comment = new Comment(1L,1L,null, DateUtil.dateToTime(Calendar.getInstance().getTime()),"very good","1.jpg");
        commentDao.insertComment(comment);
    List<Comment> commentList2 = commentDao.queryComment();
    assertEquals(commentList1.size()+1,commentList2.size());
}

    @Test
    public void testUpdateComment() {
        Comment comment = new Comment(1L,1L,1L,null,DateUtil.dateToTime(Calendar.getInstance().getTime()),"very good very good","1.jpg");
        commentDao.updateComment(comment);
        //System.out.println(commentDao.queryCommentById(1L).getcDate());
    }

    @Test
    public void testDeleteComment() {
        commentDao.deleteComment(1L);
        testQueryComment();
    }
}