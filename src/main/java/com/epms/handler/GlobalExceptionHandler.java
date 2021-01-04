//package com.epms.handler;
//
//import com.epms.utils.exception.SignatureException;
//import com.epms.utils.result.Result;
//import com.epms.utils.result.ResultCodeEnum;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(value = RuntimeException.class)
//    @ResponseBody
//    public
//    Result exceptionHandler(SignatureException s) {
//        System.err.println(s.getMessage());
//        return Result.error(ResultCodeEnum.ERROR_PERMISSION);
//    }
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public
//    Result exceptionHandler(Exception s) {
//        System.err.println(s.toString());
//        return Result.error().message(s.toString());
//    }
//
//}