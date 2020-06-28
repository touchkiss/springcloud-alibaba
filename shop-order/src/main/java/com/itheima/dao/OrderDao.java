package com.itheima.dao;

import com.itheima.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2020/06/28 15:02
 *
 * @author Touchkiss
 */
public interface OrderDao extends JpaRepository<Order,Integer> {
}
