package com.alpha.module.system.service.impl;

import com.alpha.core.constant.DirectionConstant;
import com.alpha.core.constant.ExceptionConstant;
import com.alpha.core.exception.SystemException;
import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.mapper.AccountRelationRoleMapper;
import com.alpha.module.system.mapper.RoleInfoMapper;
import com.alpha.module.system.mapper.RoleRelationResourceMapper;
import com.alpha.module.system.model.AccountRelationRoleModel;
import com.alpha.module.system.model.RoleModel;
import com.alpha.module.system.model.RoleRelationResourceModel;
import com.alpha.module.system.service.RoleInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RoleInfoServiceImpl extends BaseService implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Autowired
    private RoleRelationResourceMapper roleRelationResourceMapper;

    @Override
    public PageTools getList(RoleModel query) {
        log.info("query {}", query);
        super.startPage();
        query.setState(DirectionConstant.USE_STATE);
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
        role.setState(DirectionConstant.DELETE_STATE);
        roleInfoMapper.updateById(role);
    }

    @Override
    public List getRoleList() {
        return   roleInfoMapper.selectList(
                new QueryWrapper<RoleModel>().eq("state", DirectionConstant.USE_STATE)
        );
    }

    @Override
    public void configAndUpdateByRoleId(Map params) {
        log.info("params : {}", params);
        Object roleId = params.get("roleId");
        Object resourceIds = params.get("resourceIds");

        roleRelationResourceMapper.delete(
                new QueryWrapper<RoleRelationResourceModel>().
                        eq("role_id", roleId)
        );
        if(resourceIds != null){
            List<Integer> ids = (List)resourceIds;
            RoleRelationResourceModel rrrm = null;
            for(Integer resourceId : ids){
                rrrm = new RoleRelationResourceModel();
                rrrm.setRoleId(Long.valueOf(roleId.toString()));
                rrrm.setResourceId(Long.valueOf(resourceId));
                roleRelationResourceMapper.insert(rrrm);
            }
        }

    }

}
