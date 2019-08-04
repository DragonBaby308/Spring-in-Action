package com.bat.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program: spring_cloud_in_action
 * @description: 用于Money和Long相互转换的TypeHandler，处理joda-money中的CNY人民币
 * @author: DragonBaby308
 * @create: 2019-08-04 08:33
 * @version: 1.0
 **/

//所有TypeHandler都要继承BaseTypeHandler<T>，其中T是你要处理的数据类型
public class MoneyTypeHandler extends BaseTypeHandler<Money> {
    //    将Money类型转换为Long类型
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Money money, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i, money.getAmountMinorLong());
    }

    //    将Long类型转换为Money类型
    @Override
    public Money getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return toMoney(resultSet.getLong(s));
    }

    @Override
    public Money getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return toMoney(resultSet.getLong(i));
    }

    @Override
    public Money getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return toMoney(callableStatement.getLong(i));
    }

    //Long类型转Money类型
    private Money toMoney(Long value) {
        //生成joda-money
        return Money.of(CurrencyUnit.of("CNY"),
                value / 100.0);
    }
}
