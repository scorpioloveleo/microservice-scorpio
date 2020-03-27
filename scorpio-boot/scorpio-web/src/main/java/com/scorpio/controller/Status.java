package com.scorpio.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Status {
    private Integer code = 0;
    private String msg = "OK";

    public void setErrorCode(IErrorCode errorCode){
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public void setException(ApplicationException exception){
        this.code = exception.getCode();
        this.msg = exception.getMsg();
    }
    @JsonIgnore
    public ApplicationException getException(){
        ApplicationException exception = new ApplicationException(this.code, this.msg);
        return exception;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
