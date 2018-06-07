
SET FOREIGN_KEY_CHECKS=0;

-- --------------创建数据库------------------------
DROP DATABASE IF EXISTS db_goods;
CREATE DATABASE db_goods;

USE db_goods;

-- ----------------------------
-- Table structure for db_goods
-- ----------------------------
DROP TABLE IF EXISTS `pn_goods`;
CREATE TABLE `pn_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` int(10) DEFAULT NULL COMMENT '品牌Id',
  `goods_num` varchar(40) DEFAULT NULL COMMENT '商品编码',
  `goods_name` varchar(80) DEFAULT NULL COMMENT '商品名称',
  `sale_price` decimal(20,4) DEFAULT '0.0000' COMMENT '销售价格',
  `discount_price` decimal(20,4) DEFAULT '0.0000' COMMENT '折后价格',
  `stock` bigint(20) DEFAULT '0' COMMENT '库存',
  `sale_count` bigint(20) DEFAULT '0' COMMENT '销量',
  `status` SMALLINT(2) DEFAULT '1' COMMENT '状态  1:正常, 0:下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- 增加默认数据
INSERT INTO `pn_goods` VALUES (10001, 10001,'10001', '苹果X', 100, 1000, 10, 10, 1);

-- -----------------品牌信息表--------------------
DROP TABLE IF EXISTS `pn_brand`;
CREATE TABLE `pn_brand` (
  `brand_id` int(10) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(40) DEFAULT NULL COMMENT '品牌名称',
  `create_time` datetime COMMENT '创建时间',
  `update_time` datetime COMMENT '最近修改时间',
  `status` SMALLINT(2) DEFAULT '1' COMMENT '状态  1:使用中, 0:暂停使用',
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='商品品牌信息表';

INSERT INTO pn_brand VALUES (10001,'苹果','2018-03-28 09:52:34','2018-03-28 09:52:34',1);

-- -----------------------------------------------
-- 商品库存平衡表
-- -----------------------------------------------
DROP TABLE IF EXISTS `pn_goods_store_balance`;
CREATE TABLE `pn_goods_store_balance` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goods_id` bigint(20)  NOT NULL COMMENT '商品编码',
  `in_count` bigint(20) COMMENT '进库数量',
  `out_count` bigint(20) COMMENT '出库数量',
  `create_time` datetime COMMENT '创建时间',
  `create_user` bigint(20) COMMENT '创建用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='商品库存平衡表';
