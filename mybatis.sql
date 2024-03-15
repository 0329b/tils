/*
 Navicat Premium Data Transfer

 Source Server         : hxb
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 15/03/2024 20:13:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '部门名称',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '学工部', '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `dept` VALUES (2, '教研部', '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `dept` VALUES (3, '咨询部', '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `dept` VALUES (4, '就业部', '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `dept` VALUES (14, '销售部', '2024-02-02 09:29:42', '2024-02-02 09:29:42');
INSERT INTO `dept` VALUES (15, '资源部', '2024-02-02 09:37:46', '2024-02-05 20:13:59');
INSERT INTO `dept` VALUES (17, '信息部', '2024-02-02 09:41:21', '2024-02-02 09:41:21');
INSERT INTO `dept` VALUES (18, '律师部', '2024-02-05 19:48:38', '2024-02-05 20:00:42');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123456' COMMENT '密码',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `gender` tinyint(0) UNSIGNED NOT NULL COMMENT '性别, 说明: 1 男, 2 女',
  `image` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图像',
  `job` tinyint(0) UNSIGNED NULL DEFAULT NULL COMMENT '职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师',
  `entrydate` date NULL DEFAULT NULL COMMENT '入职时间',
  `dept_id` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '部门ID',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (1, 'jinyong', '123456', '金庸', 1, '1.jpg', 4, '2000-01-01', 2, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (2, 'zhangwuji', '123456', '张无忌', 1, '2.jpg', 2, '2015-01-01', 2, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (3, 'yangxiao', '123456', '杨逍', 1, '3.jpg', 2, '2008-05-01', 2, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (4, 'weiyixiao', '123456', '韦一笑', 1, '4.jpg', 2, '2007-01-01', 2, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (5, 'changyuchun', '123456', '常遇春', 1, '5.jpg', 2, '2012-12-05', 2, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (6, 'xiaozhao', '123456', '小昭', 2, '6.jpg', 3, '2013-09-05', 1, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (7, 'jixiaofu', '123456', '纪晓芙', 2, '7.jpg', 1, '2005-08-01', 1, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (8, 'zhouzhiruo', '123456', '周芷若', 2, '8.jpg', 1, '2014-11-09', 1, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (9, 'dingminjun', '123456', '丁敏君', 2, '9.jpg', 1, '2011-03-11', 1, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (10, 'zhaomin', '123456', '赵敏', 2, '10.jpg', 1, '2013-09-05', 1, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (11, 'luzhangke', '123456', '鹿杖客', 1, '11.jpg', 5, '2007-02-01', 3, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (12, 'hebiweng', '123456', '鹤笔翁', 1, '12.jpg', 5, '2008-08-18', 3, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (13, 'fangdongbai', '123456', '方东白', 1, '13.jpg', 5, '2012-11-01', 3, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (14, 'zhangsanfeng', '123456', '张三丰', 1, '14.jpg', 2, '2002-08-01', 2, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (15, 'yulianzhou', '123456', '俞莲舟', 1, '15.jpg', 2, '2011-05-01', 2, '2024-02-01 15:01:15', '2024-02-01 15:01:15');
INSERT INTO `emp` VALUES (21, 'jxiscad', '123456', '信息', 1, 'https://web-tilasw.oss-cn-hangzhou.aliyuncs.com/91d340d7-01e4-41c5-b8a7-7144b6ac9a66.jpg', 2, '2024-02-10', 1, '2024-02-10 20:08:10', '2024-02-17 11:34:32');
INSERT INTO `emp` VALUES (22, 'ss', '123456', '嘻嘻', 2, 'https://web-tilasw.oss-cn-hangzhou.aliyuncs.com/d8100f91-b875-4bbc-8f7e-66a0c759623d.jpg', 3, '2024-02-11', 4, '2024-02-10 20:29:35', '2024-02-16 20:31:04');

-- ----------------------------
-- Table structure for operate_log
-- ----------------------------
DROP TABLE IF EXISTS `operate_log`;
CREATE TABLE `operate_log`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `operate_user` int(0) UNSIGNED NULL DEFAULT NULL COMMENT '操作人ID',
  `operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作的类名',
  `method_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作的方法名',
  `method_params` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '方法参数',
  `return_value` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '返回值',
  `cost_time` bigint(0) NULL DEFAULT NULL COMMENT '方法执行耗时，单位:mscomment',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of operate_log
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
