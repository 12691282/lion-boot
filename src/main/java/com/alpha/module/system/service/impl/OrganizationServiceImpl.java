package com.alpha.module.system.service.impl;

import com.alpha.core.constant.DirectionConstant;
import com.alpha.core.constant.ExceptionConstant;
import com.alpha.core.exception.SystemException;
import com.alpha.core.service.BaseService;
import com.alpha.module.system.bean.OrganizationTreeBean;
import com.alpha.module.system.bean.ResourceTreeBean;
import com.alpha.module.system.mapper.OrganizationMapper;
import com.alpha.module.system.model.OrganizationModel;
import com.alpha.module.system.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class OrganizationServiceImpl extends BaseService implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

    @Override
    public List getOrganizationPageList(OrganizationModel query) {
        Map param = new HashMap();
        log.info("query {}", query);
        param.put("name", query.getOrganizationName());
//        param.put("state",DirectionConstant.USE_STATE);
        param.put("stateCode" ,DirectionConstant.CODE_RECORD_STATE);
        List<OrganizationTreeBean> beansList =  organizationMapper.getOrganizationPageList(param);
        if(beansList.isEmpty()){
            return Collections.emptyList();
        }
        List<OrganizationTreeBean> treeList = new LinkedList<>();
        for(OrganizationTreeBean  bean : beansList){
            if(bean.getPid() == null){
                treeList.add(bean);
                this.toRecursionTree(bean,beansList);
            }
        }
        return treeList;
    }

    /**
     * 递归生成树
     * @param pBean
     * @param beansList
     */
    private void toRecursionTree(OrganizationTreeBean pBean, List<OrganizationTreeBean> beansList) {
        for(OrganizationTreeBean bean : beansList){
            if(pBean.getId().equals(bean.getPid())){
                pBean.getChildren().add(bean);
                this.toRecursionTree(bean,beansList);
            }
        }
    }

    @Override
    @Transactional
    public void saveOrUpdate(OrganizationModel organization) {
        log.info("organization {}", organization);
            try {
                if(organization.getId() != null){
                    organization.setUpdateTime(new Date());
                    organizationMapper.updateById(organization);
                }else {
                    organizationMapper.insert(organization);
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



}
