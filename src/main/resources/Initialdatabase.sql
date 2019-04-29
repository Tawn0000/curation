
Use curation;

#插入管理员
INSERT INTO `curation`.`Admin` (`open_id`, `a_password`, `a_name`, `a_level`) VALUES ('lingxiao', '123456', '凌晓', 0);
INSERT INTO `curation`.`Admin` (`open_id`, `a_password`, `a_name`, `a_level`) VALUES ('xianghuan', '123456', '向欢', 0);

#插入评论
INSERT INTO `curation`.`Comment` (`u_id`, `e_id`, `c_grade`, `c_date`, `c_content`, `c_image`) VALUES (1, 1, 5, '2019-04-28 06:40:39', 'very good', '2.jpg');

#插入标签
INSERT INTO `curation`.`E_tag` (`e_id`, `e_tags`) VALUES (2, '文艺');
INSERT INTO `curation`.`E_tag` (`e_id`, `e_tags`) VALUES (1, '文艺');

#插入展品
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '青花瓷', '张宇', '2019-04-16', '1.jpg', '精美');
INSERT INTO `curation`.`Exhibit` (`e_id`, `e1_name`, `e1_author`, `e1_date`, `e1_image`, `e1_description`) VALUES (1, '陶瓷', '张宇', '2019-04-16', '1.jpg', '精美');

#插入展览
INSERT INTO `curation`.`Exhibition` (`e_name`, `e_address`, `e_begin_date`,`e_end_date`, `e_price`, `e_description`, `e_image`, `e_video`, `e_person_in_charge`) VALUES ('张宇画展', '江苏省无锡市江南大学桃园', '2020-07-01 13:00:26','2020-07-01 13:00:26', 50, '张宇的个人画展', '1.jpg', '1.mp4', '张宇');

#插入反馈
INSERT INTO `curation`.`Feedback` (`u_id`, `f_content`, `f_image`, `f_phone_number`, `f_time`) VALUES (1, '非常好！ I like it', '1.jpg', '131555555', '2019-04-24 19:54:03');

#插入Ibeacon
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_major`, `i_minor`, `i_measured_power`, `i_status`, `i_connect_e1_id`, `i_wide`) VALUES ('fafag66', '222', '333', '23', 1, 1, 0.5);
INSERT INTO `curation`.`Ibeacon` (`i_uid`, `i_major`, `i_minor`, `i_measured_power`, `i_status`, `i_connect_e1_id`, `i_wide`) VALUES ('fafagffff66', '222', '333', '23', 1, 2, 0.5);

#插入记录
INSERT INTO `curation`.`Record` (`u_id`, `e_id`, `e1_id`, `r_begin_time`, `r_end_time`, `r_interval`) VALUES (1, 1, 1, '2019-04-28 07:19:00', '2019-04-28 07:19:03', 3);
INSERT INTO `curation`.`Record` (`u_id`, `e_id`, `e1_id`, `r_begin_time`, `r_end_time`, `r_interval`) VALUES (1, 1, 2, '2019-04-28 07:19:00', '2019-04-28 07:19:06', 6);

#插入UE表记录
INSERT INTO `curation`.`UE` (`u_id`, `e_id`, `ue_status`, `ue_collection`, `ue_time`, `ue_heart_rate_min`, `ue_heart_rate_max`, `ue_heart_rate_ave`,`ue_heart_times`) VALUES (1, 1, 1, 1, '2019-04-28 07:20:53', 60, 120, 80);
INSERT INTO `curation`.`UE` (`u_id`, `e_id`, `ue_status`, `ue_collection`, `ue_time`, `ue_heart_rate_min`, `ue_heart_rate_max`, `ue_heart_rate_ave`,`ue_heart_times`) VALUES (2, 1, 3, 0, '2019-04-28 07:20:53', 70, 120, 80);

#插入用户表记录
INSERT INTO `curation`.`User` (`open_id`, `u_name`, `u_sex`, `u_icon`, `u_query_status`, `u_tag`) VALUES ('ozHxH40cveh9WUlY3HdqkrpwM_uc', '向欢', '女', null, null, null);