package com.tils.controller;

import com.tils.anno.Log;
import com.tils.pojo.Dept;
import com.tils.pojo.Result;
import com.tils.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询部门全部信息
     */
    @GetMapping
    public Result list() {
        log.info("查询部门所有信息");
        //调用service层方法
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @Log
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        deptService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectByid( @PathVariable Integer id){
        Dept d= deptService.selectByid(id);
        return  Result.success(d);
    }

    /**
     * 增加部门
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        //调用service层方法
        deptService.add(dept);
        return Result.success();
    }
    /**
     * 部门名称修改
     */
    @Log
    @PutMapping
    public Result updataDept(@RequestBody Dept dept){
        log.info("修改功能");
        //调用service层方法
        deptService.updataDept(dept);
        return Result.success();
    }
}
