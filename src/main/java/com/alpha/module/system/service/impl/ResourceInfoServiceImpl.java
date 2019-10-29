package com.alpha.module.system.service.impl;

import com.alpha.core.constant.DirectionConstant;
import com.alpha.core.constant.ExceptionConstant;
import com.alpha.core.exception.SystemException;
import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.bean.ResourceTreeBean;
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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class ResourceInfoServiceImpl extends BaseService implements ResourceInfoService {

    @Autowired
    private ResourceInfoMapper resourceInfoMapper;

    @Override
    public List getTreeList(ResourceTreeBean query) {
        log.info("query {}", query);
        query.setStatus(DirectionConstant.USE_STATUS);
        query.setTypeCode(DirectionConstant.CODE_RESOURCE_TYPE);
        List<ResourceTreeBean> beansList =  resourceInfoMapper.selectBeanList(query);
        if(beansList.isEmpty()){
            return Collections.emptyList();
        }

        List<ResourceTreeBean> treeList = new LinkedList<>();
        this.toFillBeanTree(treeList, beansList);

        return  treeList;
    }

    /**
     * 从顶层开始遍历
     * @param treeList
     * @param beansList
     */
    private void toFillBeanTree(List<ResourceTreeBean> treeList, List<ResourceTreeBean> beansList) {
        for(ResourceTreeBean bean : beansList){
            if(bean.getPid() == null){
                treeList.add(bean);
                this.toRecursionTree(bean,beansList);
            }
        }
    }
    /**
     * 递归生成树
     * @param pBean
     * @param beansList
     */
    private void toRecursionTree(ResourceTreeBean pBean,  List<ResourceTreeBean> beansList) {
        for(ResourceTreeBean bean : beansList){
            if(pBean.getId().equals(bean.getPid())){
                pBean.getChildren().add(bean);
                this.toRecursionTree(bean,beansList);
            }
        }
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

    @Override
    public List<ResourceTreeBean> getAccountResourceList(long accountId) {
        ResourceTreeBean query = new ResourceTreeBean();
        query.setStatus(DirectionConstant.USE_STATUS);
        query.setTypeCode(DirectionConstant.CODE_RESOURCE_TYPE);
        List<ResourceTreeBean> beansList =  resourceInfoMapper.selectBeanList(query);
        List<ResourceTreeBean> treeList = new LinkedList<>();
        this.toFillBeanTree(treeList, beansList);
        return treeList;
    }
}
