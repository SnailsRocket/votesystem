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

 Date: 24/02/2022 14:15:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for vote_content_options
-- ----------------------------
DROP TABLE IF EXISTS `vote_content_options`;
CREATE TABLE `vote_content_options`  (
  `id` int(8) NOT NULL,
  `vote_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '投票内容',
  `vote_id` int(8) NULL DEFAULT NULL COMMENT '投票表Id',
  `del_status` int(8) NULL DEFAULT NULL COMMENT '删除状态',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` int(8) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` timestamp(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` int(8) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci COMMENT = '投票选项表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
