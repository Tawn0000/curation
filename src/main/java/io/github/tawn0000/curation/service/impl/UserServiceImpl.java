package io.github.tawn0000.curation.service.impl;

import io.github.tawn0000.curation.dao.UserDao;
import io.github.tawn0000.curation.entity.User;
import io.github.tawn0000.curation.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@MapperScan("io.github.tawn0000.curation")
public class UserServiceImpl implements UserService {
    
        @Autowired
        private UserDao userDao;

        @Override
        public List<User> getUserList() {
            // 返回所有的用户信息
            return userDao.queryUser();
        }

        @Override
        public User getUserById(Long userId) {
            //通过userId返回用户信息
            return userDao.queryUserById(userId);
        }
        public User getUserByOpenId(String openId){
            //通过openId返回用户信息
            return userDao.queryUserByOpenId(openId);
        }

        @Transactional
        @Override
        public boolean addUser(User user) {
            // 空值判断，主要是判断userName不为空
            if (user.getuName() != null && !"".equals(user.getuName())) {
                // 设置默认值
                try {
                      userDao.insertUser(user);
                } catch (Exception e) {
                    throw new RuntimeException("添加用户信息失败:" + e.toString());
                }
            } else {
                throw new RuntimeException("用户信息不能为空！");
            }
            return true;
        }

        @Transactional
        @Override
        public boolean modifyUser(User user) {
            if (user.getuId() != null && user.getuId() > 0) {
                // 设置默认值
                try {
                      userDao.updateUser(user);
                } catch (Exception e) {
                    throw new RuntimeException("更新用户信息失败:" + e.toString());
                }
            } else {
                throw new RuntimeException("用户信息不能为空！");
            }
            return true;
        }

        @Transactional
        @Override
        public boolean deleteUser(Long userId) {
            if (userId > 0) {
                try {
                    // 删除用户信息
                    userDao.deleteUser(userId);
                } catch (Exception e) {
                    throw new RuntimeException("删除用户信息失败:" + e.toString());
                }
            } else {
                throw new RuntimeException("用户Id不能为空！");
            }
            return true;
        }
}
