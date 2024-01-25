package com.hape.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        // 打印异常堆栈信息
        ex.printStackTrace();
        // 返回通用的错误响应
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("system error");
    }
}
