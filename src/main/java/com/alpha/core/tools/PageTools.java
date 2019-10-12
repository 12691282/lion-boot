package com.alpha.core.tools;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class PageTools<T>{
    private long total;
    private T list;

    public PageTools(T list , long total){
        this.list = list;
        this.total = total;
    }

    public static  <T>  PageTools getPage(List<T> list){
        PageInfo page = new PageInfo(list);
        return new PageTools(page.getList(), page.getTotal());
    }
}
