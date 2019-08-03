package com.bat.repository;

import com.bat.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //findBy...OrderBy...
    //通过顾客名称查找，按ID排序
    List<Order> findByCustomerOrderById(String customer);
}
