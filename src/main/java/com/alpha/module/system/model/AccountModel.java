package com.alpha.module.system.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("sys_account")
public class AccountModel implements Serializable {

    //主键
    @TableId
    private Long id;
    //用户名字
    private String name;
    //账号名称
    private String accountName;
    //密码
    private String password;
    //备注
    private String backup;
    //逻辑状态 0 :使用 1 删除
    private Integer state;

    //启用状态 0 :启用 1 停用
    private Integer recordState;
    //电子邮箱
    private String email;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;

    //token
    @TableField(exist = false)
    private String token;
    //过期时间
    @TableField(exist = false)
    private Date expireTime;

    //状态名称
    @TableField(exist = false)
    private String stateName;

    //字典代码
    @TableField(exist = false)
    private String stateCode;

}
