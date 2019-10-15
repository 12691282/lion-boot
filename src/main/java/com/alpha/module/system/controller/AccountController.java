package com.alpha.module.system.controller;

import com.alpha.core.constant.ExceptionConstant;
import com.alpha.core.controller.BaseController;
import com.alpha.core.exception.SystemException;
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

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("account")
@Slf4j
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    @PostMapping("getInfo")
    public ResultObject getAccount(@RequestBody(required=false) Account query){
        log.info("params: {}", query);
        ResultObject result;
        try{
            PageTools page = accountService.getList(query);
            result = ResultObject.getSuccess(page);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }


    @PostMapping("saveOrUpdate")
    public ResultObject saveOrUpdate(@RequestBody Account account){
        log.info("params: {}", account);
        ResultObject result = ResultObject.getSuccess();
        try{
              accountService.saveOrUpdate(account);
        }catch (SystemException sysExc){
            sysExc.printStackTrace();
            log.error(sysExc.getMessage());
            result = ResultObject.getFailure(sysExc.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }


    @PostMapping("stopUseById")
    public ResultObject stopUseById(@RequestBody Account account){
        log.info("id: {}", account.getId());
        ResultObject result = ResultObject.getSuccess();
        try{
            accountService.stopUseById(account);
        }catch (SystemException sysExc){
            sysExc.printStackTrace();
            log.error(sysExc.getMessage());
            result = ResultObject.getFailure(sysExc.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }

    @PostMapping("startUseById")
    public ResultObject startUseById(@RequestBody Account account){
        log.info("id: {}", account.getId());
        ResultObject result = ResultObject.getSuccess();
        try{
            accountService.startUseById(account);
        }catch (SystemException sysExc){
            sysExc.printStackTrace();
            log.error(sysExc.getMessage());
            result = ResultObject.getFailure(sysExc.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }

    @PostMapping("deleteRecordById")
    public ResultObject deleteRecordById(@RequestBody Account account){
        log.info("id: {}", account.getId());
        ResultObject result = ResultObject.getSuccess();
        try{
            accountService.deleteRecordById(account);
        }catch (SystemException sysExc){
            sysExc.printStackTrace();
            log.error(sysExc.getMessage());
            result = ResultObject.getFailure(sysExc.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }

}
