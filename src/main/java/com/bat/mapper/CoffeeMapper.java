package com.bat.mapper;

import com.bat.entity.Coffee;
import com.bat.entity.CoffeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

public interface CoffeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    long countByExample(CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    int deleteByExample(CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    @Delete({
        "delete from coffee",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    @Insert({
        "insert into coffee (name, price, ",
        "create_time, update_time)",
        "values (#{name,jdbcType=VARCHAR}, #{price,jdbcType=BIGINT,typeHandler=com.bat.handler.MoneyTypeHandler}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="CALL IDENTITY()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Coffee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    int insertSelective(Coffee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    List<Coffee> selectByExampleWithRowbounds(CoffeeExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    List<Coffee> selectByExample(CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    @Select({
        "select",
        "id, name, price, create_time, update_time",
        "from coffee",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.bat.mapper.CoffeeMapper.BaseResultMap")
    Coffee selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    int updateByExampleSelective(@Param("record") Coffee record, @Param("example") CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    int updateByExample(@Param("record") Coffee record, @Param("example") CoffeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    int updateByPrimaryKeySelective(Coffee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coffee
     *
     * @mbg.generated Sun Aug 04 11:38:43 CST 2019
     */
    @Update({
        "update coffee",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=BIGINT,typeHandler=com.bat.handler.MoneyTypeHandler},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Coffee record);
}