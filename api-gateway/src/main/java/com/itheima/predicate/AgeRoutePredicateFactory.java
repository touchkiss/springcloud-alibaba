package com.itheima.predicate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created on 2020/06/29 15:08
 * 这是一个自定义的路由断言工厂，要求有两个
 * 1. 名称必须是 配置+RoutePredicateFactory
 * 2. 必须继承 AbstractRoutePredicateFactory<配置类>
 *
 * @author Touchkiss
 */
@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {
    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }

    /**
     * 读取配置文件中的参数值，赋值到配置类中的属性上
     *
     * @return
     */
    @Override
    public List<String> shortcutFieldOrder() {
        //这个位置的顺序必须跟配置文件中的值的顺序对应上
        return Arrays.asList("minAge", "maxAge");
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //接收前台穿进的参数
                String ageStr = serverWebExchange.getRequest().getQueryParams().getFirst("age");
                if (StringUtils.isNotBlank(ageStr)) {
                    int age = Integer.parseInt(ageStr);
                    if (age > config.getMinAge() && age < config.getMaxAge()) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    /**
     * 配置类
     * 用于接收配置文件中的参数
     */
    @Data
    @NoArgsConstructor
    public static class Config {
        private int minAge;
        private int maxAge;
    }
}
