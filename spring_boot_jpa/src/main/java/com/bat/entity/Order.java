package com.bat.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @program: spring_cloud_in_action
 * @description: 订单实体，和咖啡是ManyToMany，通过t_order_coffee中间表关联
 * @author: DragonBaby308
 * @create: 2019-08-03 22:32
 * @version: 1.0
 **/
@Data
//toString时加上父类字段
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
//声明实体
@Entity
//和DB表关联
@Table(name = "T_ORDER")
public class Order extends BaseEntity implements Serializable {
    private String customer;
    //Coffe(menu)和Order是多对多
    @ManyToMany
    //通过中间表t_order_menu进行连接
    @JoinTable(name = "T_ORDER_COFFEE")
    private List<Coffee> items;
    //订单状态，枚举值
    @Enumerated
    private OrderState state;
}
