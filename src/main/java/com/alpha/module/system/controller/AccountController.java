package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.tools.PageTools;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.model.Account;
import com.alpha.module.system.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
@Slf4j
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    //todo HandlerMethodArgumentResolver
    @PostMapping("getInfo")
    public ResultObject getAccount(@RequestBody(required=false) Account query){
        log.info("params: %s", query);
        ResultObject result;
        try{
            PageTools page = accountService.getList(query);
            result = ResultObject.getSuccess(page);
        }catch (Exception e){
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }

}
