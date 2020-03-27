package com.scorpio

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.filters
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class AdditionalRoutes {

    @Bean
    open fun additionalRouteLocator(builder: RouteLocatorBuilder): RouteLocator = builder.routes {
        //路由器
        route(id = "test-kotlin") {
            host("kotlin.abc.org") and path("/image/png")
           //过滤器
            filters {
                addResponseHeader("X-TestHeader", "foobar")
            }
            uri("http://httpbin.org:80")
        }
    }

}