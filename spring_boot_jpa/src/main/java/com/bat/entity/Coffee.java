package com.bat.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.money.Money;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: spring_cloud_in_action
 * @description: 咖啡实体，和订单是ManyToMany，通过t_order_coffee中间表关联
 * @author: DragonBaby308
 * @create: 2019-08-03 22:33
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
@Table(name = "T_MENU")
public class Coffee extends BaseEntity implements Serializable {

    private String name;

    //joda-money的Money类型，通过jadira.usertype和人民币的分进行映射，100.34存储为10034
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyMinorAmount",
        parameters = {@org.hibernate.annotations.Parameter(name = "currencyCode", value = "CNY")})
    private Money price;
}
