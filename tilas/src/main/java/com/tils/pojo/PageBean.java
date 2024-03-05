package com.tils.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页查询
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {
    private Long total;   //总记录数
    private List rows;   //但前页数据列表

}
