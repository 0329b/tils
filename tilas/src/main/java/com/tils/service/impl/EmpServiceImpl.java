package com.tils.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.bcel.internal.generic.LUSHR;
import com.tils.mapper.EmpMapper;
import com.tils.pojo.Emp;
import com.tils.pojo.PageBean;
import com.tils.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 原始方法
     * @param page
     * @param pageSize
     * @return
     */
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //获取总记录数
//        Long count = empMapper.count();
//        //获取分页数据列表
//        Integer start =(page-1)*pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//        //封装分页查询对象
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;
//    }
    /**
     * 插件方法
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,LocalDate end) {
        //设置分页拆线呢参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<Emp> empList = empMapper.selectAll(name,gender,begin,end);
        Page<Emp> p= (Page<Emp>) empList;
        //封装分页查询对象
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void queryByIds(Integer[] ids) {
        empMapper.queryByIds(ids);
    }

    /**
     * 添加
     * @param emp
     */
    @Override
    public void add(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp getEmp(Integer id) {
        return empMapper.getEmp(id);
    }

    /**
     * 修改员工数据
     * @param emp
     */
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    /**
     * 员工登录
     * @param emp
     */
    @Override
    public Emp login(Emp emp) {
        return empMapper.getLogin(emp);
    }
}
