package com.zjgsu.dto;

import java.io.Serializable;

/**
 *
 * @author chm 神魔法
 * @date 19-6-24 上午10:33
 */
public class ApiResult implements Serializable {
    private static final long serialVersionUID = 4690001891057693078L;
    private Integer code;
    private String message;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
