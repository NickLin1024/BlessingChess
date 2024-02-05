package com.example.blessingchess.exception;

import com.example.blessingchess.data.vo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器类
 *
 * @author LXY
 * @version 1.0
 * @since 2024-02-5
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理异常的方法
     *
     * @param e 捕获的异常对象
     * @return 处理异常的结果
     */
    @ExceptionHandler(Exception.class)	//指定可以捕获所有类型的异常进行处理
    public Result ex(Exception e){
        e.printStackTrace();	//打印堆栈中的异常信息

        //捕获到异常之后，响应一个标准的Result
        return Result.error(500,"操作失败,请联系管理员");
    }
}