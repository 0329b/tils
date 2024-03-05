package com.tils.service.impl;

import com.tils.mapper.DeptMapper;
import com.tils.mapper.EmpMapper;
import com.tils.pojo.Dept;
import com.tils.service.DeptService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
        empMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用mapper层
        deptMapper.add(dept);
    }

    @Override
    public void updataDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        //调用mapper层方法
        deptMapper.updataDept(dept);
    }

    @Override
    public Dept selectByid(Integer id) {
        return deptMapper.select(id);
    }
}
