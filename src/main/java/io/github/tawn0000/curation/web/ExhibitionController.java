package io.github.tawn0000.curation.web;


import io.github.tawn0000.curation.entity.Comment;
import io.github.tawn0000.curation.entity.Exhibit;
import io.github.tawn0000.curation.entity.Exhibition;
import io.github.tawn0000.curation.entity.ExhibitionToken;
import io.github.tawn0000.curation.service.CommentService;
import io.github.tawn0000.curation.service.ExhibitionService;
import io.github.tawn0000.curation.service.impl.CommentServiceImpl;
import io.github.tawn0000.curation.service.impl.ExhibitionServiceImpl;
import io.github.tawn0000.curation.utils.Responsetil;
import io.github.tawn0000.curation.utils.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value = "展览相关接口", tags = "Exhibition")
@RestController
@RequestMapping("/exhibition")
public class ExhibitionController {
    @Autowired
    private ExhibitionServiceImpl exhibitionService;

    @Autowired
    private CommentServiceImpl commentService;

    @Value("${curation.exhibitions-path}")
    private String exhibitionsPath;

    @ApiOperation(value = "获取该地址的展览信息")
    @ApiImplicitParam(name = "address",value = "地址",required = true, dataType = "String")
    @RequestMapping(value = "/queryByAddress",method = RequestMethod.GET)
    public Map <String, Object> queryByAddress(String address){
        Map<String, Object> map = new HashMap<String, Object>();
        List<ExhibitionToken> exhibitionTokenList = exhibitionService.queryExhibitionByAddress(address);
        map.put("exhibitionTokenList",exhibitionTokenList);
       // System.out.println(exhibitionTokenList.size());
        return map;
    }

    @ApiOperation(value = "展览详细信息")
    @ApiImplicitParam(name = "eid", value = "展览id", required = true, dataType = "Long")
    @RequestMapping(value = "/detail" , method = RequestMethod.GET)
    //展览、展品、评论
    public Map<Object,Object> queryExhibitByEid(Long eid){
        Map<Object,Object> result = new HashMap<>();
        System.out.println(eid);
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
            @ApiImplicitParam(name = "time", value = "时间", required = true, dataType = "Timestamp"),
            @ApiImplicitParam(name = "context", value = "评论内容", required = true, dataType = "String"),
            @ApiImplicitParam(name = "Image", value = "图片", required = true, dataType = "file")
    })
    @PostMapping("/insert")
    public Object insertComment(MultipartHttpServletRequest multipartHttpServletRequest, Long uid, Long eid, Integer grade, Timestamp timestamp, String context){

        List<MultipartFile> fileList = multipartHttpServletRequest.getFiles("IMAGES");
        if(fileList != null){
            String uploadDir = exhibitionsPath + "/" + Long.toString(eid) + "/" + "comments" + "/" + Long.toString(uid) ;
            for (MultipartFile file:fileList){
                String originalFilename = timestamp.toString() + file.getOriginalFilename();
                if(originalFilename == null || originalFilename.lastIndexOf(".") == -1){
                    return Responsetil.badArgument();
                }
                UploadUtil.uploadFile(file,uploadDir,originalFilename);
            }
            Comment comment = new Comment(uid,eid,grade,timestamp,context,uploadDir);
            commentService.addComment(comment);
            return Responsetil.ok();
        }
        else {
            return Responsetil.badArgument();
        }
    }

}
