package com.scorpio.bean;


import com.scorpio.AdditionalRoutes;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

//@EnableAutoConfiguration
@Import(AdditionalRoutes.class)
@Configuration
public class RouteConfiguration {


    /**
     * 自定义路由器
     */
    @Bean
    public RouterFunction<ServerResponse> testFunRouterFunction(){
        RouterFunction<ServerResponse> route = RouterFunctions.route(
                //http://localhost:9527/tetsfun
                //请求路径为/testsfun的时候，直接返回200, 返回体是"hello";
                RequestPredicates.path("/tetsfun"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject("hello")));
                return route;
    }


    /**
     * 过滤器
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                /*.route("image_png", r -> r.path("/image/png")
                        .filters(f ->
                                f.addResponseHeader("X-TestHeader", "foobar"))
                        .uri("http://httpbin.org:80")
                )*/
                // http://localhost:9527/image/webp 会被转发成 http://httpbin.org/image/webp 获得的是一张图片
                .route(r -> r.path("/image/webp")
                        .filters(f ->
                                f.addResponseHeader("X-AnotherHeader", "baz"))
                        .uri("http://httpbin.org:80")
                ).build();
    }
}
