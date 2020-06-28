package com.itheima.dao;

import com.itheima.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2020/06/28 14:20
 *
 * @author Touchkiss
 */
public interface ProductDao extends JpaRepository<Product, Integer> {
}
