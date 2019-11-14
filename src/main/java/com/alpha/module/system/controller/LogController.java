package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.exception.SystemException;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.bean.UserInfoBean;
import com.alpha.module.system.model.AccountModel;
import com.alpha.module.system.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("system")
@Slf4j
public class LogController  extends BaseController {

    @Autowired
    private AccountService accountService;

    @PostMapping("login")
    public ResultObject login(@RequestBody(required=false) AccountModel account){
        log.info("account: {}", account);
        ResultObject result;
        try{

            UserInfoBean bean = accountService.loginByAccount(account);
            result = ResultObject.getSuccess(bean);
        }catch (SystemException e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure(e.getMsg());
        }
        return result;
    }

}
