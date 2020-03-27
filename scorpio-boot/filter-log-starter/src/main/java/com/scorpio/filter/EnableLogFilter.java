package com.scorpio.filter;


import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Import(LogFilterAutoConfiguration.class)
@Import(EnableLogFilterimportSelector.class)  //引入LogFilterAutoConfiguration配置类
public @interface EnableLogFilter {

}
