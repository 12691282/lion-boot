package com.alpha.module.system.service.impl;

import com.alpha.core.constant.DirectionConstant;
import com.alpha.core.constant.ExceptionConstant;
import com.alpha.core.exception.SystemException;
import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.mapper.AccountMapper;
import com.alpha.module.system.model.Account;
import com.alpha.module.system.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
        query.setStatus(DirectionConstant.USE_STATUS);
        List list =  accountMapper.selectQueryAndPage(query);
        return PageTools.getPage(list);
    }

    @Override
    @Transactional
    public void saveOrUpdate(Account account) {
        log.info("account {}", account);
        if(account.getId() != null){
            account.setUpdateTime(new Date());
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

    @Override
    public void stopUseById(Account account) {
        account.setRecordStatus(DirectionConstant.STOP_USE);
        accountMapper.updateById(account);
    }

    @Override
    public void startUseById(Account account) {
        account.setRecordStatus(DirectionConstant.START_USE);
        accountMapper.updateById(account);
    }

    @Override
    public void deleteRecordById(Account account) {
        account.setStatus(DirectionConstant.DELETE_STATUS);
        accountMapper.updateById(account);
    }
}
