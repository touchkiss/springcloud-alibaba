package com.itheima.dao;

import com.itheima.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 2020/06/28 14:20
 *
 * @author Touchkiss
 */
public interface UserDao extends JpaRepository<User, Integer> {
}
