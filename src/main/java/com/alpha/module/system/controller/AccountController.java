package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.exception.SystemException;
import com.alpha.core.tools.PageTools;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.model.AccountModel;
import com.alpha.module.system.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
@Slf4j
public class AccountController extends BaseController {

    @Autowired
    private AccountService accountService;

    @PostMapping("getInfo")
    public ResultObject getAccount(@RequestBody(required=false) AccountModel query){
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
    public ResultObject saveOrUpdate(@RequestBody AccountModel account){
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
    public ResultObject stopUseById(@RequestBody AccountModel account){
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
    public ResultObject startUseById(@RequestBody AccountModel account){
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
    public ResultObject deleteRecordById(@RequestBody AccountModel account){
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



    @PostMapping("getResourceList")
    public ResultObject getResourceList(){
        log.info("params: ");
        ResultObject result;
        try{
            List list = accountService.getResourceList();
            result = ResultObject.getSuccess(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }

}
