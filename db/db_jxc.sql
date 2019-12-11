/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : db_jxc

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-30 16:21:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` varchar(10) NOT NULL,
  `khname` varchar(30) NOT NULL,
  `Contacts` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `Telephone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('c1', '嘉禾纺织公司', '李树生', '北京市学院路44号', '18523654789');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '职工号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(5) NOT NULL COMMENT '性别',
  `birthDate` date NOT NULL COMMENT '出生年月',
  `job` varchar(10) NOT NULL COMMENT '职务',
  `salary` double(10,0) NOT NULL COMMENT '薪资',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('0000000001', '李树生', '男', '1978-09-12', '经理', '8800');
INSERT INTO `employee` VALUES ('0000000002', '沈丽萍', '女', '1980-10-18', '销售员', '4500');

-- ----------------------------
-- Table structure for `shangpin`
-- ----------------------------
DROP TABLE IF EXISTS `shangpin`;
CREATE TABLE `shangpin` (
  `spId` varchar(10) NOT NULL,
  `spName` varchar(20) NOT NULL,
  `colour` varchar(10) NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  `guiGe` varchar(10) NOT NULL,
  `number` int(10) NOT NULL DEFAULT '0',
  `maxNumber` int(10) NOT NULL,
  `minNumber` int(10) NOT NULL,
  `price` float(10,0) DEFAULT NULL,
  PRIMARY KEY (`spId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shangpin
-- ----------------------------
INSERT INTO `shangpin` VALUES ('p1', '花布', '砖红', '玫瑰', '245', '0', '100', '0', '18');
INSERT INTO `shangpin` VALUES ('p2', '花布', '砖红', '玫瑰', '245', '0', '100', '0', '18');

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` varchar(10) NOT NULL,
  `cxname` varchar(20) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('s1', '康佳纺织品有限公司', '侯淑敏', '江苏南通纺织城76号');
INSERT INTO `supplier` VALUES ('s2', '奥迪卡纺织公司', '康书明', '天津市滨海新区光明路6号');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123');
