package io.github.tawn0000.curation.web;


import io.github.tawn0000.curation.entity.*;
import io.github.tawn0000.curation.service.impl.ExhibitionServiceImpl;
import io.github.tawn0000.curation.service.impl.IbeanconServiceImpl;
import io.github.tawn0000.curation.service.impl.RecordServiceImpl;
import io.github.tawn0000.curation.service.impl.UEServiceImpl;
import io.github.tawn0000.curation.utils.DateUtil;
import io.github.tawn0000.curation.utils.Responsetil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;


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

    @Autowired
    private IbeanconServiceImpl ibeanconService;

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
        Transform(exhibitionTokens, eidList);
       map.put("exhibition",exhibitionTokens);
       return exhibitionTokens;
    }

    public void Transform(List<ExhibitionToken> exhibitionTokens, List<Long> eidList)
    {
        for(Long eid : eidList){
            ExhibitionToken exhibitionToken = new ExhibitionToken(exhibitionService.queryExhibitionById(eid));
            exhibitionToken.seteImage(exhibitionPath + '/'+ exhibitionToken.geteImage());
            exhibitionTokens.add(exhibitionToken);
        }
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
            exhibitionToken.seteImage(exhibitionPath + '/'+ exhibitionToken.geteImage());
            exhibitionTokens.add(exhibitionToken);
        }
        return exhibitionTokens;
    }

    @ApiOperation(value = "获取用户的体验")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @GetMapping("/experience")
    @ResponseBody
    public Object experience(Long id){
        //已体验
        Map<Object, Object> result = new HashMap<>();
        List<Long> experiencedList = ueService.queryUEByUeStatus(id, 3);
        List<ExhibitionToken> experienceExhibitions = new ArrayList<>();
        Transform(experienceExhibitions,experiencedList);
        result.put("Experienced",experienceExhibitions);

        //已报名
        List<Long> noExperiencedList = ueService.queryUEByUeStatus(id, 1);
        List<ExhibitionToken> experienceNoExhibitions = new ArrayList<>();
        Transform(experienceNoExhibitions, noExperiencedList);
        result.put("NoExperienced",experienceNoExhibitions);
        return Responsetil.ok(result);
    }


    @ApiOperation(value = "插入记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "uid", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "eid", value = "展览id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "begin", value = "开始时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "end", value = "结束时间", required = true, dataType = "Date"),
            @ApiImplicitParam(name = "uuid", value = "ibeaconID", required = true, dataType = "String")
    })
    @PostMapping("/record")
    public Object insertRecord(Long uid, Long eid, Date begin, Date end, String uuid) {
        Long e1id = ibeanconService.queryExhibitByUuid(uuid);
        Record record = new Record(uid, eid, e1id, DateUtil.dateToTime(begin), DateUtil.dateToTime(end), (int) (DateUtil.dateToTime(end).getTime() / 1000 - DateUtil.dateToTime(begin).getTime() / 1000));
        recordService.addRecord(record);
        return Responsetil.ok();
    }

    @ApiOperation(value = "生成体验结果图片")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "uid", value = "用户id",required = true, dataType = "Long"),
        @ApiImplicitParam(name = "eid", value = "展览id",required = true,dataType = "Long"),
        })
    @GetMapping("/end")
    @ResponseBody
    public Map<Object,Object> end(Long uid, Long eid) {

        if(ueService.queryUEByUidEid(uid,eid) == null)
            ueService.addUE(new UE(uid,eid,3,null, DateUtil.dateToTime(GregorianCalendar.getInstance().getTime()),null,null,null,null));

        UE ue = ueService.queryUEByUidEid(uid,eid);
        ue.setUeStatus(3);
        ue.setUeTime(DateUtil.dateToTime(GregorianCalendar.getInstance().getTime()));
        ueService.modifyUE(ue);

        String basePath = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath();
        System.out.println(basePath);

        Map<Object, Object> map = new HashedMap();

        String[] color_path = {"00","01red","02orange","03yellow","04green","05cyan","06blue","07pruple"};
        String[] times_path = {"00","01one","02two","03three","04four","five"};
        String[] ave_path = {"00","01","02","03","04"};
        int low,high,ave,times,dur,dur_sum;
        low = ue.getUeHeartRateMin() == null? 0: ue.getUeHeartRateMin();
        high = ue.getUeHeartRateMax() == null? 0: ue.getUeHeartRateMax();
        ave = ue.getUeHeartRateAve() == null? 0: ue.getUeHeartRateAve();
        times = ue.getUeHeartTimes() == null? 0: ue.getUeHeartTimes();
        dur = 0;
        dur_sum = 0;
        System.out.println("END");
        List<Record>  recordList = recordService.queryRecordById(uid,eid);
        String exhibit_dur_name = "";

        Map <String,Integer>  mp =  new HashedMap();;

        for(Record record : recordList)
        {
            if(record.getrInterval() == null)
                record.setrInterval((int) (record.getrEndTime().getTime()/1000  - record.getrBeginTime().getTime()/1000));
            dur_sum += record.getrInterval();

            dur = record.getrInterval();
            exhibit_dur_name = exhibitionService.queryExhibitById(record.getE1Id()).getE1Name();

            if(mp.containsKey(exhibit_dur_name) == false) mp.put(exhibit_dur_name,dur);
            else mp.put(exhibit_dur_name,mp.get(exhibit_dur_name)+dur);

            for(String obj : mp.keySet())
                if(dur < mp.get(obj))
                {
                    dur = mp.get(obj);
                    exhibit_dur_name = obj;
                }
        }

        int dur_m = dur/60;

        low = Math.min(low,129);
        low = Math.max(low,60);
        high = Math.min(high,129);
        high = Math.max(low,60);
        ave = Math.min(ave,104);
        ave = Math.max(ave,65);
        dur_m = Math.min(dur_m,44);
        dur_m = Math.max(dur_m,0);
        times = Math.max(times,100);
        times = Math.min(times,500);

        int low_idx = 13-low/10;
        int high_idx = 13-high/10;
        int times_idx = times/100;
        int ave_idx = 11 - (ave+5)/10;
        int dur_idx = dur_m/5 + 1;

        /*
        :param background: 背景图
        :param center: 中心图案
        :param text_area 背景文字图
        :param exhibition: 展览图案
        :param target 输出的图片路径
        :param text_result:总结
        :param text_grade: 来电等级
        :param text_fav:喜爱度
        :param text_fresh:新鲜度
        :param text_heart_range: 心动范围
         */
        String background = "background/" + "0" + low_idx + "0" + high_idx + "0"+ times_idx + "-0" + ave_idx + ".png";;
        String center = "pattern/" + "0" + low_idx + "0" + high_idx + "0" + times_idx + "0" + dur_idx +  "-0" + ave_idx + ".png";
        String text_area = "text_area.png";
        String exhibition_path = "exhibition.png";
        String target =  transPath(ueReportPath) + "/" + uid.toString() + "-" + eid.toString() + ".png";
        String text_result = "在展览中，你在《" + exhibit_dur_name +"》前停留了"+ (dur/60) + "分"+ (dur%60) + "秒，你是不是对它产生共鸣了？";
        String text_grade = ""+ times_idx;
        String text_fav =  ave + "/min";
        String text_fresh = (dur_sum/3600) + "h" + (dur_sum/60%60) + "min";
        String text_heart_range = low + "-" + high + "/min";


        String headpath = "./Image_merge/";
        //String[] arg = {"python","../Image_merge/test.py","050702-02.png", "center.png", "text_area.png",  "exhibition.png", "./out.png", "dfs", "4", "88/min", "1h02min", "65-75/min"};
        String[] arg = new String [12];
        arg[0] = "python";
        arg[1] = headpath + "test.py";
        arg[2] = headpath + background;
        arg[3] = headpath + center;
        arg[4] = headpath + text_area;
        arg[5] = headpath + exhibition_path;
        arg[6] = target;
        arg[7] = text_result;
        arg[8] = text_grade;
        arg[9] = text_fav;
        arg[10] = text_fresh;
        arg[11] = text_heart_range;
        for(String x : arg)
            System.out.println(x);
        try{
                Runtime.getRuntime().exec(arg);
            System.out.println("true");

        }catch (Exception exhibition)
        {
            System.out.println("false");
        }
       // map.put("arg",arg);
        map.put("report-path",target);
        return map;
    }
    @ApiOperation(value = "获得体验结果报告图片")
    @ApiImplicitParams( {
        @ApiImplicitParam(name = "uid", value = "用户id",required = true, dataType = "Long"),
        @ApiImplicitParam(name = "eid", value = "展览id",required = true,dataType = "Long"),
    })
    @GetMapping("/report")
    @ResponseBody
    public Map<Object,Object> report(Long uid, Long eid)
    {
        Map map = new HashedMap();
        String res = ueReportPath;
        String temp_res = transPath(res)+ "/" + uid.toString() +"-"+ eid.toString() + ".png";
        File file=new File(temp_res);
        res = res + "/" + uid.toString() +"-"+ eid.toString() + ".png";
        System.out.println("file:"+ file);

        if(file.exists())
            map.put("report_path",res);
        else {
            end(uid, eid);
            map.put("report_path",res);
            //else map.put("msg","无用户体验结果......");
        }
        return map;
    }

    @ApiOperation(value= "已参观展览的详细信息")
    @ApiImplicitParam(name = "eid", value = "展览id", required = true, dataType = "Long")
    @GetMapping("/detail")
    public Exhibition detail (Long eid){
        Exhibition exhibition = exhibitionService.queryExhibitionById(eid);
        return exhibition;
    }

    @ApiOperation(value = "上传excel")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Excel",value = "excel文件",required = true,dataType = "file"),
            @ApiImplicitParam(name = "eid", value = "展览id", required = true,dataType = "Long")}
    )
    @PostMapping("/insert/heart_rate")
    public Object readMultipartFile(MultipartFile file, Long eid)throws IOException {
        InputStream input = file.getInputStream();
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(input);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(localDateTime.toString());
        //取工作表
        XSSFSheet sheet = wb.getSheetAt(0);
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            Long uid = (Long) Math.round(row.getCell(0).getNumericCellValue());
            Integer max = new Integer((int) Math.round(row.getCell(1).getNumericCellValue())) ;
            Integer min = Integer.valueOf((int) Math.round(row.getCell(2).getNumericCellValue()));
            Integer ave = Integer.valueOf((int) Math.round(row.getCell(3).getNumericCellValue()));
            Integer num = Integer.valueOf((int) Math.round(row.getCell(4).getNumericCellValue()));
            UE ue = new UE(uid,eid,Integer.valueOf(1),Integer.valueOf(1),timestamp,min,max,ave,num);
            if(ueService.queryUEByUidEid(uid,eid) == null)
                ueService.addUE(ue);
            else ueService.modifyUE(ue);
        }
        return Responsetil.ok();
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
