package com.tils.service;

import com.tils.pojo.Emp;
import com.tils.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void queryByIds(Integer[] ids);

    void add(Emp emp);

    Emp getEmp(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
