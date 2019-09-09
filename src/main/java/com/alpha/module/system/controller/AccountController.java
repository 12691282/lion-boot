package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.model.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("acount")
public class AccountController extends BaseController {


    @RequestMapping("getInfo")
    public ResultObject getAccount(){
        Account u = new Account();
        u.setId(1);
        u.setName("test");
        return ResultObject.getSuccess(u);
    }

}
