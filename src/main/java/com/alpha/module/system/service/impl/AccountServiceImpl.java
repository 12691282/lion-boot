package com.alpha.module.system.service.impl;

import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.mapper.AccountMapper;
import com.alpha.module.system.model.Account;
import com.alpha.module.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl extends BaseService implements AccountService {

        @Autowired
        private AccountMapper accountMapper;

        @Override
        public PageTools getList() {
            List<Account> list =  accountMapper.selectList(null);
            return PageTools.getPage(list, list.size());
        }
}
