package com.tils.controller;

import com.tils.anno.Log;
import com.tils.pojo.Emp;
import com.tils.pojo.PageBean;
import com.tils.pojo.Result;
import com.tils.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize, String name, Short gender,
                       @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd") LocalDate end) {

        PageBean pageBeanList = (PageBean) empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBeanList);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result queryList(@PathVariable Integer ids[]) {
        empService.queryByIds(ids);
        return Result.success();
    }

    /**
     * 添加员工
     */
    @Log
    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        empService.add(emp);
        return Result.success();
    }

    /**
     * 获取某个员工信息
     */
    @GetMapping("/{id}")
    public Result getEmp(@PathVariable Integer id) {
        Emp b = empService.getEmp(id);
        return Result.success(b);
    }

    /**
     * 修改员工数据
     */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
}
