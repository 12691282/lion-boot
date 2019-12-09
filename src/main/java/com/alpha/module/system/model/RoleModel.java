package com.alpha.module.system.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_role")
public class RoleModel implements Serializable {

    //主键
    @TableId
    private Long id;
    //角色名称
    private String roleName;
    //描述
    private String description;
    //逻辑状态 0 :使用 1 删除
    private Integer state;
    //创建时间
    private Date createTime;
}
