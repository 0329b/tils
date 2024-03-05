package com.tils.service;

import com.tils.pojo.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 查询部门信息
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门信息
     * @return
     */
    void deleteById(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    void add(Dept dept);

    /**
     * 编辑部门
     * @param dept
     */
    void updataDept(Dept dept);

    Dept selectByid(Integer id);
}
