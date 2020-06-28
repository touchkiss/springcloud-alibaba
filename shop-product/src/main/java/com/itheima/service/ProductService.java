package com.itheima.service;

import com.itheima.domain.Product;

/**
 * Created on 2020/06/28 14:20
 *
 * @author Touchkiss
 */
public interface ProductService {
    //根据pid查询商品信息
    Product findByPid(Integer pid);
}
