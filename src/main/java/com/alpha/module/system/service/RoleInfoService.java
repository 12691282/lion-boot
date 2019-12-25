package com.alpha.module.system.service;

import com.alpha.core.tools.PageTools;
import com.alpha.module.system.model.RoleModel;

import java.util.List;
import java.util.Map;

public interface RoleInfoService {
    /**
     * 查询账号信息
     * @param query
     * @return
     */
    PageTools getList(RoleModel query);
    /**
     * 新增或修改
     * @param role
     */
    void saveOrUpdate(RoleModel role);
    /**
     * 删除一条记录
     * @param role
     */
    void deleteRecordById(RoleModel role);

    /**
     * 获取所有角色
     * @return
     */
    List getRoleList();


}
