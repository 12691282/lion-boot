package com.alpha.module.system.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_resource")
public class ResourceModel {
    //主键
    @TableId
    private Long id;
    //父主键
    private Long pid;
    //资源名称
    private String resourceName;
    //资源连接
    private String resourceUrl;
    //资源类型  0:菜单1按钮
    private Integer resourceType;
    //顺序号
    private Integer orderNo;
    //图标
    private String icon;
    //描述
    private String description;
    //逻辑状态 0 :使用 1 删除
    private Integer status;
    //创建时间
    private Date createTime;
}
