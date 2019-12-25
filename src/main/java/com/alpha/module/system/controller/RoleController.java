package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.exception.SystemException;
import com.alpha.core.tools.PageTools;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.model.RoleModel;
import com.alpha.module.system.service.RoleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("role")
@Slf4j
public class RoleController extends BaseController {

    @Autowired
    private RoleInfoService roleInfoService;

    @PostMapping("getList")
    public ResultObject getRoleInfo(@RequestBody(required=false) RoleModel query){
        log.info("params: {}", query);
        ResultObject result;
        try{
            PageTools page = roleInfoService.getList(query);
            result = ResultObject.getSuccess(page);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }


    @PostMapping("saveOrUpdate")
    public ResultObject saveOrUpdate(@RequestBody RoleModel account){
        log.info("params: {}", account);
        ResultObject result = ResultObject.getSuccess();
        try{
              roleInfoService.saveOrUpdate(account);
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
    public ResultObject deleteRecordById(@RequestBody RoleModel role){
        log.info("id: {}", role.getId());
        ResultObject result = ResultObject.getSuccess();
        try{
            roleInfoService.deleteRecordById(role);
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


    @PostMapping("configAndUpdateByRoleId")
    public ResultObject configAndUpdateByRoleId(@RequestBody Map params){
        log.info("params: {}", params);
        ResultObject result = ResultObject.getSuccess();
        try{
            roleInfoService.configAndUpdateByRoleId(params);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }
}
