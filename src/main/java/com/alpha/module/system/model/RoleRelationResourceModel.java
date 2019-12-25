package com.alpha.module.system.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_role_relation_resource")
public class RoleRelationResourceModel implements Serializable {

    //主键
    @TableId
    private Long id;
    //资源id
    private Long resourceId;
    //角色Id
    private Long roleId;
    //创建时间
    private Date createTime;
}
