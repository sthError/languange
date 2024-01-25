package com.hape.common.exception;

import com.hape.common.enums.ResultEnum;

/**
 * @Author: hape
 * @Date: 2023/2/20 15:48
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 9163022146279472627L;
    private String code;
    private String message;

    private static final String errCode = "0";

    public BusinessException() {
        super();
    }

    public BusinessException(String msg) {
        super(msg);
        this.code = errCode;
    }

    public BusinessException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
