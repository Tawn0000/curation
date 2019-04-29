package io.github.tawn0000.curation.web;


import io.github.tawn0000.curation.entity.Exhibition;
import io.github.tawn0000.curation.entity.ExhibitionToken;
import io.github.tawn0000.curation.entity.UE;
import io.github.tawn0000.curation.entity.Record;
import io.github.tawn0000.curation.service.impl.ExhibitionServiceImpl;
import io.github.tawn0000.curation.service.impl.RecordServiceImpl;
import io.github.tawn0000.curation.service.impl.UEServiceImpl;
import io.github.tawn0000.curation.utils.Responsetil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Api(value = "个人中心展览信息",tags = "PersonalExhibition")
@RestController
@RequestMapping("/personal")
public class PersonalExhibitionController {

    @Autowired
    @Qualifier("UEServiceImpl")
    private UEServiceImpl ueService;

    @Autowired
    private ExhibitionServiceImpl exhibitionService;

    @Autowired
    private RecordServiceImpl recordService;

    @Value("${curation.exhibitions-path}")
    private String exhibitionPath;

    @Value("${curation.ue-report-path}")
    private  String ueReportPath;

    @ApiOperation(value = "获取收藏信息")
    @ApiImplicitParam(name="id",value = "用户id", required = true, dataType = "Long")
    @GetMapping("/collect")
    @ResponseBody
    public List<ExhibitionToken>  collect(Long id)
    {
        Map<String, Object> map = new HashMap<String, Object>();
       // System.out.println("**");
        List<Long> eidList = ueService.queryExhibitionByUid(id);
        List<ExhibitionToken> exhibitionTokens = new ArrayList<>();
        for(Long eid : eidList){
            ExhibitionToken exhibitionToken = new ExhibitionToken(exhibitionService.queryExhibitionById(eid));
            exhibitionTokens.add(exhibitionToken);
        }
        //System.out.println(exhibitionTokens.size());
       map.put("exhibition",exhibitionTokens);
       return exhibitionTokens;
    }

    @ApiOperation(value = "获取历史足迹信息")
    @ApiImplicitParam(name = "id",value = "用户id", required = true, dataType = "Long")
    @GetMapping("/history")
    @ResponseBody
    public List<ExhibitionToken> history(Long id)
    {
        //System.out.println("IIIII");
        List<UE> ueList = ueService.queryUEByUid(id);
       //System.out.println(ueList.size());
        List<ExhibitionToken> exhibitionTokens = new ArrayList<>();
        for(UE ue : ueList){
            ExhibitionToken exhibitionToken = new ExhibitionToken(exhibitionService.queryExhibitionById(ue.geteId()));
            exhibitionTokens.add(exhibitionToken);
        }
        return exhibitionTokens;
    }

    @ApiOperation(value = "获取用户的体验")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @GetMapping("/experience")
    public Object experience(Long id){
        //已体验
        Map<Object, Object> result = new HashMap<>();
        List<Long> experiencedList = ueService.queryUEByUeStatus(id, 3);
        List<ExhibitionToken> experienceExhibitions = new ArrayList<>();
        for(Long eid : experiencedList){
            ExhibitionToken exhibitionToken = new ExhibitionToken(exhibitionService.queryExhibitionById(eid));
            experienceExhibitions.add(exhibitionToken);
        }
        result.put("Experienced",experienceExhibitions);

        //已报名
        List<Long> noExperiencedList = ueService.queryUEByUeStatus(id, 1);
        List<ExhibitionToken> experienceNoExhibitions = new ArrayList<>();
        for(Long eid : noExperiencedList){
            ExhibitionToken exhibitionToken = new ExhibitionToken(exhibitionService.queryExhibitionById(eid));
            experienceNoExhibitions.add(exhibitionToken);
        }
        result.put("NoExperienced",experienceNoExhibitions);
        return Responsetil.ok(result);
    }


    @ApiOperation(value = "生成体验结果图片")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "uid", value = "用户id",required = true, dataType = "Long"),
        @ApiImplicitParam(name = "eid", value = "展览id",required = true,dataType = "Long"),
        })
    @GetMapping("/end")
    public Map<Object,Object> end(Long uid, Long eid) {
        Map<Object, Object> map = new HashedMap();

        String[] color_path = {"00","01red","02orange","03yellow","04green","05cyan","06blue","07pruple"};
        String[] times_path = {"00","01one","02two","03three","04four","five"};
        String[] ave_path = {"00","01","02","03","04"};

        int low,high,ave,times,dur;
        UE ue = ueService.queryUEByUidEid(uid,eid);
        low = ue.getUeHeartRateMin();
        high = ue.getUeHeartRateMax();
        ave = ue.getUeHeartRateAve();
        times = ue.getUeHeartTimes();
        dur = 0;
        List<Record>  recordList = recordService.queryRecordById(uid,eid);
        for(Record record : recordList)
        {
            if(record.getrInterval() == null)
                record.setrInterval((int) (record.getrEndTime().getTime()/60000  - record.getrBeginTime().getTime()/60000));
            dur = Math.max(dur,record.getrInterval());
        }

        low = Math.min(low,129);
        low = Math.max(low,60);
        high = Math.min(high,129);
        high = Math.max(low,60);
        ave = Math.min(ave,114);
        ave = Math.max(ave,65);
        dur = Math.min(dur,44);
        dur = Math.max(dur,0);

        int low_idx = 13-low/10;
        int high_idx = 13-high/10;
        int times_idx = times/100;
        int ave_idx = 12 - (ave+5)/10;
        int dur_idx = dur/5 + 1;
        /*
        :param background: 背景图
        :param center: 中心图案
        :param text_area 背景文字图
        :param exhibition: 展览图案
        :param target 输出的图片路径
        :param text_level: 文本内容
        :param text_result:总结
        :param text_grade: 来电等级
        :param text_fav:喜爱度
        :param text_fresh:新鲜度
        :param text_heart_range: 心动范围
         */

        String background = "background/" + "0" + low_idx + "0" + high_idx + "0"+ times_idx + "-0" + ave_idx + ".png";;
        String center = "pattern/" + "0" + low_idx + "0" + high_idx + "0" + times_idx + "0" + dur +  ".png";
        String text_area = "text_area.png";
        String exhibition_path = "exhibition.png";
        String target =  transPath(ueReportPath) + "/" + uid.toString() + eid.toString() + ".png";
        String text_level ;
        String text_result;
        String text_grade;
        String text_fav;
        String text_fresh;
        String text_heart_range;



        return map;
    }


    @ApiOperation(value = "获得体验结果报告图片")
    @ApiImplicitParams( {
        @ApiImplicitParam(name = "uid", value = "用户id",required = true, dataType = "Long"),
        @ApiImplicitParam(name = "eid", value = "展览id",required = true,dataType = "Long"),
    })
    @GetMapping("/report")
    public Map<Object,Object> report(Long uid, Long eid)
    {
        Map map = new HashedMap();
        String res = ueReportPath + "/" + uid.toString() + eid.toString() + ".png";
        File file=new File(res);
        if(file.exists())
            map.put("report_path",res);
        else map.put("msg","无用户体验结果");
        return map;
    }

    @ApiOperation(value= "已参观展览的详细信息")
    @ApiImplicitParam(name = "eid", value = "展览id", required = true, dataType = "Long")
    @GetMapping("/detail")
    public Exhibition detail (Long eid){
        Exhibition exhibition = exhibitionService.queryExhibitionById(eid);
        return exhibition;
    }


    public String transPath(String path) {
        String basePath = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath() + "\\files";
        basePath = basePath.replaceAll("\\\\", "/");
        File file = new File(basePath + path);
        //如果文件夹不存在则创建
        System.out.println(basePath + path);
        if (!file.exists() && !file.isDirectory()) {
            System.out.println("//不存在");
            file.mkdirs();
        }
        else {
            System.out.println("// 目录存在");
        }
        return basePath + path;
    }
}
