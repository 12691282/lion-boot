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

    void saveOrUpdate(Account account);
}
