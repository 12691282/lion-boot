package com.alpha.module.system.service.impl;

import com.alpha.core.service.BaseService;
import com.alpha.module.system.model.Account;
import com.alpha.module.system.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AccountServiceImpl extends BaseService implements AccountService {

        @Override
        public List<Account> getList() {
               List<Account> list = new LinkedList<>();
               Account u;
               for(int i =1; i<= 10; i++){
                String str = Integer.toString(i);
                   u = new Account();
                   u.setId(i);
                   u.setName("name"+str+ "test");
                   u.setAccountName("account name " + str );
                   u.setBackup("备注-numb:"+ str);
                   u.setStatus(1);
                   list.add(u);
               }
            return list;
        }
}
