
---删除数据库
    Use master
    go
    Drop database curation;

---创建数据库 curation

CREATE Database curation;

---创建表
    use curation;
    go

-- 用户（自增用户编号，微信号，姓名，性别，头像，蓝牙权限(开/关）,是否填写过调查问卷，喜好标签)

CREATE TABLE [dbo].[User](
        [u_id] [bigint] identity(1,1) ,
        [open_id] [varchar](20) unique NOT NULL ,
        [u_name] [varchar](32)  ,
        [u_sex] [varchar](3)  default '男' check (U_sex in ('男','女')),
        [u_icon] [varchar](300) ,
        [u_query_status] [varchar](3) default '否' check (u_query_status in ('是','否')),
        [u_tag] [varchar](50) ,
        CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED ([u_id] ASC )
        );

-- 管理员 (自增管理员编号，微信号，密码，姓名，管理权限级别)

CREATE TABLE [dbo].[Admin](
        [a_id] [int] identity(1,1)  ,
        [open_id] [varchar](20) NOT NULL ,
        [a_password] [varchar](32) NOT NULL ,
        [a_name] [varchar](20) NOT NULL ,
        [a_level] [int] default '1' check(a_level in ('0','1')) NOT NULL,
        CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED ([a_id] ASC )
                    );

-- 展览（自增展览编号，名称，地点，时间，价格,展览描述，图片,视频，负责人）

CREATE TABLE [dbo].[Exhibition](
        [e_id] [bigint] identity(1,1) ,
        [e_name] [varchar](100) NOT NULL ,
        [e_address] [varchar](100)  ,
        [e_date] [datetime]  ,
        [e_price] [int] ,
        [e_description] text ,
        [e_image] varchar(300) ,
        [e_video] varchar(300) default NULL,
        [e_person_in_charge] varchar(20) ,
        CONSTRAINT [PK_Exhibition] PRIMARY KEY CLUSTERED ([e_id] ASC )
);

-- 展品 (自增展品编号，展览编号，展品名称，作者，年代，图片，内容介绍)

CREATE TABLE [dbo].[Exhibit](
        [e1_id] [bigint] identity(1,1) ,
        [e_id] [bigint] NOT NULL,
        [e1_name] [varchar](100) NOT NULL ,
        [e1_author] [varchar](20) NOT NULL ,
        [e1_date] [date] NOT NULL ,
        [e1_image] varchar(300) NOT NULL,
        [e1_description] text NOT NULL,
        CONSTRAINT [PK_Exhibit] PRIMARY KEY CLUSTERED ([e1_id] ASC )
);

-- 评论 (自增评论编号，用户编号，展览编号，展品编号，评论时间，评论文字内容，评论图片)

CREATE TABLE [dbo].[Comment](
         [c_id] [bigint] identity(1,1) ,
         [u_id] [bigint] NOT NULL ,
         [e_id] [bigint] NOT NULL ,
         [c_grade] [int] ,
         [c_date] [datetime] NOT NULL ,
         [c_content] text ,
         [c_image] varchar(300) ,
         CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED ([c_id] ASC )
);

-- 用户反馈（自增编号，用户编号，反馈内容,图片,电话号码,反馈时间）

CREATE TABLE [dbo].[Feedback](
         [f_id] [bigint] identity(1,1) ,
         [u_id] [bigint] NOT NULL ,
         [f_content] [text] NOT NULL,
         [f_image] [varchar](300),
         [f_phone_number] [varchar](20),
         [f_time] [datetime]
         CONSTRAINT [PK_Feedback] PRIMARY KEY CLUSTERED ([f_id] ASC )
);

-- 蓝牙Ibeacon(自增蓝牙编号，UUID, Marjor ,Minor, Measured_Power, Status, Connect_E1_id, Wide)

CREATE TABLE [dbo].[Ibeacon](
         [i_id] [bigint] identity(1,1) ,
         [i_uid] [varchar](50) unique NOT NULL ,
         [i_major] [varchar](50) NOT NULL,
         [i_minor] [varchar](50) NOT NULL,
         [i_measured_power] [varchar](50) NOT NULL,
         [i_status] bit default '0' check (i_status in ('0','1')) NOT NULL,
         [i_connect_e1_id]  [bigint],
         [i_wide] [float] default  '1'
          CONSTRAINT [PK_Ibeacon] PRIMARY KEY CLUSTERED ([i_id] ASC )
);

-- 用户观展记录（自增编号，用户编号 , 展览编号, 展品编号，开始时间，结束时间，停留时长，心率）

CREATE TABLE [dbo].[Record](

        [r_id] [bigint] identity(1,1),
        [u_id] [bigint] NOT NULL ,
        [e_id] [bigint] NOT NULL ,
        [e1_id] [bigint] NOT NULL ,
        [r_begin_time] [datetime]  ,
        [r_end_time] [datetime]  ,
        [r_interval] [int] ,
        [r_heart_rate] [int]
        CONSTRAINT [PK_Record] PRIMARY KEY CLUSTERED ([r_id] ASC )
);


-- 用户_展览（自增编号，用户编号，展览编号，状态（未报名，已报名，正在参加，已参加）,是否收藏，最后一次访问时间）

CREATE TABLE [dbo].[UE](
        [ue_id] [bigint] identity(1,1) ,
        [u_id] [bigint] NOT NULL ,
        [e_id] [bigint] NOT NULL ,
        [ue_status] [int] NOT NULL default '0' check (ue_status in ('0','1','2','3')),
        [ue_collection] [bit] default '0' check(ue_collection in ('0','1')),
        [ue_time] [datetime]
        CONSTRAINT [PK_UE] PRIMARY KEY CLUSTERED ([ue_id] ASC )
 );


-- 展览_标签（自增编号，展览编号，展览标签）

CREATE TABLE [dbo].[E_tag](
        [et_id] [bigint] identity(1,1) ,
        [e_id] [bigint] NOT NULL ,
        [e_tags] [varchar](20) NOT NULL,
        CONSTRAINT [PK_E_tag] PRIMARY KEY CLUSTERED ([et_id] ASC )
);