package com.hape.common.response;


import com.hape.common.enums.ResultEnum;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@ApiOperation("全局通用返回响应")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    private String code;
    private String message;
    private T data;

    public static R success() {
        return new R<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    public static R success(Object obj) {
        return new R<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), obj);
    }

    public static R success(String code, String msg, Object obj) {
        R<Object> result = new R<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
        if (!StringUtils.isEmpty(code)) {
            result.setCode(code);
        }
        if (!StringUtils.isEmpty(msg)) {
            result.setMessage(msg);
        }
        if (obj != null) {
            result.setData(obj);
        }
        return result;
    }

    public static R fail() {
        return new R<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage(), null);
    }


    public static R fail(String msg) {
        return create(ResultEnum.FAIL.getCode(), msg, null);
    }

    public static R fail(ResultEnum resultEnum) {
        return create(resultEnum.getCode(), resultEnum.getMessage(), null);
    }

    public static R fail(String code, String msg) {
        return create(code, msg, null);
    }

    public static R fail(String code, String msg, Object obj) {
        R<Object> result = new R<>(ResultEnum.FAIL.getCode(), ResultEnum.FAIL.getMessage(), null);
        if (!StringUtils.isEmpty(code)) {
            result.setCode(code);
        }
        if (!StringUtils.isEmpty(msg)) {
            result.setMessage(msg);
        }
        if (obj != null) {
            result.setData(obj);
        }
        return result;
    }


    public static R create(String code, String msg, String data) {
        return new R<>(code, msg, data);
    }

    public void setCodeAndMessage(ResultEnum resultEnum, T data) {
        code = resultEnum.getCode();
        message = resultEnum.getMessage();
        this.data = data;
    }

    public R<T> setCodeAndMessage(String code, String message, T data) {
        R<T> result = new R<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

}
