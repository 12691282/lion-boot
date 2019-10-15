package com.alpha.module.system.service;

import com.alpha.core.tools.PageTools;
import com.alpha.module.system.model.Account;
import com.github.pagehelper.PageInfo;

public interface AccountService {
    /**
     * 查询账号信息
     * @param query
     * @return
     */
    PageTools getList(Account query);

    /**
     * 新增或修改
     * @param account
     */
    void saveOrUpdate(Account account);

    /**
     * 停用一条数据
     * @param id
     */
    void stopUseById(Account account);
    /**
     * 启用一条数据
     * @param id
     */
    void startUseById(Account account);

    /**
     * 删除一条记录
     * @param account
     */
    void deleteRecordById(Account account);
}
