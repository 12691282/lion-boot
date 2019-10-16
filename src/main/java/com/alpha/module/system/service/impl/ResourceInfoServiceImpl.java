package com.alpha.module.system.service.impl;

import com.alpha.core.constant.DirectionConstant;
import com.alpha.core.constant.ExceptionConstant;
import com.alpha.core.exception.SystemException;
import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.mapper.ResourceInfoMapper;
import com.alpha.module.system.mapper.RoleInfoMapper;
import com.alpha.module.system.model.ResourceModel;
import com.alpha.module.system.model.RoleModel;
import com.alpha.module.system.service.ResourceInfoService;
import com.alpha.module.system.service.RoleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ResourceInfoServiceImpl extends BaseService implements ResourceInfoService {

    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    public PageTools getList(ResourceModel query) {
        log.info("query {}", query);
        super.startPage();
        query.setStatus(DirectionConstant.USE_STATUS);
        query.setTypeCode(DirectionConstant.CODE_RESOURCE_TYPE);
        List list =  resourceInfoMapper.selectQueryAndPage(query);
        return PageTools.getPage(list);
    }

    @Override
    @Transactional
    public void saveOrUpdate(ResourceModel resource) {
        log.info("resource {}", resource);
            try {
                if(resource.getId() != null){
                    resourceInfoMapper.updateById(resource);
                }else {
                    resourceInfoMapper.insert(resource);
                }
            }catch (Exception e){
                e.printStackTrace();
                log.error(e.getMessage(),e.fillInStackTrace());
                Throwable cause = e.getCause();
                if(cause instanceof java.sql.SQLIntegrityConstraintViolationException){
                    throw new SystemException(ExceptionConstant.MESSAGE_NAME_EXIST);
                }
            }
    }

    @Override
    public void deleteRecordById(ResourceModel resource) {
        log.info("resource {}", resource);
        resource.setStatus(DirectionConstant.DELETE_STATUS);
        resourceInfoMapper.updateById(resource);
    }
}
