package io.github.tawn0000.curation.web;


import io.github.tawn0000.curation.entity.User;
import io.github.tawn0000.curation.service.UserService;
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
import io.github.tawn0000.curation.utils.Responsetil;
import io.github.tawn0000.curation.utils.UploadUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Api(value = "用户相关接口", tags = "user")
@RestController
@RequestMapping("/user")
class UserController{

    @Autowired
    private UserService userService;

    //用户头像路径
    @Value("/tmp/curation/user")
    private String userFacePath;

    @ApiOperation(value = "获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID",required = true ,dataType = "String")
    @GetMapping("/detail")
    @ResponseBody
    public User detail(Long id)
    {
        return userService.getUserById(id);
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
