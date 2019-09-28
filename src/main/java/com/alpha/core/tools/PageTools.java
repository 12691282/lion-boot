package com.alpha.core.tools;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PageTools<T> extends Page<T> {
    private long pageIndex;
    private long pageSize;
    private T list;


    public PageTools(long pageIndex, long pageSize) {
        super(pageIndex, pageSize);
    }


    public PageTools(T list , long pageSize){
        this.list = list;
        this.pageSize = pageSize;
    }

    public static <T> PageTools getPage(T list , int pageSize){
        return new PageTools(list, pageSize);
    }
}
