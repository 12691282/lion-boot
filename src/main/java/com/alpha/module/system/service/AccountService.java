package com.alpha.module.system.service;

import com.alpha.core.tools.PageTools;
import com.alpha.module.system.model.AccountModel;

public interface AccountService {
    /**
     * 查询账号信息
     * @param query
     * @return
     */
    PageTools getList(AccountModel query);

    /**
     * 新增或修改
     * @param account
     */
    void saveOrUpdate(AccountModel account);

    /**
     * 停用一条数据
     * @param id
     */
    void stopUseById(AccountModel account);
    /**
     * 启用一条数据
     * @param id
     */
    void startUseById(AccountModel account);

    /**
     * 删除一条记录
     * @param account
     */
    void deleteRecordById(AccountModel account);
}
