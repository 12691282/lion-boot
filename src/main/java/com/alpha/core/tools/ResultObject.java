package com.alpha.core.tools;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultObject<T> implements Serializable {

    private static final String success_code = "000";

    private static final String success_default_msg = "操作成功";

    private static final String defeat_code = "001";

    private static final String defeat_default_msg = "数据读取错误";

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

    public ResultObject(String code, String msg, T data){
        this.code = code;
        this.data = data;
        this.message = msg;
    }

    public static ResultObject getSuccess(){
        return new ResultObject(success_code);
    }

    public static <T> ResultObject getSuccess(T data){
        return new ResultObject(success_code, success_default_msg, data);
    }

    public static <T> ResultObject  getSuccess(String message,T data){
        return new ResultObject(message, data);
    }

    public static ResultObject getDefeat()
    {
        return new ResultObject(defeat_code, defeat_default_msg);
    }
    public static ResultObject getDefeat(String msg)
    {
        return new ResultObject(defeat_code, msg);
    }
}