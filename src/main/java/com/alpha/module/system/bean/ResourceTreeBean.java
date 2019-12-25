package com.alpha.module.system.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
public class ResourceTreeBean implements Serializable {
    //主键
    private Long id;
    //父主键
    private Long pid;
    //父资源名称
    private String pname;
    //资源名称
    private String resourceName;
    //资源连接
    private String resourceUrl;
    //资源类型  0:菜单1按钮
    private Integer resourceType;
    //资源类型名称
    private String resourceTypeName;
    //顺序号
    private String orderNo;
    //图标
    private String icon;
    //描述
    private String description;
    //逻辑状态 0 :使用 1 删除
    private Integer state;
    //创建时间
    private Date createTime;
    //字典代码
    private String typeCode;
    //角色id
    private Long roleId;


    private List<ResourceTreeBean> children = new LinkedList<>();



}
