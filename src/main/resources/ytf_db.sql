/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ytf_db

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-08-01 17:52:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tmessage
-- ----------------------------
DROP TABLE IF EXISTS `tmessage`;
CREATE TABLE `tmessage` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL COMMENT '姓名',
  `PHONE` varchar(255) NOT NULL COMMENT '电话',
  `EMAIL` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `CONTENT` text COMMENT '留言内容',
  `HAS_READ` int(11) DEFAULT '0' COMMENT '是否已读 0:未读 1:已读',
  `LEAVE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '留言时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='留言表';

-- ----------------------------
-- Records of tmessage
-- ----------------------------
INSERT INTO `tmessage` VALUES ('1', '大表哥', '13629421675', null, '啊啊啊', '0', '2016-07-20 17:27:32');
INSERT INTO `tmessage` VALUES ('2', '小表妹', '110', null, '嘿嘿嘿', '0', '2016-07-21 17:27:59');
INSERT INTO `tmessage` VALUES ('3', '杨过', '120', null, '我勒个去', '0', '2016-07-22 17:28:12');
INSERT INTO `tmessage` VALUES ('4', '郭靖', '119', null, '恩黑', '0', '2016-07-23 17:28:25');
INSERT INTO `tmessage` VALUES ('5', '黄蓉', '114', null, '哼哼哈嘿', '0', '2016-07-24 17:28:37');
INSERT INTO `tmessage` VALUES ('6', '张三丰', '456789', null, '依依以', '0', '2016-07-25 17:28:54');
INSERT INTO `tmessage` VALUES ('7', '张无忌', '789', null, '不给力', '0', '2016-07-26 17:29:03');
INSERT INTO `tmessage` VALUES ('8', '韦小宝', '110', null, '吃了吗', '0', '2016-07-28 17:29:32');

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN_NAME` varchar(255) DEFAULT NULL,
  `LOGIN_PASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `TUSER_LOGIN_NAME_uindex` (`LOGIN_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('1', 'longder', '1234');
