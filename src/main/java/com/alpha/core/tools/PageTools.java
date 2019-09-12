package com.alpha.core.tools;

import lombok.Data;

@Data
public class PageTools<T> {
    private int pageIndex;
    private int pageSize;
    private T list;

    public PageTools(T list , int pageSize){
        this.list = list;
        this.pageSize = pageSize;
    }

    public static <T> PageTools getPage(T list , int pageSize){
        return new PageTools(list, pageSize);
    }
}
