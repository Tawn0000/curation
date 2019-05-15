-- 删除数据库
-- Drop database curation;

# --创建数据库 curation

create database curation;

# --创建表
    use curation;

#-- 用户（自增用户编号，微信号，姓名，性别，头像，蓝牙权限(开/关）,是否填写过调查问卷，喜好标签)


CREATE TABLE `User` (
        `u_id` bigint auto_increment primary key ,
        `open_id` varchar(150) unique not null ,
        `u_name` varchar(32)  ,
        `u_sex` varchar(3) ,
        `u_icon` varchar(300) ,
        `u_query_status` varchar(3) default '否',
        `u_tag` varchar(50)
        )DEFAULT CHARSET=utf8;

# 管理员 (自增管理员编号，微信号，密码，姓名，管理权限级别)

CREATE TABLE `Admin`(
        `a_id` int auto_increment primary key ,
        `open_id` varchar(20) not null ,
        `a_password` varchar(32) not null ,
        `a_name` varchar(20) not null ,
        `a_level` int default '1' not null
            )DEFAULT CHARSET=utf8;

# 展览（自增展览编号，名称，地点，时间，价格,展览描述，图片,视频，负责人）

CREATE TABLE `Exhibition`(
        `e_id` bigint auto_increment primary key ,
        `e_name` varchar(100) not null ,
        `e_address` varchar(100)  ,
        `e_begin_date` datetime  ,
        `e_end_date` datetime,
        `e_price` int ,
        `e_description` text ,
        `e_image` varchar(300) ,
        `e_video` varchar(300) ,
        `e_person_in_charge` varchar(20) 
        )DEFAULT CHARSET=utf8;

# 展品 (自增展品编号，展览编号，展品名称，作者，年代，图片，内容介绍)

CREATE TABLE `Exhibit`(
        `e1_id` bigint auto_increment primary key ,
        `e_id` bigint not null,
        `e1_name` varchar(100) not null ,
        `e1_author` varchar(20)  ,
        `e1_date`  date ,
        `e1_image` varchar(300),
        `e1_description` text
        )DEFAULT CHARSET=utf8;

# 评论 (自增评论编号，用户编号，展览编号，展品编号，评论时间，评论文字内容，评论图片)

CREATE TABLE `Comment`(
         `c_id` bigint auto_increment primary key ,
         `u_id` bigint not null ,
         `e_id` bigint not null ,
         `c_grade` int ,
         `c_date` datetime not null ,
         `c_content` text ,
         `c_image` varchar(300) 
                      )DEFAULT CHARSET=utf8;

# 用户反馈（自增编号，用户编号，反馈内容,图片,电话号码,反馈时间）

CREATE TABLE `Feedback`(
         `f_id` bigint auto_increment primary key ,
         `u_id` bigint not null ,
         `f_content` text not null,
         `f_image` varchar(300),
         `f_phone_number` varchar(20),
         `f_time` datetime
         )DEFAULT CHARSET=utf8;

# 蓝牙Ibeacon(自增蓝牙编号，UUID, Marjor ,Minor, Measured_Power, Status, Connect_E1_id, Wide)

CREATE TABLE `Ibeacon`(
         `i_id` bigint auto_increment primary key ,
         `i_uid` varchar(50) unique not null ,
         `i_major` varchar(50) ,
         `i_minor` varchar(50) ,
         `i_measured_power` varchar(50) ,
         `i_status` tinyint default 0  not null ,
         `i_connect_e1_id`  bigint,
         `i_wide` float default  '1'
)DEFAULT CHARSET=utf8;

# 用户观展记录（自增编号，用户编号 , 展览编号, 展品编号，开始时间，结束时间，停留时长，心率）

CREATE TABLE `Record`(
        `r_id` bigint auto_increment primary key ,
        `u_id` bigint not null ,
        `e_id` bigint not null ,
        `e1_id` bigint not null ,
        `r_begin_time` datetime  ,
        `r_end_time` datetime  ,
        `r_interval` int
        )DEFAULT CHARSET=utf8;


# 用户_展览（自增编号，用户编号，展览编号，状态（未报名，已报名，正在参加，已参加）,是否收藏，最后一次访问时间）

CREATE TABLE `UE`(
        `ue_id` bigint auto_increment primary key ,
        `u_id` bigint not null ,
        `e_id` bigint not null ,
        `ue_status` int not null default '0' ,
        `ue_collection` tinyint default '0',
        `ue_time` datetime,
        `ue_heart_rate_min` int,
        `ue_heart_rate_max` int,
        `ue_heart_rate_ave` int,
        `ue_heart_times` int
        )DEFAULT CHARSET=utf8;


# 展览_标签（自增编号，展览编号，展览标签）

CREATE TABLE `E_tag`(
        `et_id` bigint auto_increment primary key ,
        `e_id` bigint not null ,
        `e_tags` varchar(20) not null
        )DEFAULT CHARSET=utf8;




INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeeff1',1,1);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeeff2',1,2);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeeff3',1,3);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeeff4',1,4);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeeff5',1,5);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeeff6',1,6);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeeff7',1,7);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeeff8',1,8);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeeff9',1,9);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_status`, `i_connect_e1_id`) VALUES ('01122334-4556-6778-899a-abbccddeef10',1,10);

#插入展品
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品1', '张宇', '2019-04-16', '1.jpg', '精美');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品2', '张宇', '2019-04-16', '1.jpg', '大气');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品3', '张宇', '2019-04-16', '1.jpg', '精美');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品4', '张宇', '2019-04-16', '1.jpg', '大气');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品5', '张宇', '2019-04-16', '1.jpg', '精美');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品6', '张宇', '2019-04-16', '1.jpg', '大气');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品7', '张宇', '2019-04-16', '1.jpg', '精美');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品8', '张宇', '2019-04-16', '1.jpg', '大气');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品9', '张宇', '2019-04-16', '1.jpg', '精美');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '展品10', '张宇', '2019-04-16', '1.jpg', '大气');

#插入展览
INSERT INTO `curation`.`Exhibition` (`e_name`, `e_address`, `e_begin_date`,`e_end_date`, `e_price`, `e_description`, `e_image`, `e_video`, `e_person_in_charge`) VALUES ('简至诗意升起时(SIMPLICITY CREATES POETRY', '江苏省无锡市滨湖区蠡湖大道500号', '2019-05-22 14:00:00','2019-07-15 17:00:00', 0, '约翰·莫尔绘画奖（中国）特展', '1.jpg', '1.mp4', '王雨晴');
