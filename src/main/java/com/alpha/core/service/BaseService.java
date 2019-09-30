package com.alpha.core.service;

import com.alpha.core.tools.ThreadLoaclTools;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

public class BaseService {


    protected <T> Page<T> getPage() {
        Map pageMap  = (Map) ThreadLoaclTools.getPageMap().get();
        Integer size = (Integer) pageMap.get("size");
        Integer index = (Integer) pageMap.get("index");
        Page<T> page = new Page<>(index,size);
        return page;
    }
}
