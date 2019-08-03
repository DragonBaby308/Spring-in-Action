package com.bat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @program: spring_cloud_in_action
 * @description: JPA操作H2数据库启动类
 * @author: DragonBaby308
 * @create: 2019-08-03 22:30
 * @version: 1.0
 **/
@SpringBootApplication
public class JPAManipulateH2Application {
    public static void main(String[] args) {
        SpringApplication.run(JPAManipulateH2Application.class, args);
    }
}
