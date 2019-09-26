/*
 Navicat Premium Data Transfer

 Source Server         : my
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : my

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 26/09/2019 23:22:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键ID',
  `book_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '书籍编号',
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '数据名称',
  `book_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '作者',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `book_user`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '111', 'hello world', 'grj', '1');
INSERT INTO `book` VALUES ('2', '222', '哈哈哈', '杨瑞', '2');
INSERT INTO `book` VALUES ('5', '1111', '11', '1', '1');
INSERT INTO `book` VALUES ('7', '1024', '书籍名称', '作者', '1');
INSERT INTO `book` VALUES ('8', '1025', '书籍名称', '作者', '1');
INSERT INTO `book` VALUES ('9', '1026', '书籍名称11', '作者1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'neo', 66, 'smile1@ityouknow.com');
INSERT INTO `user` VALUES ('1174880611830087681', '随机用户名49', 55, NULL);
INSERT INTO `user` VALUES ('1174880612094328833', '随机用户名8', 55, NULL);
INSERT INTO `user` VALUES ('1174893403958202369', '随机用户名77', 30, NULL);
INSERT INTO `user` VALUES ('1174893404289552386', '随机用户名97', 90, NULL);
INSERT INTO `user` VALUES ('1174893643700449282', '随机用户名64', 67, NULL);
INSERT INTO `user` VALUES ('1174893643964690434', '随机用户名62', 82, NULL);
INSERT INTO `user` VALUES ('2', 'keep', 36, 'smile2@ityouknow.com');
INSERT INTO `user` VALUES ('3', 'pure', 28, 'smile3@ityouknow.com');
INSERT INTO `user` VALUES ('4', 'smile', 21, 'smile4@ityouknow.com');
INSERT INTO `user` VALUES ('5', 'it', 24, 'smile5@ityouknow.com');

SET FOREIGN_KEY_CHECKS = 1;
