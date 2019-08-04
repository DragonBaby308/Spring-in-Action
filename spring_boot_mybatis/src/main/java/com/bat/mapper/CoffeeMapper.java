package com.bat.mapper;

import com.bat.entity.Coffee;
import org.apache.ibatis.annotations.*;

//使用@Mapper进行ORM，另一种方式是使用XML
@Mapper
public interface CoffeeMapper {
    @Insert("insert into coffee(id,name,price,create_time,update_time)" +
            " values(#{id},#{name},#{price},now(),now())")
    //自增主键
    @Options(useGeneratedKeys = true)
    int save(Coffee coffee);

    @Select("select * from coffee where id = #{id}")
    //返回
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createdTime")
    })
    Coffee findById(Long id);
}
