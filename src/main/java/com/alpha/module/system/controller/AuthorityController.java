package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.tools.PageTools;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.service.AuthorityService;
import com.alpha.module.system.service.RoleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("authority")
@Slf4j
public class AuthorityController extends BaseController {

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private RoleInfoService roleInfoService;

    @PostMapping("getPageList")
    public ResultObject getPageList(){
        log.info("ResultObject getPageList  ");
        ResultObject result;
        try{
            PageTools page = authorityService.getPageList();
            result = ResultObject.getSuccess(page);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }


    @PostMapping("getRoleList")
    public ResultObject getRoleList(){
        log.info("ResultObject getRoleList  ");
        ResultObject result;
        try{
            List list = roleInfoService.getRoleList();
            result = ResultObject.getSuccess(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }

    @PostMapping("updateAuthorityById")
    public ResultObject updateAuthorityById(@RequestBody Map param){
        log.info("ResultObject updateAuthorityById  param :{}", param);
        ResultObject result;
        try{
            authorityService.updateAuthorityById(param);
            result = ResultObject.getSuccess();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }

}
