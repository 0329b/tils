package com.tils.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;  //响应码 1代表成功·1，0代表失败
    private String msg;  //响应信息，描述字符串
    private Object data;  //返回数据

    //增删改查 成功相应
    public static  Result success(){
        return new Result(1,"success",null);
    }
    //查询成功
    public static Result success(Object data){
        return new Result(1,"success", data);
    }
    //相应失败
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
