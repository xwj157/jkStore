/*
Navicat MySQL Data Transfer

Source Server         : HelloMySQL
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : jk

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2020-10-10 15:06:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_jk
-- ----------------------------
DROP TABLE IF EXISTS `t_jk`;
CREATE TABLE `t_jk` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `price` decimal(11,2) NOT NULL,
  `author` varchar(20) NOT NULL,
  `sales` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `img_path` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_jk
-- ----------------------------
INSERT INTO `t_jk` VALUES ('1', '温柔一刀', '118.00', '竹内凉岛', '1000', '1000', '1.jpg');
INSERT INTO `t_jk` VALUES ('2', '咩嘢', '118.00', '神迹与月', '1000', '1000', '2.jpg');
INSERT INTO `t_jk` VALUES ('3', '城市之夜', '118.00', '初引Kaharu', '1000', '1000', '3.jpg');
INSERT INTO `t_jk` VALUES ('4', '大粉格子', '118.00', '芒果酸奶儿', '1000', '1000', '4.jpg');
INSERT INTO `t_jk` VALUES ('5', '葡萄汽水', '118.00', '芒果酸奶儿', '1000', '1000', '5.jpg');
INSERT INTO `t_jk` VALUES ('6', '雪松', '118.00', '睡不饱的夜寒zzz', '1000', '1000', '6.jpg');
INSERT INTO `t_jk` VALUES ('7', '森林来信', '118.00', '衔茶落岭隅', '1000', '1000', '7.jpg');
INSERT INTO `t_jk` VALUES ('8', '不秋草', '128.00', '橘子橘子它不甜吗', '1000', '1000', '8.jpg');
INSERT INTO `t_jk` VALUES ('9', '津本女子', '128.00', 'c只想天天睡懒觉', '1000', '1000', '9.jpg');
INSERT INTO `t_jk` VALUES ('10', '白雪', '108.00', '懒懒今天不太懒', '1000', '1000', '10.jpg');
INSERT INTO `t_jk` VALUES ('11', '热气球巡礼', '118.00', '神迹与月', '1000', '1000', '11.jpg');
INSERT INTO `t_jk` VALUES ('12', '绛', '128.00', '坐在宇宙唱歌', '1000', '1000', '12.jpg');
INSERT INTO `t_jk` VALUES ('13', '花都', '128.00', '岛羽十束', '1000', '1000', '13.jpg');
INSERT INTO `t_jk` VALUES ('14', '酒酿白云', '128.00', '是千总总', '1000', '1000', '14.jpg');
INSERT INTO `t_jk` VALUES ('15', '别日秋', '128.00', 'aranggg', '1000', '1000', '15.jpg');
INSERT INTO `t_jk` VALUES ('16', '金鱼姬', '118.00', '睡不饱的夜寒zzz', '1000', '1000', '16.jpg');
INSERT INTO `t_jk` VALUES ('17', '蜜间星', '118.00', '神迹与月', '1000', '1000', '17.jpg');
INSERT INTO `t_jk` VALUES ('18', '春日宴', '128.00', '快乐尖叫鸭', '1000', '1000', '18.jpg');
INSERT INTO `t_jk` VALUES ('19', '石墨烯', '105.00', '柠柠柠佳', '1000', '1000', '19.jpg');
INSERT INTO `t_jk` VALUES ('20', '栗栗生', '128.00', 'c只想天天睡懒觉', '1000', '1000', '20.jpg');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_price` decimal(11,2) DEFAULT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `permission` int(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'root', 'root', '', '0');
INSERT INTO `t_user` VALUES ('2', 'xwj157', '123456', null, '1');
INSERT INTO `t_user` VALUES ('3', 'zy157', '123456', '572242130@qq.com', '1');
