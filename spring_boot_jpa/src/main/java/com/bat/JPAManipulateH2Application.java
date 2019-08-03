package com.bat;

import com.bat.entity.Coffee;
import com.bat.entity.Order;
import com.bat.entity.OrderState;
import com.bat.repository.CoffeeRepository;
import com.bat.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * @program: spring_cloud_in_action
 * @description: JPA操作H2数据库启动类
 * @author: DragonBaby308
 * @create: 2019-08-03 22:30
 * @version: 1.0
 **/
@Slf4j
@SpringBootApplication
//JPA
@EnableJpaRepositories
//事务管理器
@EnableTransactionManagement
//继承ApplicationRunner，在run()中定义运行时要执行的方法
public class JPAManipulateH2Application implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(JPAManipulateH2Application.class, args);
    }

    @Override
    @Transactional
    //以事务的模式运行，保证操作具有原子性
    public void run(ApplicationArguments args) throws Exception {
        initOrders();
        findOrders();
    }

    //生成订单
    private void initOrders() {
        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0) )
                .build();   //拿铁
        coffeeRepository.save(latte);   //保存
        log.info("Coffee: {}", latte);
        Order order = Order.builder().customer("DragonBaby")
                .items(Collections.singletonList(latte))
                .state(OrderState.INIT)
                .build();
        orderRepository.save(order);
        log.info("Order: {}", order);
    }

    //查找前3个订单
    private void findOrders() {
        List<Order> orders =  orderRepository.findByCustomerOrderById("DragonBaby");
        orders.forEach(order -> log.info("DragonBaby的订单：{}", order));
    }
}
