package com.epms.utils.exception;

public class SignatureException extends RuntimeException {
    private String message;

    //构造函数
    public SignatureException(String message) {
        super(message);
        this.message = message;
    }

}

