package com.itheima.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Created on 2020/06/29 15:42
 * 自定义的全局过滤器 统一鉴权
 * 要求：必须实现GlobalFilter、 Ordered接口 并且实现里面的两个方法
 *
 * @author Touchkiss
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {
    //过滤器逻辑
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //统一鉴权逻辑
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (!StringUtils.equals("admin",token)){
            //认证失败
            log.info("认证失败");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    //用来标志当前过滤器的优先级，值越小，优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
