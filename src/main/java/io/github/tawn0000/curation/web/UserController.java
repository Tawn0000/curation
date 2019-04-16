//package io.github.tawn0000.curation.web;
//
//import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import io.github.tawn0000.curation.entity.User;
//import io.github.tawn0000.curation.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/superadmin")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value = "/listuser", method = RequestMethod.GET)
//    private Map<String, Object> listUser() {
//        Map<String, Object> modelMap = new HashMap<>();
//        // 获取用户列表
//        List<User> list = userService.getUserList();
//        modelMap.put("userList", list);
//        return modelMap;
//    }
//
//    @RequestMapping(value = "/getuserbyid", method = RequestMethod.GET)
//    private Map<String, Object> getUserById(Integer userId) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        // 获取用户信息
//        User user = userService.getUserById(userId);
//        modelMap.put("user", user);
//        return modelMap;
//    }
//
//    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
//    private Map<String, Object> addUser(@RequestBody User user)
//            throws JsonParseException, JsonMappingException, IOException {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        // 添加用户信息
//        modelMap.put("success", userService.addUser(user));
//        return modelMap;
//    }
//
//
//    @RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
//    private Map<String, Object> modifyUser(@RequestBody User user)
//            throws JsonParseException, JsonMappingException, IOException {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        // 修改用户信息
//        modelMap.put("success", userService.modifyUser(user));
//        return modelMap;
//    }
//
//    @RequestMapping(value = "/removeuser", method = RequestMethod.GET)
//    private Map<String, Object> removeUser(Integer userId) {
//        Map<String, Object> modelMap = new HashMap<String, Object>();
//        // 修改用户信息
//        modelMap.put("success", userService.deleteUser(userId));
//        return modelMap;
//    }
//
//}
