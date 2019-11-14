package com.alpha.module.system.bean;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoBean {

    //主键
    private Long id;
    //用户名字
    private String name;
    //账号名称
    private String accountName;
    //备注
    private String backup;
    //电子邮箱
    private String email;
    //token
    private String token;
    //过期时间
    private Date expireTime;

}
