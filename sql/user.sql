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

 Date: 24/02/2022 14:14:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '昵称',
  `tel` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL COMMENT '手机号',
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '头像',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '地址',
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '用户标签',
  `del_status` int(8) NULL DEFAULT NULL COMMENT '删除状态 0 未删  1 删除',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
