package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUserList();

    User getUserById(Long userId);

    User getUserByOpenId(String openId);

    boolean addUser(User user);

    boolean modifyUser(User user);

    boolean deleteUser(Long userId);

}
