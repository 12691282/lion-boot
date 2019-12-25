package com.alpha.module.system.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_account_relation_role")
public class AccountRelationRoleModel implements Serializable {

    //主键
    @TableId
    private Long id;
    //账户id
    private Long accountId;
    //角色id
    private Long roleId;
    //创建时间
    private Date createTime;
}
