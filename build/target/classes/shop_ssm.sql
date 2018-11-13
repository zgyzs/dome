/*
Navicat MySQL Data Transfer

Source Server         : 本地mysql
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : shop_ssm

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2017-11-10 15:34:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL auto_increment,
  `cname` varchar(255) default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '男装');
INSERT INTO `category` VALUES ('2', '女装');

-- ----------------------------
-- Table structure for category_second
-- ----------------------------
DROP TABLE IF EXISTS `category_second`;
CREATE TABLE `category_second` (
  `csid` int(11) NOT NULL auto_increment,
  `csname` varchar(255) default NULL,
  `cid` int(11) default NULL,
  PRIMARY KEY  (`csid`),
  KEY `FK936FCAF27631B398` (`cid`),
  CONSTRAINT `fk_ddd` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_second
-- ----------------------------
INSERT INTO `category_second` VALUES ('1', '衣服', '1');
INSERT INTO `category_second` VALUES ('2', '裤子', '1');
INSERT INTO `category_second` VALUES ('3', '衣服', '2');
INSERT INTO `category_second` VALUES ('4', '裤子', '2');
INSERT INTO `category_second` VALUES ('5', '裙子', '2');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `oid` varchar(100) NOT NULL,
  `sum_price` double default NULL,
  `order_time` datetime default NULL,
  `state` varchar(11) default NULL COMMENT '订单状态【1）未付款 2）已付款 3）已发货 4）已确认收获。。。】',
  `name` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `addr` varchar(255) default NULL,
  `uid` int(11) default NULL,
  `logistics_comp` varchar(255) default NULL,
  `logistics_num` int(11) default NULL,
  PRIMARY KEY  (`oid`),
  KEY `FKC3DF62E52BA96944` (`uid`),
  CONSTRAINT `FKC3DF62E52BA96944` FOREIGN KEY (`uid`) REFERENCES `user_front` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('05bb6a9c4abe48f8be61756672043b80', '0.58', '2017-10-23 11:49:25', '已付款', '张先生', '118', '成都盐市口', '1', null, null);
INSERT INTO `order_info` VALUES ('0bbbc867d77f42d3854c2819c0f1f595', '0.28', '2017-10-22 19:53:27', '已付款', '张无忌', '110', '成都春熙路', '1', null, null);
INSERT INTO `order_info` VALUES ('18f33742ad424ad4b78e3b6af1f37fe0', '1.73', '2017-10-27 12:05:10', '未付款', '张无忌', '110', '成都春熙路', '1', null, null);
INSERT INTO `order_info` VALUES ('1ff78282f5374643b00e8fce95931a3d', '1.44', '2017-10-22 19:47:06', '已付款', '张无忌', '110', '成都春熙路', '1', null, null);
INSERT INTO `order_info` VALUES ('32ad01da9c644700a82e82d5753a1ecd', '0.66', '2017-10-22 20:06:47', '已付款', '张无忌', '110', '成都春熙路', '1', null, null);
INSERT INTO `order_info` VALUES ('364f30eabf1a47459bec1e3792c8efb2', '0.52', '2017-10-22 19:49:29', '已付款', '张无忌', '110', '成都春熙路', '1', null, null);
INSERT INTO `order_info` VALUES ('58d4dd33b1724f9eb295dd297c7b3962', '0.76', '2017-10-22 19:36:23', '已付款', '张无忌', '110', '成都春熙路', '1', null, null);
INSERT INTO `order_info` VALUES ('badd359838384b89b52355062d67a4ab', '0.34', '2017-10-23 15:12:22', '已付款', '曾先生', '114', '布鲁明顿', '2', null, null);
INSERT INTO `order_info` VALUES ('bbf7f56c253f4f2cac3e4783c6dcf0bb', '0.29', '2017-10-23 14:52:22', '未付款', '张无忌', '110', '成都春熙路', '1', null, null);
INSERT INTO `order_info` VALUES ('c25c8adbe4dd4e3085705b262c3fb427', '0.81', '2017-10-23 15:24:21', '已付款', '曾先生', '114', '布鲁明顿', '2', null, null);
INSERT INTO `order_info` VALUES ('c5375522d9ba444684065273b562a2c8', '0.86', '2017-10-27 12:05:37', '未付款', '张无忌', '110', '成都春熙路', '1', null, null);
INSERT INTO `order_info` VALUES ('cc85682c84124f6597d142b99a2db2ad', '0.58', '2017-10-23 11:29:27', '已付款', '张无忌', '110', '成都春熙路', '1', null, null);
INSERT INTO `order_info` VALUES ('dccacf5c872d46b290313343e48f5076', '0.58', '2017-10-23 11:36:35', '已付款', '曾先生', '114', '布鲁明顿', '2', null, null);

-- ----------------------------
-- Table structure for order_logistics_info
-- ----------------------------
DROP TABLE IF EXISTS `order_logistics_info`;
CREATE TABLE `order_logistics_info` (
  `id` int(11) NOT NULL,
  `order_id` varchar(100) default NULL,
  `date` datetime default NULL,
  `info` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_log_info_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_logistics_info
-- ----------------------------

-- ----------------------------
-- Table structure for order_product_comment_info
-- ----------------------------
DROP TABLE IF EXISTS `order_product_comment_info`;
CREATE TABLE `order_product_comment_info` (
  `id` int(11) NOT NULL auto_increment,
  `order_id` varchar(100) default NULL,
  `prduct_id` int(11) default NULL,
  `comment_type` char(2) default NULL COMMENT '好评，中评，差评',
  `comment_content` varchar(255) default NULL,
  `img1` varchar(255) default NULL,
  `img2` varchar(255) default NULL,
  `img3` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_product_comment_info
-- ----------------------------

-- ----------------------------
-- Table structure for order_product_info
-- ----------------------------
DROP TABLE IF EXISTS `order_product_info`;
CREATE TABLE `order_product_info` (
  `id` int(11) NOT NULL auto_increment,
  `oid` varchar(100) default NULL,
  `pid` int(11) default NULL,
  `count` int(11) default NULL,
  `buy_price` double(11,0) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKE8B2AB6140ACF87A` (`oid`),
  KEY `FKE8B2AB61EE85435B` (`pid`),
  CONSTRAINT `FKE8B2AB61EE85435B` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_product_info
-- ----------------------------
INSERT INTO `order_product_info` VALUES ('30', '58d4dd33b1724f9eb295dd297c7b3962', '1', '1', '188');
INSERT INTO `order_product_info` VALUES ('31', '58d4dd33b1724f9eb295dd297c7b3962', '46', '2', '288');
INSERT INTO `order_product_info` VALUES ('32', '1ff78282f5374643b00e8fce95931a3d', '54', '2', '288');
INSERT INTO `order_product_info` VALUES ('33', '1ff78282f5374643b00e8fce95931a3d', '47', '3', '288');
INSERT INTO `order_product_info` VALUES ('34', '364f30eabf1a47459bec1e3792c8efb2', '39', '1', '238');
INSERT INTO `order_product_info` VALUES ('35', '364f30eabf1a47459bec1e3792c8efb2', '47', '1', '288');
INSERT INTO `order_product_info` VALUES ('36', '0bbbc867d77f42d3854c2819c0f1f595', '47', '1', '288');
INSERT INTO `order_product_info` VALUES ('37', '32ad01da9c644700a82e82d5753a1ecd', '46', '1', '288');
INSERT INTO `order_product_info` VALUES ('38', '32ad01da9c644700a82e82d5753a1ecd', '1', '2', '188');
INSERT INTO `order_product_info` VALUES ('39', 'cc85682c84124f6597d142b99a2db2ad', '57', '1', '288');
INSERT INTO `order_product_info` VALUES ('40', 'cc85682c84124f6597d142b99a2db2ad', '49', '1', '288');
INSERT INTO `order_product_info` VALUES ('41', 'dccacf5c872d46b290313343e48f5076', '54', '1', '288');
INSERT INTO `order_product_info` VALUES ('42', 'dccacf5c872d46b290313343e48f5076', '57', '1', '288');
INSERT INTO `order_product_info` VALUES ('43', '05bb6a9c4abe48f8be61756672043b80', '49', '1', '288');
INSERT INTO `order_product_info` VALUES ('44', '05bb6a9c4abe48f8be61756672043b80', '55', '1', '288');
INSERT INTO `order_product_info` VALUES ('45', 'bbf7f56c253f4f2cac3e4783c6dcf0bb', '57', '1', '288');
INSERT INTO `order_product_info` VALUES ('46', 'badd359838384b89b52355062d67a4ab', '58', '1', '338');
INSERT INTO `order_product_info` VALUES ('47', 'c25c8adbe4dd4e3085705b262c3fb427', '58', '1', '338');
INSERT INTO `order_product_info` VALUES ('48', 'c25c8adbe4dd4e3085705b262c3fb427', '39', '2', '238');
INSERT INTO `order_product_info` VALUES ('49', '18f33742ad424ad4b78e3b6af1f37fe0', '54', '2', '288');
INSERT INTO `order_product_info` VALUES ('50', '18f33742ad424ad4b78e3b6af1f37fe0', '47', '4', '288');
INSERT INTO `order_product_info` VALUES ('51', 'c5375522d9ba444684065273b562a2c8', '61', '1', '288');
INSERT INTO `order_product_info` VALUES ('52', 'c5375522d9ba444684065273b562a2c8', '57', '2', '288');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL auto_increment,
  `pname` varchar(255) default NULL,
  `market_price` double default NULL,
  `shop_price` double default NULL,
  `image` varchar(255) default NULL,
  `pdesc` varchar(255) default NULL,
  `is_hot` int(11) default NULL,
  `pdate` datetime default NULL,
  `csid` int(11) default NULL,
  PRIMARY KEY  (`pid`),
  KEY `FKED8DCCEF3DBE112D` (`csid`),
  CONSTRAINT `FKED8DCCEF3DBE112D` FOREIGN KEY (`csid`) REFERENCES `category_second` (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '美特斯邦威男衣服11', '299', '188', 'nan_yifu_01.jpg', '原价299现价188咯', '1', '2017-09-26 13:02:13', '1');
INSERT INTO `product` VALUES ('38', '美特斯邦威男衣服8', '399', '238', 'nan_yifu_02.jpg', '老板媳妇儿跑咯，大减价咯，原价：399现价238', '0', '2017-09-27 15:07:56', '1');
INSERT INTO `product` VALUES ('39', '美特斯邦威男衣服811', '399', '238', 'nan_yifu_03.jpg', '老板媳妇儿跑咯，大减价咯，原价：399现价238', '0', '2017-09-26 15:07:57', '1');
INSERT INTO `product` VALUES ('40', '美特斯邦威男衣服5', '499', '288', 'nan_yifu_04.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:07:57', '1');
INSERT INTO `product` VALUES ('41', '美特斯邦威男衣服3', '399', '238', 'nan_yifu_05.jpg', '老板媳妇儿跑咯，大减价咯，原价：399现价238', '0', '2017-09-24 15:07:58', '1');
INSERT INTO `product` VALUES ('42', '美特斯邦威男裤子1', '499', '288', 'nan_kuzi_01.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:07:58', '2');
INSERT INTO `product` VALUES ('43', '美特斯邦威男裤子4', '499', '288', 'nan_kuzi_02.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:07:58', '2');
INSERT INTO `product` VALUES ('44', '美特斯邦威男裤子7', '599', '338', 'nan_kuzi_03.jpg', '老板媳妇儿跑咯，大减价咯，原价：599现价338', '0', '2017-09-24 15:07:58', '2');
INSERT INTO `product` VALUES ('45', '美特斯邦威男裤子6', '399', '238', 'nan_kuzi_04.jpg', '老板媳妇儿跑咯，大减价咯，原价：399现价238', '0', '2017-09-24 15:08:00', '2');
INSERT INTO `product` VALUES ('46', '美特斯邦威男裤子9', '499', '288', 'nan_kuzi_05.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:08:00', '2');
INSERT INTO `product` VALUES ('47', '美特斯邦威女衣服8', '499', '288', 'nv_yifu_01.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:08:00', '3');
INSERT INTO `product` VALUES ('48', '美特斯邦威女衣服3', '599', '338', 'nv_yifu_02.jpg', '老板媳妇儿跑咯，大减价咯，原价：599现价338', '0', '2017-09-24 15:08:00', '3');
INSERT INTO `product` VALUES ('49', '美特斯邦威女衣服1', '499', '288', 'nv_yifu_03.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:08:00', '3');
INSERT INTO `product` VALUES ('50', '美特斯邦威女衣服8', '599', '338', 'nv_yifu_04.jpg', '老板媳妇儿跑咯，大减价咯，原价：599现价338', '0', '2017-09-24 15:08:00', '3');
INSERT INTO `product` VALUES ('51', '美特斯邦威女衣服7', '599', '338', 'nv_yifu_05.jpg', '老板媳妇儿跑咯，大减价咯，原价：599现价338', '0', '2017-09-24 15:08:00', '3');
INSERT INTO `product` VALUES ('52', '美特斯邦威女裤子2', '699', '388', 'nv_kuzi_01.jpg', '老板媳妇儿跑咯，大减价咯，原价：699现价388', '1', '2017-09-24 15:08:00', '4');
INSERT INTO `product` VALUES ('53', '美特斯邦威女裤子8', '399', '238', 'nv_kuzi_02.jpg', '老板媳妇儿跑咯，大减价咯，原价：399现价238', '0', '2017-09-24 15:08:01', '4');
INSERT INTO `product` VALUES ('54', '美特斯邦威女裤子6', '499', '288', 'nv_kuzi_03.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:08:01', '4');
INSERT INTO `product` VALUES ('55', '美特斯邦威女裤子6', '499', '288', 'nv_kuzi_04.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:08:01', '4');
INSERT INTO `product` VALUES ('56', '美特斯邦威女裤子3', '599', '338', 'nv_kuzi_05.jpg', '老板媳妇儿跑咯，大减价咯，原价：599现价338', '0', '2017-09-24 15:08:01', '4');
INSERT INTO `product` VALUES ('57', '美特斯邦威女裙子5', '499', '288', 'nv_qunzi_01.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:08:01', '5');
INSERT INTO `product` VALUES ('58', '美特斯邦威女裙子8', '599', '338', 'nv_qunzi_02.jpg', '老板媳妇儿跑咯，大减价咯，原价：599现价338', '0', '2017-09-24 15:08:01', '5');
INSERT INTO `product` VALUES ('59', '美特斯邦威女裙子6', '599', '338', 'nv_qunzi_03.jpg', '老板媳妇儿跑咯，大减价咯，原价：599现价338', '0', '2017-09-24 15:08:01', '5');
INSERT INTO `product` VALUES ('60', '美特斯邦威女裙子8', '699', '388', 'nv_qunzi_04.jpg', '老板媳妇儿跑咯，大减价咯，原价：699现价388', '1', '2017-09-24 15:08:01', '5');
INSERT INTO `product` VALUES ('61', '美特斯邦威女裙子6', '499', '288', 'nv_qunzi_05.jpg', '老板媳妇儿跑咯，大减价咯，原价：499现价288', '1', '2017-09-24 15:08:01', '5');

-- ----------------------------
-- Table structure for product_imgs
-- ----------------------------
DROP TABLE IF EXISTS `product_imgs`;
CREATE TABLE `product_imgs` (
  `piid` int(11) NOT NULL auto_increment,
  `pid` int(11) NOT NULL,
  `image` varchar(255) default NULL,
  PRIMARY KEY  (`piid`),
  KEY `fk_product_imgs_pid` (`pid`),
  CONSTRAINT `fk_product_imgs_pid` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_imgs
-- ----------------------------
INSERT INTO `product_imgs` VALUES ('1', '1', 'nan_yifu_01_01.png');
INSERT INTO `product_imgs` VALUES ('2', '1', 'nan_yifu_01_02.png');
INSERT INTO `product_imgs` VALUES ('3', '1', 'nan_yifu_01_03.png');
INSERT INTO `product_imgs` VALUES ('4', '38', 'nan_yifu_02_01.png');
INSERT INTO `product_imgs` VALUES ('5', '38', 'nan_yifu_02_02.png');
INSERT INTO `product_imgs` VALUES ('6', '39', 'nan_yifu_03_01.png');
INSERT INTO `product_imgs` VALUES ('7', '39', 'nan_yifu_03_02.png');
INSERT INTO `product_imgs` VALUES ('8', '1', 'nan_yifu_01_04.png');

-- ----------------------------
-- Table structure for receive_user_info
-- ----------------------------
DROP TABLE IF EXISTS `receive_user_info`;
CREATE TABLE `receive_user_info` (
  `id` int(255) NOT NULL,
  `name` varchar(11) default NULL,
  `phone` int(11) default NULL,
  `addr` varchar(255) default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_rui_user_id` (`user_id`),
  CONSTRAINT `fk_rui_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_front` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of receive_user_info
-- ----------------------------
INSERT INTO `receive_user_info` VALUES ('1', '张无忌', '110', '成都春熙路', '1');
INSERT INTO `receive_user_info` VALUES ('2', '张先生', '118', '成都盐市口', '1');
INSERT INTO `receive_user_info` VALUES ('3', '张飞', '114', '成都布鲁明顿', '1');
INSERT INTO `receive_user_info` VALUES ('4', '曾先生', '114', '布鲁明顿', '2');
INSERT INTO `receive_user_info` VALUES ('5', '曾小贤', '115', '布鲁明顿广场404', '2');

-- ----------------------------
-- Table structure for user_back
-- ----------------------------
DROP TABLE IF EXISTS `user_back`;
CREATE TABLE `user_back` (
  `uid` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_back
-- ----------------------------
INSERT INTO `user_back` VALUES ('11', '客服a', 'aa', 'aa');
INSERT INTO `user_back` VALUES ('22', '客服b', 'bb', 'bb');
INSERT INTO `user_back` VALUES ('33', '客服c', 'cc', 'cc');
INSERT INTO `user_back` VALUES ('44', '客服d', 'dd', 'dd');
INSERT INTO `user_back` VALUES ('55', '客服e', 'ee', 'ee');

-- ----------------------------
-- Table structure for user_front
-- ----------------------------
DROP TABLE IF EXISTS `user_front`;
CREATE TABLE `user_front` (
  `uid` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `state` int(11) default NULL,
  `security_email` varchar(255) default NULL,
  `security_phone` varchar(255) default NULL,
  PRIMARY KEY  (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_front
-- ----------------------------
INSERT INTO `user_front` VALUES ('1', 'zhangsan', 'zhangsan', '张三', '1', '', null);
INSERT INTO `user_front` VALUES ('2', 'zengxiaoxian', 'zengxiaoxian', '曾小贤', '1', null, null);
INSERT INTO `user_front` VALUES ('3', 'liuyan', 'liuyan', '柳岩', null, null, null);
INSERT INTO `user_front` VALUES ('4', 'zhangfei', 'zhangfei', '张飞', null, null, null);
INSERT INTO `user_front` VALUES ('5', 'zhaozilong', 'zhaozilong', '赵子龙', null, null, null);
