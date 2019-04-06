
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
        [U_id] [bigint] identity(1,1) ,
        [Wc_id] [varchar](20) NOT NULL ,
        [U_name] [varchar](32)  ,
        [U_sex] [varchar](3)  default '男' check (U_sex in ('男','女')),
        [U_icon] [varchar](300) ,
        [U_bluetooth_status] [varchar](3)  default '关' check (U_bluetooth_status in ('开','关')),
        [U_query_status] [varchar](3) default '否' check (U_query_status in ('是','否')),
        [U_tag] [varchar](50) ,
        CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED ([U_id] ASC )
        );

-- 管理员 (自增管理员编号，微信号，密码，姓名，管理权限级别)

CREATE TABLE [dbo].[Admin](
        [A_id] [int] identity(1,1)  ,
        [Wc_id] [varchar](20) NOT NULL ,
        [A_password] [varchar](32) NOT NULL ,
        [A_name] [varchar](20) NOT NULL ,
        [A_level] [int] default '1' check(A_level in ('0','1')) NOT NULL,
        CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED ([A_id] ASC )
                    );

-- 展览（自增展览编号，名称，地点，时间，展览描述，图片,视频，负责人）

CREATE TABLE [dbo].[Exhibition](
        [E_id] [bigint] identity(1,1) ,
        [E_name] [varchar](100) NOT NULL ,
        [E_address] [varchar](100) NOT NULL ,
        [E_date] [datetime] NOT NULL ,
        [E_description] text NOT NULL,
        [E_image] varchar(300) NOT NULL,
        [E_video] varchar(300) default 'NULL',
        [E_person_in_charge] varchar(20) NOT NULL,
        CONSTRAINT [PK_Exhibition] PRIMARY KEY CLUSTERED ([E_id] ASC )
);

-- 展品 (自增展品编号，展品名称，作者，年代，图片，内容介绍)

CREATE TABLE [dbo].[Exhibit](
        [E1_id] [bigint] identity(1,1) ,
        [E1_name] [varchar](100) NOT NULL ,
        [E1_author] [varchar](20) NOT NULL ,
        [E1_date] [date] NOT NULL ,
        [E1_image] varchar(300) NOT NULL,
        [E1_description] text NOT NULL,
        CONSTRAINT [PK_Exhibit] PRIMARY KEY CLUSTERED ([E1_id] ASC )
);

-- 评论 (自增评论编号，用户编号，展览编号，展品编号，评论时间，评论文字内容，评论图片)

CREATE TABLE [dbo].[Comment](
         [C_id] [bigint] identity(1,1) ,
         [U_id] [bigint] NOT NULL ,
         [E_id] [bigint] NOT NULL ,
         [E1_id] [bigint] ,
         [E_date] [datetime] NOT NULL ,
         [C_content] text NOT NULL,
         [C_image] varchar(300) NOT NULL,
         CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED ([C_id] ASC )
);

-- 用户反馈（自增编号，用户编号，反馈内容,图片）

CREATE TABLE [dbo].[Feedback](
         [F_id] [bigint] identity(1,1) ,
         [U_id] [bigint] NOT NULL ,
         [F_content] text NOT NULL,
         [F_image] varchar(300),
         CONSTRAINT [PK_Feedback] PRIMARY KEY CLUSTERED ([F_id] ASC )
);

-- 蓝牙Ibeacon(自增蓝牙编号，UUID, Marjor ,Minor, Measured_Power, Status, Connect_E1_id, Wide)

CREATE TABLE [dbo].[Ibeacon](
         [I_ID] [int] identity(1,1) ,
         [UID] [varchar](50) NOT NULL ,
         [Major] [varchar](50) NOT NULL,
         [Minor] [varchar](50) NOT NULL,
         [Measured_Power] [varchar](50) NOT NULL,
         [status] int default '0' check (status in ('0','1')) NOT NULL,
         [Connect_E1_id]  [bigint],
         [Wide] [float] default  '1'
          CONSTRAINT [PK_Ibeacon] PRIMARY KEY CLUSTERED ([I_id] ASC )
);

-- 用户观展记录（自增编号，用户编号 , 展览编号, 展品编号，开始时间，结束时间，停留时长，心率）

CREATE TABLE [dbo].[Record](
        [R_id] [int] identity(1,1),
        [U_id] [bigint] NOT NULL ,
        [E_id] [bigint] NOT NULL ,
        [E1_id] [bigint] NOT NULL ,
        [R_begin_time] [datetime] NOT NULL ,
        [R_end_time] [datetime] NOT NULL ,
        [R_interval] [int] NOT NULL,
        [R_heart_rate] [int]
        CONSTRAINT [PK_Record] PRIMARY KEY CLUSTERED ([R_id] ASC )
);


-- 用户_展览（自增编号，用户编号，展览编号，状态（未报名，已报名，正在参加，已参加））

CREATE TABLE [dbo].[UE](
        [UR_id] [bigint] identity(1,1) ,
        [U_id] [bigint] NOT NULL ,
        [E_id] [bigint] NOT NULL ,
        [UR_status] [int] NOT NULL default '0' check (UR_status in ('0','1','2','3'))
        CONSTRAINT [PK_UE] PRIMARY KEY CLUSTERED ([UR_id] ASC )
 );

-- 展览_展品 (展览编号，展品编号)

CREATE TABLE [dbo].[EE]
(
    [U_id] [bigint] NOT NULL,
    [E_id] [bigint] NOT NULL,
    CONSTRAINT [PK_EE] PRIMARY KEY CLUSTERED ([U_id], [E_id] ASC)
);

-- 展览_标签（自增编号，展览编号，展览标签）

CREATE TABLE [dbo].[E_tag](
        [T_id] [bigint] NOT NULL ,
        [E_id] [bigint] NOT NULL ,
        [T_tags] [varchar](20) NOT NULL,
        CONSTRAINT [PK_E_tag] PRIMARY KEY CLUSTERED ([T_id] ASC )
);