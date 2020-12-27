package com.epms.handler;

import com.epms.utils.exception.SignatureException;
import com.epms.utils.result.Result;
import com.epms.utils.result.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public
    Result exceptionHandler(SignatureException s) {
        return Result.error(ResultCodeEnum.ERROR_PERMISSION);
    }
}