package com.xf.web.common.exception;


import com.xf.web.common.result.RestCode;

/**
 * @author David
 * @date 2019/10/29
 * @time 11:48
 */
public class BaseException extends RuntimeException {

    private int code;

    private Object data;


    public Object getData() {
        return data;
    }

    public int getCode() {
        return code;
    }

    public BaseException(RestCode restCode) {
        super(restCode.getMsg());
        this.code = restCode.getCode();
    }

    public BaseException(RestCode restCode, Object data) {
        super(restCode.getMsg());
        this.code = restCode.getCode();
        this.data = data;
    }

}
