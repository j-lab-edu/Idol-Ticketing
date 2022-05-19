package com.idolticketing.idolticketing.aop;

import com.idolticketing.idolticketing.SessionUtil;
import com.idolticketing.idolticketing.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
@Log4j2
@SuppressWarnings("unchecked")
public class AuthCheckAspect {
    @Autowired
    private UserService userService;


    // @Before("execution(* com.idolticketing.idolticketing.aop.LoginCheck()), && args(loginCheck)")
    // @Around("@annotation(com.idolticketing.idolticketing.aop.LoginCheck) && @annotation(com.idolticketing.idolticketing.aop.LoginCheck)")
    @Around("@annotation(com.idolticketing.idolticketing.aop.LoginCheck) && @ annotation(loginCheck)")
    public Object UserLoginCheck(ProceedingJoinPoint jp, LoginCheck loginCheck) throws Throwable {
        log.debug("AOP - User Login Check Started");
        Object[] signatureArgs = jp.getArgs();
        int idIndex = 0;
        String userId= null;

        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        String sessionUserId = SessionUtil.getLoginUserId(session);

        String userType = loginCheck.type().toString();
        switch (userType) {
            case "ADMIN": {
                userId = SessionUtil.getLoginAdminId(session);
                break;
            }
            case "USER": {
                userId = SessionUtil.getLoginUserId(session);
                break;
            }
        }

        if (sessionUserId == null) {
            throw new HttpStatusCodeException(HttpStatus.UNAUTHORIZED, "NO_LOGIN") {
            };
        }
//        if(!signatureArgs[0].equals(sessionUserId)){
//            throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST, "본인 소유가 아니다.") {
//            };
//        }

//        Class<?> test = signatureArgs[0].getClass();
//        if (BookDTO.class.equals(test)) {
//            if (!sessionUserId.equals(((BookDTO) signatureArgs[0]).getUserId())) {
//                throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST, "본인 소유가 아니다.") {
//                };
//            } else if (UserDTO.class.equals(test)) {
//                if (!sessionUserId.equals(((UserDTO) signatureArgs[0]).getUserId())) {
//                    throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST, "본인 소유가 아니다.") {
//                    };
//                }
//            } else if (ContentDTO.class.equals(test)) {
//                if (!sessionUserId.equals(((ContentDTO) signatureArgs[0]).getUserId())) {
//                    throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST, "본인 소유가 아니다.") {
//                    };
//                }
//            } else if (HelpDTO.class.equals(test)) {
//                if (!sessionUserId.equals(((HelpDTO) signatureArgs[0]).getUserId())) {
//                    throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST, "본인 소유가 아니다.") {
//                    };
//                }
//            }
//        }

        if(jp.getArgs()!=null)
            signatureArgs[idIndex] = userId;
        return jp.proceed(signatureArgs);
    }

}