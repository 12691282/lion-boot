package com.alpha.module.system.service;

import com.alpha.module.system.model.OrganizationModel;

import java.util.List;

public interface OrganizationService {
    /**
     * 查询账号信息
     * @param query
     * @return
     */
    List getOrganizationPageList(OrganizationModel query);

    /**
     * 新增或修改
     * @param account
     */
    void saveOrUpdate(OrganizationModel account);


}
