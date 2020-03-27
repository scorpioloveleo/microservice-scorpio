package com.scorpio.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

/**
 * 定义 LogFilterRegistrationBean 用于将 LogFilter 过滤器封装成 Spring Bean ，具体代码
 * 如下：
 * publi
 */
public class LogFilterRegistrationBean extends FilterRegistrationBean<com.scorpio.filter.LogFilter> {

    public LogFilterRegistrationBean() {
        super();
        this.setFilter(new LogFilter());
        this.addUrlPatterns("/*");
        this.setName("LogFilter");
        this.setOrder(1);
    }
}
