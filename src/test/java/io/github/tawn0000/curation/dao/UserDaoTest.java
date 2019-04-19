package io.github.tawn0000.curation.dao;

import io.github.tawn0000.curation.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("io.github.tawn0000.curation")
@MapperScan("io.github.tawn0000.curation")
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testQueryUser() {
        List<User> userList = userDao.queryUser();
        //System.out.println(userList.get(0).getuId());
        System.out.println(userList.size());
        //assertEquals(2, userList.size());
    }

    @Test
    public void testQueryUserById() {
        try {
            User user = userDao.queryUserById(1L);
            System.out.println(user.getuName());
            assertEquals(Long.valueOf(1), user.getuId());
        }catch (Exception e)
             {
                 System.out.println("无效ID");
             }
    }

    @Test
    public void testQueryUserByOpenId(){
       try {
           User user = userDao.queryUserByOpenId("fab123456000");
           System.out.println(user.getuName());
           //assertEquals(Long.valueOf(2), user.getuId());
       }catch (Exception e)
       {
           System.out.println("无效openID");
       }
    }

    @Test
    public void testInsertUser() {
        //List<User> userList1 = userDao.queryUser();
        //创建一个用户对象
        User user = new User("fab1234560555","张宇","男","1.jpg","否","复古");
        //将该对象实例添加入库
        userDao.insertUser(user);
        System.out.println(user.getuId());
        //校验总数是否+1
       // List<User> userList2 = userDao.queryUser();
        //assertEquals(userList1.size()+1, userList2.size());
    }

    @Test
    public void testUpdateUser() {
        //创建一个需要更新的用户对象
        User user = new User(1L,"fab123456789456","张宇","男","111.jpg","否","复古");
        //更新用户对象
        userDao.updateUser(user);
        //检测该用户对象是否更新成功
        System.out.println(userDao.queryUserById(1L).getuIcon());
    }

    @Test
    public void testDeleteUser() {
        userDao.deleteUser(2L);
        testQueryUser();
    }
}