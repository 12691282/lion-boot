package com.alpha.module.system.service.impl;

import com.alpha.core.constant.DirectionConstant;
import com.alpha.core.constant.ExceptionConstant;
import com.alpha.core.exception.SystemException;
import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.mapper.RoleInfoMapper;
import com.alpha.module.system.model.RoleModel;
import com.alpha.module.system.service.RoleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class RoleInfoServiceImpl extends BaseService implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public PageTools getList(RoleModel query) {
        log.info("query {}", query);
        super.startPage();
        query.setStatus(DirectionConstant.USE_STATUS);
        List list =  roleInfoMapper.selectQueryAndPage(query);
        return PageTools.getPage(list);
    }

    @Override
    @Transactional
    public void saveOrUpdate(RoleModel role) {
        log.info("role {}", role);

            try {
                if(role.getId() != null){
                    roleInfoMapper.updateById(role);
                }else {
                    roleInfoMapper.insert(role);
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
    public void deleteRecordById(RoleModel role) {
        role.setStatus(DirectionConstant.DELETE_STATUS);
        roleInfoMapper.updateById(role);
    }
}