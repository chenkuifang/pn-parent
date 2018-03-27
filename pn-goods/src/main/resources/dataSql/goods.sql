
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
  `goods_num` varchar(40) DEFAULT NULL COMMENT '商品编码',
  `goods_name` varchar(80) DEFAULT NULL COMMENT '商品名称',
  `sale_price` decimal(20,4) DEFAULT '0.0000' COMMENT '销售价格',
  `discount_price` decimal(20,4) DEFAULT '0.0000' COMMENT '折后价格',
  `stock` bigint(20) DEFAULT '0' COMMENT '库存',
  `sale_count` bigint(20) DEFAULT '0' COMMENT '销量',
  `status` int(11) DEFAULT '1' COMMENT '状态  1:正常, 0:下架',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10011 DEFAULT CHARSET=utf8 COMMENT='商品信息表';


-- 增加默认数据
INSERT INTO `pn_goods` VALUES (10001, '10001', '苹果X', 100, 1000, 10, 10, 1);

