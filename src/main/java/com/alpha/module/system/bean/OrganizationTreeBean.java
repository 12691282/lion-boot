package com.alpha.module.system.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class OrganizationTreeBean implements Serializable {
    //主键
    @TableId
    private Long id;
    //父主键
    private Long pid;
    //父组织机构名称
    private String pname;
    //组织机构名称
    private String organizationName;
    //描述
    private String description;
    //状态名
    private String stateName;
    //状态位
    private  String state;
    //创建时间
    private String createTime;

    private List<OrganizationTreeBean> children = new LinkedList<>();



}
