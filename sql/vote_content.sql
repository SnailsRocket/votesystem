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

 Date: 24/02/2022 14:15:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vote_content
-- ----------------------------
DROP TABLE IF EXISTS `vote_content`;
CREATE TABLE `vote_content`  (
  `id` int(8) NOT NULL,
  `content` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '投票主题',
  `expired_status` int(8) NULL DEFAULT NULL COMMENT '过期状态',
  `expired_time` timestamp(0) NULL DEFAULT NULL COMMENT '过期时间  不设置 默认 24小时',
  `del_status` int(8) NULL DEFAULT NULL COMMENT '删除状态',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` int(8) NULL DEFAULT NULL COMMENT '创建人id',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` int(8) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '投票表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
