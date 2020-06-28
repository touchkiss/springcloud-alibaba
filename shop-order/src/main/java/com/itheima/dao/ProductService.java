package com.itheima.dao;

import com.itheima.domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created on 2020/06/28 15:44
 * <p>
 * Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
 *
 * @author Touchkiss
 */
//value用来指定调用nacos下的哪个微服务
@FeignClient(value = "service-product")
public interface ProductService {
    //@FeignClient的value加上RequestMapping的value就是完整的请求路径
    @RequestMapping("/product/{pid}")
    Product findByPid(@PathVariable("pid") Integer pid);
}
