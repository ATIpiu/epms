package com.epms.utils.result;


import java.util.HashMap;
import java.util.Map;

public class Result {

    private Boolean success;

    private Integer code;

    private String message;

    private void setSuccess(Boolean success) {
        this.success = success;
    }


    private void setCode(Integer code) {
        this.code = code;
    }


    private void setMessage(String message) {
        this.message = message;
    }

    private void setData(Map<String, Object> map) {
    }

    private Map<String, Object> data = new HashMap<String, Object>();

    private Result() {
    }

    public static Result ok() {
        Result r = new Result();
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setSuccess(ResultCodeEnum.SUCCESS.getStatus());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static Result error() {
        Result r = new Result();
        r.setCode(ResultCodeEnum.UNKNOW_REASON.getCode());
        r.setSuccess(ResultCodeEnum.UNKNOW_REASON.getStatus());
        r.setMessage(ResultCodeEnum.UNKNOW_REASON.getMessage());
        return r;
    }

    public static Result ok(ResultCodeEnum codeEnum) {
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }

    public static Result error(ResultCodeEnum codeEnum) {
        Result r = new Result();
        r.setCode(codeEnum.getCode());
        r.setSuccess(codeEnum.getStatus());
        r.setMessage(codeEnum.getMessage());
        return r;
    }

    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }


    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result message(String message) {
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code) {
        this.setCode(code);
        return this;
    }

    public Result success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

}


