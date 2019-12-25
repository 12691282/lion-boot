package com.alpha.module.system.service.impl;

import com.alpha.core.service.BaseService;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.mapper.AccountMapper;
import com.alpha.module.system.mapper.AccountRelationRoleMapper;
import com.alpha.module.system.model.AccountRelationRoleModel;
import com.alpha.module.system.service.AuthorityService;
import com.alpha.module.system.service.ResourceInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class AuthorityServiceImpl extends BaseService implements AuthorityService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountRelationRoleMapper accountRelationRoleMapper;

    @Override
    public PageTools getPageList() {
        super.startPage();
        List<Map> list = accountMapper.getAuthorityPageList();
        return PageTools.getPage(list);
    }

    @Override
    public void updateAuthorityById(Map param) {
        Object id = param.get("id");
        Object roleIds = param.get("roleIds");

        accountRelationRoleMapper.delete(
                new QueryWrapper<AccountRelationRoleModel>().eq("account_id",id)
        );
        if(roleIds != null){
            List idsList = (ArrayList)roleIds;
            AccountRelationRoleModel arrm = null;
            for(Object objId : idsList){
                arrm = new AccountRelationRoleModel();
                arrm.setAccountId(Long.valueOf(id.toString()));
                arrm.setRoleId(Long.valueOf(objId.toString()));
                accountRelationRoleMapper.insert(arrm);
            }

        }
    }
}
