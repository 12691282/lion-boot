package com.alpha.module.system.mapper;

import com.alpha.module.system.model.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface AccountMapper  extends BaseMapper<Account> {
    /**
     * 查询及分页
     * @param query
     * @return
     */
    List<Account> selectQueryAndPage(Account query);
}
