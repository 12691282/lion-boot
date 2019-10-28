package com.alpha.core.service;

import com.alpha.core.tools.ThreadLoaclTools;
import com.github.pagehelper.PageHelper;

import java.util.Map;

public class BaseService {

    protected void startPage() {
        Map pageMap  = (Map) ThreadLoaclTools.getPageMap().get();
        if(pageMap != null){
            Integer size = (Integer) pageMap.get("size");
            Integer index = (Integer) pageMap.get("index");
            PageHelper.startPage(index, size);
        }
    }

}
