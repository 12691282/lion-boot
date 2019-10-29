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
  `status` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '电子邮件',
  `record_status` tinyint(1) DEFAULT 0 COMMENT '启用状态 0 :启用 1 停用',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`account_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;


CREATE TABLE `sys_account_relation_organization`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` bigint(12) NOT NULL COMMENT '账号主键',
  `organization_id` bigint(12) NOT NULL COMMENT '角色主键',
  `status` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 :删除',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '用户与组织机构关联表' ROW_FORMAT = Dynamic;


CREATE TABLE `sys_account_relation_role`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_id` bigint(12) NOT NULL COMMENT '账号主键',
  `role_id` bigint(12) NOT NULL COMMENT '角色主键',
  `status` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 :删除',
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
  `status` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
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
  `icon` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '图标',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `status` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `order_no` tinyint(4) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`resource_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;


CREATE TABLE `sys_role`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '角色名字',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `status` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 删除',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unique_account`(`role_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;


CREATE TABLE `sys_role_relation_resource`  (
  `id` bigint(12) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(12) NOT NULL COMMENT '角色主键',
  `resource_id` bigint(12) NOT NULL COMMENT '资源主键',
  `status` tinyint(1) DEFAULT 0 COMMENT '逻辑状态 0 :使用 1 :删除',
  `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '角色与资源关联表' ROW_FORMAT = Dynamic;

