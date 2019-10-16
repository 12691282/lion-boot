package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.exception.SystemException;
import com.alpha.core.tools.PageTools;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.model.ResourceModel;
import com.alpha.module.system.model.RoleModel;
import com.alpha.module.system.service.ResourceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resource")
@Slf4j
public class ResourceController extends BaseController {

    @Autowired
    private ResourceInfoService resourceInfoService;

    @PostMapping("getList")
    public ResultObject getList(@RequestBody(required=false) ResourceModel query){
        log.info("params: {}", query);
        ResultObject result;
        try{
            PageTools page = resourceInfoService.getList(query);
            result = ResultObject.getSuccess(page);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }


    @PostMapping("saveOrUpdate")
    public ResultObject saveOrUpdate(@RequestBody ResourceModel account){
        log.info("params: {}", account);
        ResultObject result = ResultObject.getSuccess();
        try{
            resourceInfoService.saveOrUpdate(account);
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
    public ResultObject deleteRecordById(@RequestBody ResourceModel resource){
        log.info("id: {}", resource.getId());
        ResultObject result = ResultObject.getSuccess();
        try{
            resourceInfoService.deleteRecordById(resource);
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
