/*
 Navicat Premium Data Transfer

 Source Server         : localDB
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : vote

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 24/02/2022 14:15:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for option_user
-- ----------------------------
DROP TABLE IF EXISTS `option_user`;
CREATE TABLE `option_user`  (
  `option_id` int(8) NOT NULL COMMENT '投票选项id',
  `user_id` int(8) NOT NULL COMMENT '用户id',
  `del_status` int(8) NULL DEFAULT NULL COMMENT '删除状态',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`option_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '用户投票选项表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
