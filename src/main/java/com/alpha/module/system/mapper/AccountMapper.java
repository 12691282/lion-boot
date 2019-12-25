package com.alpha.module.system.mapper;

import com.alpha.module.system.model.AccountModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface AccountMapper  extends BaseMapper<AccountModel> {
    /**
     * 查询及分页
     * @param query
     * @return
     */
    List<AccountModel> selectQueryAndPage(AccountModel query);

    List<Map> getAuthorityPageList();
}
