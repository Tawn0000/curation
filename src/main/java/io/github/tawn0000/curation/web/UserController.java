package io.github.tawn0000.curation.web;


import io.github.tawn0000.curation.entity.Feedback;
import io.github.tawn0000.curation.entity.User;
import io.github.tawn0000.curation.service.FeedbackService;
import io.github.tawn0000.curation.service.UserService;
import io.github.tawn0000.curation.service.impl.FeedbackServiceImpl;
import io.github.tawn0000.curation.service.impl.UserServiceImpl;
import io.github.tawn0000.curation.utils.Responsetil;
import io.github.tawn0000.curation.utils.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

@Api(value = "用户相关接口", tags = "user")
@RestController
@RequestMapping("/user")
class UserController{

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private FeedbackServiceImpl feedbackService;

    //用户头像路径
    @Value("${curarion.user-image-path}")
    private String userFacePath;

    //用户反馈图像路径
    @Value("${curation.user-feedback-path}")
    private String userFeedbackPath;

    @ApiOperation(value = "获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID",required = true ,dataType = "Long")
    @GetMapping("/detail")
    @ResponseBody
    public User detail(Long id)
    {
        return userService.getUserById(id);
    }

//    @ApiOperation(value = "用户修改个人信息")
//    @ApiImplicitParam(name = "id", value = "用户 Id", required = true, dataTypeClass = "io.github.tawn0000.curation.entity.User")
    @PostMapping("/update")
    public Object update(User user){
        if(userService.modifyUser(user))
            return Responsetil.ok();
        else
            return Responsetil.badArgument();
    }


    @ApiOperation(value = "用户反馈")
    @PostMapping("/feedback")
    public Object back(MultipartHttpServletRequest multipartHttpServletRequest, Long uid, String context, String phone, Timestamp timestamp){
        //评论图片上传
        MultipartFile file = multipartHttpServletRequest.getFile("IMAGE");

        if(file != null){
            String originalFilename = file.getOriginalFilename();
            if(originalFilename == null || originalFilename.lastIndexOf(".") == -1){
                return Responsetil.badArgument();
            }
            String filename = Long.toString(uid) + timestamp.toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
            UploadUtil.uploadFile(file,userFeedbackPath,filename);
            Feedback feedback = new Feedback(uid, context, filename, phone, timestamp);
            feedbackService.addFeedback(feedback);
            return Responsetil.ok();
        }
        else
        {
            return Responsetil.badArgument();
        }
    }

    @ApiOperation(value = "上传头像")
    @PostMapping("/upload")
    public Object uploadAvatar(MultipartHttpServletRequest multipartHttpServletRequest,Long id){
        //文件上传
        MultipartFile file = multipartHttpServletRequest.getFile("IMAGE");

        User user = userService.getUserById(id);
        if(user != null && file != null){
            String originalFilename = file.getOriginalFilename();
            if(originalFilename == null || originalFilename.lastIndexOf(".") == -1){
                return Responsetil.badArgument();
            }
            String filename = user.getuId() + originalFilename.substring(originalFilename.lastIndexOf("."));
            user.setuIcon(filename);
            UploadUtil.uploadFile(file, userFacePath, filename);
            userService.modifyUser(user);
            return Responsetil.ok();
        }
        else {
            return Responsetil.badArgument();
        }
    }

    @Autowired
    ResourceLoader resourceLoader;

    @ApiOperation(value = "获取用户头像")
    @GetMapping("/avatar")
    public Object avatar (Long id){
        User user = userService.getUserById(id);
        if(user == null){
            return Responsetil.badArgument();
        }

        String avatarPath = userFacePath + "/" + user.getuIcon();
        Path path = Paths.get(avatarPath);
        Resource resource = resourceLoader.getResource("file:" + path.toString());
        try{
            String mediaType = Files.probeContentType(path);
            if(mediaType == null){
                return Responsetil.fail(404,"不存在该图片");
            }
            return ResponseEntity.ok().contentType(MediaType.valueOf(mediaType)).body(resource);
        }catch (IOException e){
            e.printStackTrace();
        }
        return Responsetil.badArgument();
    }
}
