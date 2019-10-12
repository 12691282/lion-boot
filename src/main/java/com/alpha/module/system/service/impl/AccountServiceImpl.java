package com.alpha.module.system.service.impl;

import com.alpha.core.constant.ExceptionConstant;
import com.alpha.core.exception.SystemException;
import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.mapper.AccountMapper;
import com.alpha.module.system.model.Account;
import com.alpha.module.system.service.AccountService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
@Slf4j
public class AccountServiceImpl extends BaseService implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public PageTools getList(Account query) {
        log.info("query {}", query);
        super.startPage();
        QueryWrapper<Account> queryWrapper =  new QueryWrapper<>();
        queryWrapper.like("name", query.getName()).like("account_name", query.getAccountName());
        List list =  accountMapper.selectList(queryWrapper);
        return PageTools.getPage(list);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Account account) {
        log.info("account {}", account);
        if(account.getId() != null){
            accountMapper.updateById(account);
        }else {
            try {
                accountMapper.insert(account);
            }catch (Exception e){
                Throwable cause = e.getCause();
                if(cause instanceof java.sql.SQLIntegrityConstraintViolationException){
                    throw new SystemException(ExceptionConstant.MESSAGE_ACCOUNT_NAME);
                }
            }

        }
    }
}
