package com.bat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

/**
 * @program: spring_cloud_in_action
 * @description: 咖啡实体，包含一个joda-money类型的字段，需要进行TypeHandler
 * @author: DragonBaby308
 * @create: 2019-08-04 08:28
 * @version: 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee {
    private Long id;
    private String name;
    //joda-money类型 金额，需要通过TypeHandler进行转换
    private Money price;
    private Date createdTime;
    private Date updatedTime;
}

