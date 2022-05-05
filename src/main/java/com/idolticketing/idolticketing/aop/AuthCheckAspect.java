package com.idolticketing.idolticketing.aop;

import com.idolticketing.idolticketing.SessionUtil;
import com.idolticketing.idolticketing.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Aspect
@Component
@Log4j2
@SuppressWarnings("unchecked")
public class AuthCheckAspect {
    @Autowired
    private UserService userService;


    @Before("@annotation(com.idolticketing.idolticketing.aop.UserLoginCheck)")
    public void UserLoginCheck(JoinPoint jp) throws Throwable {
        log.debug("AOP - User Login Check Started");
        Object[] signatureArgs = jp.getArgs();

        HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        String sessionUserId = SessionUtil.getLoginUserId(session);

        if (sessionUserId == null || !signatureArgs[1].equals(sessionUserId)) {
            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "NO_LOGIN") {};
        }
    }

}