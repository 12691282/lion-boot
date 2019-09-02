package com.alpha.core.tools;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultObject<T> implements Serializable {

    private static final String success_code = "000";

    //返回状态 成功 000 失败 001
    private String code;
    //消息提示
    private String message;
    //返回数据主题
    private T data;

    public ResultObject(){

    }
    public ResultObject(String code){
        this.code = code;
    }

    public ResultObject(String code, T data){
        this.code = code;
        this.data = data;
    }



    public static ResultObject getSuccess(){
        return new ResultObject(success_code);
    }

    public static <T> ResultObject getSuccess(T data){
        return new ResultObject(success_code, data);
    }

    public static <T> ResultObject  getSuccess(String message,T data){
        return new ResultObject(message, data);
    }

}
