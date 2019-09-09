package com.alpha.module.system.model;

import lombok.Data;

@Data
public class Account {

    //主键
    private int id;
    //用户名字
    private String name;
    //账号名称
    private String accountName;
    //密码
    private String password;


}
