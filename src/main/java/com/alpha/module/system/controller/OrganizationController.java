package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.exception.SystemException;
import com.alpha.core.tools.PageTools;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.model.AccountModel;
import com.alpha.module.system.model.OrganizationModel;
import com.alpha.module.system.service.AccountService;
import com.alpha.module.system.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("organization")
@Slf4j
public class OrganizationController extends BaseController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("getInfoPageList")
    public ResultObject getOrganizationInfo(@RequestBody(required=false) OrganizationModel query){
        log.info("params: {}", query);
        ResultObject result;
        try{
            List list = organizationService.getOrganizationPageList(query);
            result = ResultObject.getSuccess(list);
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            result = ResultObject.getFailure();
        }
        return result;
    }

    @PostMapping("saveOrUpdate")
    public ResultObject saveOrUpdate(@RequestBody OrganizationModel account){
        log.info("params: {}", account);
        ResultObject result = ResultObject.getSuccess();
        try{
            organizationService.saveOrUpdate(account);
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
