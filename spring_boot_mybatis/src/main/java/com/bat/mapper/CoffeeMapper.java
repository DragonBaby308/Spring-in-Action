package com.bat.mapper;

import com.bat.entity.Coffee;
import org.apache.ibatis.annotations.*;

//使用@Mapper进行ORM，另一种方式是使用XML
@Mapper
public interface CoffeeMapper {
    @Insert("INSERT INTO COFFEE(NAME,PRICE,CREATE_TIME,UPDATE_TIME)" +
            " VALUES(#{name},#{price},NOW(),NOW())")
    //自增主键
    @Options(useGeneratedKeys = true)
    int save(Coffee coffee);

    @Select("SELECT * FROM COFFEE WHERE ID = #{id}")
    //返回
    @Results({
            @Result(id = true, column = "ID", property = "id"),
            @Result(column = "CREATE_TIME", property = "createdTime")
    })
    Coffee findById(Long id);
}
