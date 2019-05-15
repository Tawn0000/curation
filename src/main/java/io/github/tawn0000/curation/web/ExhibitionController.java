package io.github.tawn0000.curation.web;


import io.github.tawn0000.curation.entity.*;
import io.github.tawn0000.curation.service.impl.CommentServiceImpl;
import io.github.tawn0000.curation.service.impl.ExhibitionServiceImpl;
import io.github.tawn0000.curation.service.impl.UEServiceImpl;
import io.github.tawn0000.curation.utils.DateUtil;
import io.github.tawn0000.curation.utils.Responsetil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "展览相关接口", tags = "Exhibition")
@RestController
@RequestMapping("/exhibition")
public class ExhibitionController {

    @Autowired
    @Qualifier("UEServiceImpl")
    private UEServiceImpl ueService;

    @Autowired
    private ExhibitionServiceImpl exhibitionService;

    @Autowired
    private CommentServiceImpl commentService;

    @Value("${curation.exhibitions-path}")
    private String exhibitionPath;


    @ApiOperation(value = "获取该地址的展览信息")
    @ApiImplicitParam(name = "address",value = "地址",required = true, dataType = "String")
    @RequestMapping(value = "/queryByAddress",method = RequestMethod.GET)
    public Map <String, Object> queryByAddress(String address){
        Map<String, Object> map = new HashMap<String, Object>();
        List<ExhibitionToken> exhibitionTokenList = exhibitionService.queryExhibitionByAddress(address);
        for(ExhibitionToken x : exhibitionTokenList)
            x.seteImage(exhibitionPath + '/'+ x.geteImage());
        map.put("exhibitionTokenList",exhibitionTokenList);
       // System.out.println(exhibitionTokenList.size());
        return map;
    }

    @ApiOperation(value = "展览详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "eid", value = "展览id", required = true, dataType = "Long")
    })
    @RequestMapping(value = "/detail" , method = RequestMethod.GET)
    //展览、展品、评论
    public Map<Object,Object> queryExhibitByEid(Long uid,Long eid){
        Map<Object,Object> result = new HashMap<>();
        System.out.println(eid);
        UE ue = new UE(uid,eid,1,null, DateUtil.dateToTime(GregorianCalendar.getInstance().getTime()),null,null,null,null);
        if(ueService.queryUEByUidEid(uid,eid) == null)
            ueService.addUE(ue);
        else
        {
            ue = ueService.queryUEByUidEid(uid,eid);
            ue.setUeTime(DateUtil.dateToTime(GregorianCalendar.getInstance().getTime()));
            ueService.modifyUE(ue);
        }

        Exhibition exhibition = exhibitionService.queryExhibitionById(eid);
        result.put("exhibition", exhibition);
        List<Exhibit> exhibitList = exhibitionService.queryExhibitByEid(eid);
        result.put("exhibit",exhibitList);
        List<Comment> commentList = commentService.queryCommentByEid(eid);
        result.put("comment",commentList);
        return result;
    }

    @ApiOperation(value = "插入评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "eid", value = "展览id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "grade", value = "评分", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "time", value = "时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "context", value = "评论内容", required = true, dataType = "String"),
            @ApiImplicitParam(name = "Image_file", value = "图片", required = true, dataType = "String")
    })
    @PostMapping("/insert")
    public Object insertComment(Long uid, Long eid, Integer grade, Date time, String context,String Image_file){

//        MultipartHttpServletRequest multipartHttpServletRequest;
//        System.out.println("insert uid：" + uid);
//        List<MultipartFile> fileList = multipartHttpServletRequest.getFiles("IMAGES");
//        if(fileList != null){
//            String uploadDir = exhibitionPath + "/" + Long.toString(eid) + "/" + "comments" + "/" + Long.toString(uid) ;
//            for (MultipartFile file:fileList){
//                String originalFilename = timestamp.toString() + file.getOriginalFilename();
//                if(originalFilename == null || originalFilename.lastIndexOf(".") == -1){
//                    return Responsetil.badArgument();
//                }
//                UploadUtil.uploadFile(file,uploadDir,originalFilename);
//            }
             System.out.println(time);
            Comment comment = new Comment(uid,eid,grade,DateUtil.dateToTime(time),context,Image_file);
            commentService.addComment(comment);
            return Responsetil.ok();
//        }
////        else {
////            return Responsetil.badArgument();
////        }
    }

    public String transPath(String path) {
        String basePath = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath() + "\\files";
        basePath = basePath.replaceAll("\\\\", "/");
        File file = new File(basePath + path);
        //如果文件夹不存在则创建
        System.out.println(basePath + path);
        if (!file.exists() && !file.isDirectory()) {
            System.out.println("//不存在的文件路径");
            file.mkdirs();
        }
        else {
            System.out.println("// 目录存在");
        }
        return basePath + path;
    }

}
