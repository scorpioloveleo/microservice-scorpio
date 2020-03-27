package com.scorpio.common;

import com.scorpio.common.IErrorCode;

public enum SysError implements IErrorCode {

	/**
	 * 未知错误
	 */
    UNKNOWN(1, "Unknown error"),
    /**
     * 服务器维护中
     */
    MAINTENANCE(2, "The server has been maintained"),
    /**
     * 参数错误
     */
    PARAMETER_ERR(3, "Parameter error"),
    /**
     * 系统忙
     */
    BUSY(4, "System is busy"),
    /**
     * TOKEN失效
     */
    TOKEN_INVALIDATE(5, "Token invalidate"),
    /**
     * 无操作权限
     */
    NO_PERMISSION(6, "No permission"),
    /**
     * 无相关配置
     */
    NO_CONFIG(7, "No config"),
    /**
     * 系统日期异常
     */
    SYSTEM_DATE_EMPTY(8, "System date empty"),
    /**
     * 返回体为空
     */
    RESPONSE_BODY_EMPTY(9, "Response body empty"),
    /**
     * 反序列化失败
     */
    RESERIALIZER_ERROR(10, "Reserializer error"),
    /**
     * 系统不支持该交易类型
     */
    UNSUPPORTED_TRANSACTION_TYPE(11, "Unsupported transaction type"),
    /**
     * 发送短信失败
     */
    SMS_MASSAGE_ERROR(12, "Send sms error"),
    /**
     * 系统错误
     */
    SYSTEM_ERROR(13, "System error, {0}"),


    ENUM_ERROR(14, "ENUM error"),

    REDIS_GET_LOCK_EXCEPTION(15, "Redis get lock exception"),

    EVENT_MSG_EMPTY(16, "event msg empty"),

    EVENT_MSGID_EMPTY(17, "event msgid empty"),

    Duplicate_REQUEST(18, "duplicate request"),
    ;


    SysError(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 系统编号16
     * @return
     */
    public Integer getSys() {
        return null;
    }

    /**
     * 模块编号01
     * @return
     */
    public Integer getModule() {
        return null;
    }

    public Integer getCode() { return this.code;
    }

    public String getMsg() {
        return msg;
    }

    private Integer code;
    private String msg;
}
