package com.alpha.core.tools;

import java.util.Map;

public class ThreadLocalTools {

    private static final ThreadLocal<Map<Object, Object>> pageMap = new ThreadLocal();
    public static ThreadLocal  getPageMap(){
        return pageMap;
    }
}
