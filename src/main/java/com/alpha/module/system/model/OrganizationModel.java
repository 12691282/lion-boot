package com.alpha.module.system.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_organization")
public class OrganizationModel implements Serializable {

    //主键
    @TableId
    private Long id;
    //父主键
    private Long pid;
    //组织机构名字
    private String organizationName;
    //逻辑状态 0 :使用 1 删除
    private Integer state;
    //描述
    private String description;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;


}
