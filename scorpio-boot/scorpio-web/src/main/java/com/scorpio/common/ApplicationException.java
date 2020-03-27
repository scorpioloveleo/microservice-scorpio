package com.scorpio.common;

import java.text.MessageFormat;

/**
 * 业务异常
 */
public class ApplicationException extends Exception{

    private Integer code;
    private String msg;

    public ApplicationException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public ApplicationException(IErrorCode errorCode, Object... args) {
        super(MessageFormat.format(errorCode.getMsg(), args));
        this.code = errorCode.getCode();
        this.msg = this.getMessage();
    }

    public ApplicationException(IErrorCode errorCode, Throwable cause) {
        super(cause);
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

    public ApplicationException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
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
