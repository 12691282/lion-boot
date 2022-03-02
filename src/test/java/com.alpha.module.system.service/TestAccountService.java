package com.alpha.module.system.service;

import com.alpha.MainApplication;
import com.alpha.core.tools.PageTools;
import com.alpha.module.system.model.AccountModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAccountService {


    @Autowired
    private AccountService accountService;


    @Test
    public void test(){
        AccountModel query = new AccountModel();
        PageTools page = accountService.getList(query);
        log.info("page {}", page);
    }


}
