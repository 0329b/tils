package com.tils.mapper;

import com.tils.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /**
     * 员工查询(插件)
     * @return
     */
//    @Select("select * from emp")
    List<Emp> selectAll(String name, Short gender, LocalDate begin,LocalDate end);

    /**
     * 查询总记录数
     */
    @Select("select count(*) from emp")
    public Long count();

    /**
     * 分页查询
     */
    @Select("select * from emp limit #{start},#{pageSize}")
    public List<Emp> page(Integer start, Integer pageSize);

  void queryByIds(Integer[] ids);

    void add(Emp emp);

    /**
     * 获取某个员工信息
     * @param id
     * @return
     */
    @Select("select * from emp where id=#{id}")
    Emp getEmp(Integer id);

    @Update("update emp set username=#{username},name=#{name},gender=#{gender},image=#{image},job=#{job}," +
            "entrydate=#{entrydate},dept_id=#{deptId},update_time=#{updateTime} where id=#{id}")
    void update(Emp emp);

    /**
     * 登录
     * @param emp
     * @return
     */
    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp getLogin(Emp emp);

    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteById(Integer deptId);
}
