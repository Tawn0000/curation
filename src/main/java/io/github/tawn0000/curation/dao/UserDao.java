package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.User;

import java.util.List;

public interface UserDao {
    List<User> queryUser();

    User queryUserById(Long userId);

    User queryUserByopenId(String openId);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(Long userId);
}
