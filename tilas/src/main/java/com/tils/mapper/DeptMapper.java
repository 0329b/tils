package com.tils.mapper;

import com.tils.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 查询所有信息
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();
    /**
     * 删除部门信息
     * @return
     */
    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);
    /**
     * 编辑部门
     * @param dept
     */
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void updataDept(Dept dept);

    @Select("select * from dept where id=#{id}")
    Dept select(Integer id);
}
