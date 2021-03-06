/*
 Source Server Type    : MySQL
 Source Schema         : lionboot
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名字',
  `account_name` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账户名字',
  `password` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `backup` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `record_state` tinyint(1) DEFAULT 0 COMMENT '启用状态 0 :启用 1 停用',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电子邮件',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`account_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_account
-- ----------------------------
INSERT INTO `sys_account` VALUES (1, '管理员', 'admin', 'admin', NULL, 0, 0, NULL, '2020-03-11 13:30:29', '2020-03-11 13:30:29');

-- ----------------------------
-- Table structure for sys_account_relation_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_relation_organization`;
CREATE TABLE `sys_account_relation_organization`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` bigint(12) NOT NULL COMMENT '账号主键',
  `organization_id` bigint(12) NOT NULL COMMENT '角色主键',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 :删除',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户与组织机构关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_account_relation_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_relation_role`;
CREATE TABLE `sys_account_relation_role`  (
  `account_id` bigint(12) NOT NULL COMMENT '账号主键',
  `role_id` bigint(12) NOT NULL COMMENT '角色主键',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户与角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_account_relation_role
-- ----------------------------
INSERT INTO `sys_account_relation_role` VALUES (1, 1, '2020-03-15 10:23:57');

-- ----------------------------
-- Table structure for sys_direction
-- ----------------------------
DROP TABLE IF EXISTS `sys_direction`;
CREATE TABLE `sys_direction`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `dic_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典编码',
  `dic_index` tinyint(1) DEFAULT NULL COMMENT '字段索引',
  `dic_value` varchar(26) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典值',
  `dic_key` varchar(26) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典键值',
  `dic_desc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_direction
-- ----------------------------
INSERT INTO `sys_direction` VALUES (1, 'record_state', 1, '使用', '0', '记录使用状态');
INSERT INTO `sys_direction` VALUES (2, 'record_state', 2, '停用', '1', '记录使用状态');
INSERT INTO `sys_direction` VALUES (3, 'resource_type', 0, '菜单', '0', '资源类型 0:菜单1按钮');
INSERT INTO `sys_direction` VALUES (4, 'resource_type', 1, '按钮', '1', '资源类型 0:菜单1按钮');

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` bigint(12) DEFAULT NULL COMMENT '父主键',
  `organization_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '组织机构名字',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`organization_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` bigint(12) DEFAULT NULL COMMENT '父主键',
  `resource_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源名字',
  `resource_url` varchar(48) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源链接',
  `resource_type` tinyint(1) DEFAULT NULL COMMENT '资源类型: 0:菜单1按钮',
  `icon` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `order_no` tinyint(4) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`resource_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES (1, NULL, '系统菜单', NULL, 0, NULL, '系统菜单', 1, '2020-03-11 11:25:44', 1);
INSERT INTO `sys_resource` VALUES (2, NULL, '系统管理', 'system/manage', 0, 'md-settings', '系统管理', 0, '2020-03-11 11:25:44', 2);
INSERT INTO `sys_resource` VALUES (3, NULL, '功能模块1', 'fundetion/module', 0, NULL, '功能模块1', 0, '2019-10-28 11:26:05', 3);
INSERT INTO `sys_resource` VALUES (4, 2, '账号管理', 'system/accountList', 0, 'ios-keypad-outline', '账号管理', 0, '2019-10-28 11:27:18', 1);
INSERT INTO `sys_resource` VALUES (5, 2, '角色管理', 'system/roleList', 0, 'md-person-add', '角色管理', 0, '2019-10-28 11:43:52', 2);
INSERT INTO `sys_resource` VALUES (6, 2, '资源管理', 'system/resourceList', 0, 'ios-copy', '0', 0, '2019-11-07 09:59:12', 3);
INSERT INTO `sys_resource` VALUES (7, 2, '组织机构管理', 'system/organizationList', 0, 'ios-paper-outline', '0', 0, '2019-11-07 10:09:36', 4);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名字',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '管理员', '系统管理', 0, '2020-03-15 10:23:27');

-- ----------------------------
-- Table structure for sys_role_relation_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_relation_resource`;
CREATE TABLE `sys_role_relation_resource`  (
  `role_id` bigint(12) NOT NULL COMMENT '角色主键',
  `resource_id` bigint(12) NOT NULL COMMENT '资源主键',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色与资源关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_relation_resource
-- ----------------------------
INSERT INTO `sys_role_relation_resource` VALUES (1, 2, '2020-03-15 10:28:10');
INSERT INTO `sys_role_relation_resource` VALUES (1, 3, '2020-03-15 10:28:24');
INSERT INTO `sys_role_relation_resource` VALUES (1, 4, '2020-03-15 10:28:38');
INSERT INTO `sys_role_relation_resource` VALUES (1, 5, '2020-03-15 10:28:41');
INSERT INTO `sys_role_relation_resource` VALUES (1, 6, '2020-03-15 10:28:46');
INSERT INTO `sys_role_relation_resource` VALUES (1, 7, '2020-03-15 10:28:51');

SET FOREIGN_KEY_CHECKS = 1;
