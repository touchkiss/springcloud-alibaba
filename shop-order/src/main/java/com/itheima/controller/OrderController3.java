package com.itheima.controller;

import com.itheima.dao.ProductService;
import com.itheima.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020/06/28 15:51
 *
 * @author Touchkiss
 */
@RestController
@Slf4j
public class OrderController3 {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    //测试高并发
    @RequestMapping("/order/message1")
    public String message1() {
        return "message1";
    }

    //测试高并发
    @RequestMapping("/order/message2")
    public String message2() {
        return "message2";
    }
}
