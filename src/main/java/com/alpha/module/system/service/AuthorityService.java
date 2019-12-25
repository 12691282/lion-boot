package com.alpha.module.system.service;

import com.alpha.core.tools.PageTools;

import java.util.Map;

public interface AuthorityService {

    /**
     * 获取账号及分配角色信息
     * @return
     */
    PageTools getPageList();

    /**
     * 根据id 更新授权列表
     * @param param
     */
    void updateAuthorityById(Map param);
}
