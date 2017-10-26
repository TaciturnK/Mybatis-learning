/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2017-10-26 19:49:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(20) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `fk_teacher_id` (`teacher_id`),
  CONSTRAINT `fk_teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', 'bj_a', '1');
INSERT INTO `class` VALUES ('2', 'bj_b', '2');

-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO `c_user` VALUES ('1', 'Tom', '12');
INSERT INTO `c_user` VALUES ('2', 'user', '23');

-- ----------------------------
-- Table structure for d_user
-- ----------------------------
DROP TABLE IF EXISTS `d_user`;
CREATE TABLE `d_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of d_user
-- ----------------------------
INSERT INTO `d_user` VALUES ('1', 'Tom', '12');
INSERT INTO `d_user` VALUES ('2', 'Bob', '13');
INSERT INTO `d_user` VALUES ('3', 'Jack', '18');

-- ----------------------------
-- Table structure for g_users
-- ----------------------------
DROP TABLE IF EXISTS `g_users`;
CREATE TABLE `g_users` (
  `id` varchar(32) NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of g_users
-- ----------------------------
INSERT INTO `g_users` VALUES ('212321313jkljlkk', '李四', '12');
INSERT INTO `g_users` VALUES ('21448884ba3211e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('3dbc0340ba2b11e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('5ac01b62ba2c11e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('69c68741b7e811e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('74441337ba2b11e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('825c98a5b7e811e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('8a192d3fba2b11e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('b8feaccbb7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('be006a40b89e11e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('c52e84eeb7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('c68b505ab7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('c79bd8f8b7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('c9306d97b7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('c98859b7b7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('ca6f30acb7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('caab15ceb7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('caafe1d5b7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('cb016baeb7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('cc551b9eb7e511e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('e31d0e05ba2b11e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('f1d507acb7e811e7853de0db55d6116a', '王五', '24');
INSERT INTO `g_users` VALUES ('fb25821eba2b11e7853de0db55d6116a', '王五', '24');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(20) DEFAULT NULL,
  `order_price` float DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'aaaa', '23');
INSERT INTO `orders` VALUES ('2', 'bbbb', '33');
INSERT INTO `orders` VALUES ('3', 'cccc', '22');

-- ----------------------------
-- Table structure for p_user
-- ----------------------------
DROP TABLE IF EXISTS `p_user`;
CREATE TABLE `p_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of p_user
-- ----------------------------
INSERT INTO `p_user` VALUES ('1', 'A', '男');
INSERT INTO `p_user` VALUES ('2', 'B', '女');
INSERT INTO `p_user` VALUES ('3', 'C', '男');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(20) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'xs_A', '1');
INSERT INTO `student` VALUES ('2', 'xs_B', '1');
INSERT INTO `student` VALUES ('3', 'xs_C', '1');
INSERT INTO `student` VALUES ('4', 'xs_D', '2');
INSERT INTO `student` VALUES ('5', 'xs_E', '2');
INSERT INTO `student` VALUES ('6', 'xs_F', '2');

-- ----------------------------
-- Table structure for s_user
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_salary` double DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('1', 'tom', '2017-10-26', '3000');
INSERT INTO `s_user` VALUES ('2', 'tom', '2017-10-26', '3000');
INSERT INTO `s_user` VALUES ('3', 'tom', '2017-10-26', '3000');
INSERT INTO `s_user` VALUES ('4', 'tom', '2017-10-26', '3000');
INSERT INTO `s_user` VALUES ('5', 'tom', '2017-10-26', '3000');
INSERT INTO `s_user` VALUES ('6', 'tom', '2017-10-26', '3000');
INSERT INTO `s_user` VALUES ('7', 'tom', '2017-10-26', '3000');
INSERT INTO `s_user` VALUES ('8', 'tom', '2017-10-26', '3000');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'LS1');
INSERT INTO `teacher` VALUES ('2', 'LS2');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'Tom', '12');
INSERT INTO `users` VALUES ('2', '诸葛小坏', '88');
INSERT INTO `users` VALUES ('4', '李四', '24');
INSERT INTO `users` VALUES ('6', '1231312', '24');
INSERT INTO `users` VALUES ('7', '1231312', '24');
INSERT INTO `users` VALUES ('8', '1231312', '24');
INSERT INTO `users` VALUES ('9', '1231312', '24');
INSERT INTO `users` VALUES ('10', '1231312', '24');
INSERT INTO `users` VALUES ('11', '1231312', '24');
INSERT INTO `users` VALUES ('12', '1231312', '24');
INSERT INTO `users` VALUES ('13', '1231312', '24');
INSERT INTO `users` VALUES ('14', '王五', '24');
INSERT INTO `users` VALUES ('15', '王五', '24');
INSERT INTO `users` VALUES ('16', '王五', '24');
INSERT INTO `users` VALUES ('17', '王五', '24');
INSERT INTO `users` VALUES ('18', '王五', '24');
INSERT INTO `users` VALUES ('19', '王五', '24');
INSERT INTO `users` VALUES ('20', '王五', '24');
INSERT INTO `users` VALUES ('21', '王五', '24');
INSERT INTO `users` VALUES ('22', '王五', '24');
INSERT INTO `users` VALUES ('23', '王五', '24');
INSERT INTO `users` VALUES ('24', '王五', '24');
INSERT INTO `users` VALUES ('25', '王五', '24');
INSERT INTO `users` VALUES ('26', '王五', '24');
INSERT INTO `users` VALUES ('27', '王五', '24');
INSERT INTO `users` VALUES ('28', '王五', '24');
INSERT INTO `users` VALUES ('29', '王五', '24');
INSERT INTO `users` VALUES ('30', '王五', '24');
INSERT INTO `users` VALUES ('31', '王五', '24');
INSERT INTO `users` VALUES ('32', '王五', '24');
INSERT INTO `users` VALUES ('33', '王五', '24');
INSERT INTO `users` VALUES ('34', '王五', '24');
INSERT INTO `users` VALUES ('35', '王五', '24');
INSERT INTO `users` VALUES ('36', '王五', '24');
INSERT INTO `users` VALUES ('37', '王五', '24');

-- ----------------------------
-- Procedure structure for ges_user_count
-- ----------------------------
DROP PROCEDURE IF EXISTS `ges_user_count`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `ges_user_count`(IN sex_id INT, OUT user_count INT)
BEGIN  
IF sex_id=0 THEN
SELECT COUNT(*) FROM mybatis.p_user WHERE p_user.sex='女' INTO user_count;
ELSE
SELECT COUNT(*) FROM mybatis.p_user WHERE p_user.sex='男' INTO user_count;
END IF;
END
;;
DELIMITER ;
