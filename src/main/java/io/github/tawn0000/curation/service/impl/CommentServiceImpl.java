package io.github.tawn0000.curation.service.impl;

import io.github.tawn0000.curation.dao.CommentDao;
import io.github.tawn0000.curation.entity.Comment;
import io.github.tawn0000.curation.service.CommentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
//@MapperScan("io.github.tawn0000.curation")

public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> queryComment(){
        return commentDao.queryComment();
    }

    @Override
    public List<Comment> queryCommentByEid(Long exhibitionId){
        return commentDao.queryCommentByEid(exhibitionId);
    }

    @Override
    public Comment queryCommentById(Long commentId){
        return commentDao.queryCommentById(commentId);
    }

    @Transactional
    @Override
    public Boolean addComment(Comment comment){
        //此评论的用户编号不为空并且用户编号大于0
        if (comment.getuId() != null && comment.getuId() > 0){
            try {
                commentDao.insertComment(comment);
            }
            catch (Exception e){
                throw new RuntimeException("插入记录失败" + e.toString());
            }
        }
        else {
            throw new RuntimeException("评论记录不能为空");
        }
        return true;
    }

    @Transactional
    @Override
    public Boolean modifyComment(Comment comment){
        //此评论的id号不为空且大于0
        if (comment.getcId() != null && comment.getcId() > 0){
            try{
                commentDao.updateComment(comment);
            }
            catch (Exception e){
                throw new RuntimeException("评论的内容跟新失败" + e.toString());
            }
        }
        else {
            throw new RuntimeException("此评论并不存在");
        }
        return true;
    }

    @Transactional
    @Override
    public  Boolean deleteComment(Long commentId){
        if (commentId > 0)
        {
            try {
                commentDao.deleteComment(commentId);
            }
            catch (Exception e){
                throw new RuntimeException("删除用户信息失败"  + e.toString());
            }
        }
        else {
            throw new RuntimeException("评论id有误");
        }
        return true;
    }
}
