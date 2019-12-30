SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_account
-- ----------------------------

CREATE TABLE `sys_account`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '名字',
  `account_name` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '账户名字',
  `password` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '密码',
  `backup` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电子邮件',
  `record_state` tinyint(1) DEFAULT 0 COMMENT '启用状态 0 :启用 1 停用',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`account_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;


CREATE TABLE `sys_account_relation_organization`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` bigint(12) NOT NULL COMMENT '账号主键',
  `organization_id` bigint(12) NOT NULL COMMENT '角色主键',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 :删除',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户与组织机构关联表' ROW_FORMAT = Dynamic;


CREATE TABLE `sys_account_relation_role`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` bigint(12) NOT NULL COMMENT '账号主键',
  `role_id` bigint(12) NOT NULL COMMENT '角色主键',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 :删除',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户与角色关联表' ROW_FORMAT = Dynamic;

CREATE TABLE `sys_direction`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `dic_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典编码',
  `dic_index` tinyint(1) DEFAULT NULL COMMENT '字段索引',
  `dic_value` varchar(26) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典值',
  `dic_key` varchar(26) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典键值',
  `dic_desc` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;



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



CREATE TABLE `sys_resource`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `pid` bigint(12) DEFAULT NULL COMMENT '父主键',
  `resource_name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源名字',
  `resource_url` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '资源链接',
  `resource_type` tinyint(1) DEFAULT NULL COMMENT '资源类型: 0:菜单1按钮',
  `icon` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `order_no` tinyint(4) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`resource_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;


CREATE TABLE `sys_role`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名字',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;


CREATE TABLE `sys_role_relation_resource`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(12) NOT NULL COMMENT '角色主键',
  `resource_id` bigint(12) NOT NULL COMMENT '资源主键',
  `state` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 :删除',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色与资源关联表' ROW_FORMAT = Dynamic;

INSERT INTO `sys_resource` VALUES (1, NULL, '系统菜单', NULL, 0, NULL, 1, '2019-10-28 11:25:44', 1, NULL);
INSERT INTO `sys_resource` VALUES (2, NULL, '系统管理', 'system/manage', 0, NULL, 0, '2019-10-28 11:25:54', 2, NULL);
INSERT INTO `sys_resource` VALUES (3, NULL, '功能模块1', 'fundetion/module', 0, NULL, 0, '2019-10-28 11:26:05', 3, NULL);
INSERT INTO `sys_resource` VALUES (4, 2, '账号管理', 'system/accountList', 0, '', 0, '2019-10-28 11:27:18', 1, NULL);
INSERT INTO `sys_resource` VALUES (5, 2, '角色管理', 'system/roleList', 0, NULL, 0, '2019-10-28 11:43:52', 2, NULL);
INSERT INTO `sys_resource` VALUES (6, 2, '资源管理', 'system/resourceList', 0, '', 0, '2019-11-07 09:59:12', 3, NULL);
INSERT INTO `sys_resource` VALUES (7, 2, '组织机构管理', 'system/organizationList', 0, '', 0, '2019-11-07 10:09:36', 4, NULL);
INSERT INTO `sys_resource` VALUES (8, 2, '权限管理', 'system/authorityManage', 0, '', 0, '2019-11-07 10:25:36', 5, NULL);
INSERT INTO `sys_resource` VALUES (9, 2, '字典管理', 'system/directionList', 0, '', 0, '2019-11-07 10:26:16', 6, NULL);
INSERT INTO `sys_resource` VALUES (10, 3, '功能模块-A-1', '22', 0, '', 0, '2019-11-20 11:04:22', 1, NULL);
INSERT INTO `sys_resource` VALUES (11, 3, '功能模块-A-2', '22', 0, '2', 0, '2019-11-20 11:04:38', 2, NULL);