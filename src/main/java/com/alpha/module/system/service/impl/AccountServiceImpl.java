package com.alpha.module.system.service.impl;

import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.mapper.AccountMapper;
import com.alpha.module.system.model.Account;
import com.alpha.module.system.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl extends BaseService implements AccountService {

        @Autowired
        private AccountMapper accountMapper;

        @Override
        public PageTools getList(Account query) {

            Page<Account> page = super.getPage();
            QueryWrapper<Account> queryWrapper =  new QueryWrapper<>();
            queryWrapper.like("name", query.getName());
            queryWrapper.like("accountName", query.getAccountName());
            IPage list =  accountMapper.selectPage(page,queryWrapper);
            return PageTools.getPage(list.getRecords(), list.getTotal());
        }
}
