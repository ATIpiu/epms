package com.epms.utils.result;

public enum ResultCodeEnum {
    SUCCESS(true,20000,"成功"),
    UNKNOW_REASON(false,20001,"未知错误"),
    BAD_SQL_GRAMMER(false,21001,"sql语法错误"),
    JSON_PARSE_ERROR(false,21002,"json解析异常"),
    PARAM_ERROR(false,21003,"参数不正确"),
    FILE_UPLOAD_ERROR(false,21004,"文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false,21005,"Excel数据导入错误"),
    ERROR_AUTH_CODE(false,21006,"验证码错误!"),
    ERROR_NOT_EXISTS_USER(false,21007,"用户不存在!"),
    ERROR_PASSWORD(false,21008,"密码错误,请重新输入!"),
    SUCCESS_LOGIN(true,20000,"登陆成功!"),
    SUCCESS_REGISTER(true,20000,"注册成功!"),
    ERROR_USERNAME_EXIST(true,21009,"用户名已存在"),
    ERROR_NEED_REASON(false,21011,"驳回请输入修改意见"),
    ERROR_PERMISSION(false,21010,"访问权限错误");

    private Boolean status; //响应是否成功
    private Integer code; //返回码
    private String message; //返回消息

    ResultCodeEnum(Boolean status, Integer code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
