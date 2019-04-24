package io.github.tawn0000.curation.service;

import io.github.tawn0000.curation.entity.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@MapperScan("io.github.tawn0000.curation")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    //List<User> getUserList();
    public void testGetUserList()
    {
        List<User>  userList = userService.getUserList();
        System.out.println(userList.size());
    }
}