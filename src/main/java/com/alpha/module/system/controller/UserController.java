package com.alpha.module.system.controller;

import com.alpha.core.controller.BaseController;
import com.alpha.core.tools.ResultObject;
import com.alpha.module.system.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController extends BaseController {


    @RequestMapping("getInfo")
    public ResultObject getUser(){
        User u = new User();
        u.setId(1);
        u.setName("test");
        return ResultObject.getSuccess(u);
    }

}
