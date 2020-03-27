package com.scorpio.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Response基类
 */
public class Response<T> extends BaseDto {
    /**
     * 错误码及错误信息
     */
    private Status status = new Status();

    /**
     * 数据承载字段
     */
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private T data;

    /**
     * 分页数据
     */
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Page page;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
