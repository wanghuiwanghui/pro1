package com.wh.pro1.dao;

import com.wh.pro1.entity.Area;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;

/**
 * @author WangHui
 * @since 2019/1/25
 */
@Mapper
public interface AreaDao {
    /**
     * findOne
     *
     * @param id id
     * @return area
     */
    Area findOne(@Param("id") Long id);

    /**
     * update
     *
     * @param area area
     * @return int
     */
    @Update("update area set name=#{area.name},priority=#{area.priority},updated_at=now())")
    int update(@Param("area") Area area);

    /**
     * delete
     *
     * @param id id
     */
    @Delete("delete from area where id = #{id}")
    int delete(@Param("id") Long id);

    /**
     * save
     *
     * @param area area
     * @return count
     */
    @Insert("insert into area(name,priority,created_at,updated_at) value (#{area.name},#{area.priority},now(),now())")
    @SelectKey(before = false, keyProperty = "area.id", resultType = Long.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
    int save(@Param("area") Area area);

    /**
     * all
     *
     * @return all
     */
    @Select("select * from area ")
    @ResultMap("AreaResultMap")
    List<Area> findAll();

}
