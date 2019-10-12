package com.alpha.core.exception;

import lombok.Data;

@Data
public class SystemException extends  RuntimeException {

    private String code;
    private String msg;

    public SystemException(String msg){
        this.msg = msg;
    }

    public SystemException(String msg, String code){
        this.msg = msg;
        this.code = code;
    }

}
