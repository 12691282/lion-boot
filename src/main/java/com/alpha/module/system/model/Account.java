package com.alpha.module.system.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_account")
public class Account {

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
    //启用状态 0 :启用 1 停用
    private Integer status;
    //电子邮箱
    private String email;
    //创建时间
    private Date createTime;

}
