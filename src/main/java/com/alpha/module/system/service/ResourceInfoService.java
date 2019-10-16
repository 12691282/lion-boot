package com.alpha.module.system.service;

import com.alpha.core.tools.PageTools;
import com.alpha.module.system.model.ResourceModel;

public interface ResourceInfoService {
    /**
     * 查询账号信息
     * @param query
     * @return
     */
    PageTools getList(ResourceModel query);
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
}
