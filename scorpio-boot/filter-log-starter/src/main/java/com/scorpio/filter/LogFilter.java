package com.scorpio.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 用于日志拦截
 */
public class LogFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(LogFilter. class) ;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("开始 LogFilter 初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // request 中获取到访问的地址，并在控制台中打印出来
        HttpServletRequest request = (HttpServletRequest) servletRequest ;
        logger.info ("uri {} is working . ", request.getRequestURI()) ;
        filterChain.doFilter(servletRequest , servletResponse) ;
    }

    @Override
    public void destroy() {
        logger.info("开始销毁 LogFilter ...");
    }
}
