
SET FOREIGN_KEY_CHECKS=0;

-- --------------创建数据库------------------------
DROP DATABASE IF EXISTS db_order;
CREATE DATABASE db_order;

USE db_order;

-- ----------------------------
-- Table structure for db_order
-- ----------------------------
-- 订单信息表 --
DROP TABLE IF EXISTS `pn_order`;
CREATE TABLE `pn_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编码',
  `order_sid` varchar(40) NOT NULL COMMENT '订单号',

  `pay_sid` varchar(40) NOT NULL COMMENT '支付单号(交易号)',
  `pay_way` tinyint(4) DEFAULT NULL COMMENT '付款方式 0 未知, 1 微信支付, 2,支付宝, 3 网银支付',
  `pay_time` datetime DEFAULT NULL COMMENT '订单支付时间',

  `goods_num` varchar(40) DEFAULT NULL COMMENT '商品编码',
  `goods_name` varchar(80) DEFAULT NULL COMMENT '商品名称',
  `price` decimal(20,2) DEFAULT '0.0000' COMMENT '拍下价格',
  `pay_price` decimal(20,2) DEFAULT '0.0000' COMMENT '支付价格',
  `amount` bigint(20) DEFAULT '0' COMMENT '商品数量',
  `buyer_name` varchar(80) DEFAULT NULL COMMENT '收货人',
  `buyer_address` varchar(80) DEFAULT NULL COMMENT '收货地址',
  `buyer_phone` varchar(80) DEFAULT NULL COMMENT '手机',
  `create_id` bigint(20) DEFAULT NULL COMMENT '订单创建账号ID',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '订单最后修改时间',
  `status` int(11) DEFAULT '0' COMMENT '订单状态 0:未付款，1：已付款，2：已发货，3：已完成，4：取消订单，5：支付失败',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单信息表';

