package com.alpha.module.system.service;

import com.alpha.module.system.bean.ResourceTreeBean;
import com.alpha.module.system.model.ResourceModel;

import java.util.List;

public interface ResourceInfoService {
    /**
     * 查询账号信息
     * @param query
     * @return
     */
    List<ResourceTreeBean> getTreeList(ResourceTreeBean query);
    /**
     * 新增或修改
     * @param role
     */
    void saveOrUpdate(ResourceModel role);
    /**
     * 删除一条记录
     * @param role
     */
    void deleteRecordById(ResourceModel role);

    /**
     * 根据用户id获取资源列表
     * @param l
     * @return
     */
    List<ResourceTreeBean> getAccountResourceList(long l);

    /**
     *  获取已配置的资源树
     * @param roleId
     * @return
     */
    List<ResourceTreeBean> getConfigTreeById(Long roleId);
}
