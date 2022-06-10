package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> CommonResult<T> success(String msg,T data) {
        return new CommonResult<T>(200, msg, data);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(200, "操作成功", data);
    }

    public static <T> CommonResult<T> error() {
        return new CommonResult<T>(500, "操作失败");
    }
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
