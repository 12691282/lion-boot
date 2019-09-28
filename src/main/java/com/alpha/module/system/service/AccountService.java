package com.alpha.module.system.service;

import com.alpha.core.tools.PageTools;
import com.alpha.module.system.model.Account;

public interface AccountService {
    PageTools getList(Account query);
}
