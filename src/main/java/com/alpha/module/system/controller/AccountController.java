package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.model.Account;
import com.alpha.module.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("getInfo")
    public ResultObject getAccount(){
        List<Account> list = accountService.getList();
        return ResultObject.getSuccess(list);
    }

}
