package com.alpha.module.system.service.impl;

import com.alpha.core.constant.DirectionConstant;
import com.alpha.core.constant.ExceptionConstant;
import com.alpha.core.exception.SystemException;
import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.core.tools.TokenTools;
import com.alpha.module.system.bean.UserInfoBean;
import com.alpha.module.system.mapper.AccountMapper;
import com.alpha.module.system.model.AccountModel;
import com.alpha.module.system.service.AccountService;
import com.alpha.module.system.service.ResourceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
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

    @Autowired
    private ResourceInfoService resourceInfoService;

    @Override
    public PageTools getList(AccountModel query) {
        log.info("query {}", query);
        super.startPage();
        query.setStatus(DirectionConstant.USE_STATUS);
        query.setStatusCode(DirectionConstant.CODE_RECORD_STATUS);
        List list =  accountMapper.selectQueryAndPage(query);
        return PageTools.getPage(list);
    }

    @Override
    @Transactional
    public void saveOrUpdate(AccountModel account) {
        log.info("account {}", account);
            try {
                if(account.getId() != null){
                    account.setUpdateTime(new Date());
                    accountMapper.updateById(account);
                }else {
                    accountMapper.insert(account);
                }
            }catch (Exception e){
                e.printStackTrace();
                log.error(e.getMessage(),e.fillInStackTrace());
                Throwable cause = e.getCause();
                if(cause instanceof java.sql.SQLIntegrityConstraintViolationException){
                    throw new SystemException(ExceptionConstant.MESSAGE_NAME_EXIST);
                }
            }


    }

    @Override
    public void stopUseById(AccountModel account) {
        account.setRecordStatus(DirectionConstant.STOP_USE);
        accountMapper.updateById(account);
    }

    @Override
    public void startUseById(AccountModel account) {
        account.setRecordStatus(DirectionConstant.START_USE);
        accountMapper.updateById(account);
    }

    @Override
    public void deleteRecordById(AccountModel account) {
        account.setStatus(DirectionConstant.DELETE_STATUS);
        accountMapper.updateById(account);
    }

    @Override
    public List getResourceList() {
        return resourceInfoService.getAccountResourceList(1L);
    }

    @Override
    public UserInfoBean loginByAccount(AccountModel account) {
        log.info("account {}", account);
        QueryWrapper<AccountModel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account_name", account.getAccountName())
                    .eq("status", DirectionConstant.USE_STATUS)
                    .eq("record_status",DirectionConstant.START_USE);
        AccountModel newAccount = accountMapper.selectOne(queryWrapper);
        if(newAccount  == null){
            throw new SystemException("账号不存在，请重新输入！");
        }
        if(!newAccount.getPassword().equals(account.getPassword())){
            throw new SystemException("密码或账号不正确，请查询后输入！");
        }

        UserInfoBean bean = new UserInfoBean();
        bean.setId(newAccount.getId());
        bean.setName(newAccount.getName());
        bean.setBackup(newAccount.getBackup());
        bean.setEmail(newAccount.getEmail());
        bean.setToken(TokenTools.getToken());
        //12小时后过期
        DateTime now = DateTime.now().plusHours(12);
        bean.setExpireTime(now.toDate());
        return bean;
    }

}
