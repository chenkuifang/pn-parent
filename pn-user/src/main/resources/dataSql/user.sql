﻿
SET FOREIGN_KEY_CHECKS=0;

-- --------------创建数据库------------------------
DROP DATABASE IF EXISTS db_user;
CREATE DATABASE db_user;

USE db_user;

-- ----------------------------
-- Table structure for pn_user
-- ----------------------------
DROP TABLE IF EXISTS `pn_user`;
CREATE TABLE `pn_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL COMMENT '登陆用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '登陆密码',
  `department_id` bigint(20) DEFAULT NULL COMMENT '所属部门',
  `role_id` bigint(20) DEFAULT NULL COMMENT '用户所属角色id',
  `user_nike` varchar(20) DEFAULT NULL COMMENT '昵称',
  `email` varchar(20) DEFAULT NULL COMMENT '电子邮件',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `sex` varchar(2) DEFAULT '1' COMMENT '性别',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int DEFAULT 1 COMMENT '状态 1 正常, 0 停用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 增加默认用户
INSERT INTO `pn_user` VALUES (10001, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, 10001, '管理员', '123555', '123456789', '1', 10001, '2017-12-4 15:12:06', '2017-12-4 15:12:09', 1);
INSERT INTO `pn_user` VALUES (10002, 'quifar', 'e10adc3949ba59abbe56e057f20f883e', 10001, 10001, 'quifar', '314', '158', '1', 10001, '2017-12-4 15:12:48', '2017-12-4 15:12:48', 1);

