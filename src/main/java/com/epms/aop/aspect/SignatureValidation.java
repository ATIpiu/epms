package com.epms.aop.aspect;

import com.epms.utils.exception.SignatureException;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Aspect
@Component
public class SignatureValidation {
    /**
     * 时间戳请求最小限制(30s)
     * 设置的越小，安全系数越高，但是要注意一定的容错性
     */
    private static final long MAX_REQUEST = 30 * 1000L;
    /**
     * 秘钥
     */
    private static final String SECRET= "epms";


    /**
     * 开始验签    @Pointcut("execution(* com.epms.service.impl.*(..))")
     */
    @Before("execution(* com.epms.webController.*.*(..))")
    public void doBasicProfiling() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        String token = request.getHeader("token");
        String timestamp = request.getHeader("timestamp");
        if(token==null)
            token=request.getParameter("token");
        if(timestamp==null)
            timestamp=request.getParameter("timestamp");
        System.out.println(token+":"+timestamp);
        try {
            Boolean check = checkToken(token, timestamp);
            if (!check) {
                // 自定义异常抛出（开发者自行换成自己的即可）
                throw new SignatureException("签名验证错误");
            }
        } catch (Throwable throwable) {
            // 自定义异常抛出（开发者自行换成自己的即可）
            throw new SignatureException("签名验证错误");
        }
    }

    /**
     * 校验token
     *
     * @param token     签名
     * @param timestamp 时间戳
     * @return 校验结果
     */
    private Boolean checkToken(String token, String timestamp) {
        if (StringUtils.isAnyBlank(token, timestamp)) {
            return false;
        }
        long now = System.currentTimeMillis();
        long time = Long.parseLong(timestamp);
        if (now - time > MAX_REQUEST) {
            return false;
        }
        String crypt = DigestUtils.md5Hex(SECRET+ timestamp);
        return StringUtils.equals(crypt, token);
    }
}
