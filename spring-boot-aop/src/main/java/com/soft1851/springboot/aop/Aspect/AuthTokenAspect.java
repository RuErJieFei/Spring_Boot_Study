package com.soft1851.springboot.aop.Aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.common.Result;
import com.soft1851.springboot.aop.common.ResultCode;
import com.soft1851.springboot.aop.mapper.SysUserMapper;
import com.soft1851.springboot.aop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ClassName AuthTokenAspect
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/4/13 3:40 下午
 * @Version 1.0
 **/
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    @Resource
    private UserService userService;

    @Resource
    private SysUserMapper mapper;

    /**
     * 配置加上自定义注解的为切点
     *
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }

//    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
//    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
//        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert sra != null;
//        HttpServletRequest request = sra.getRequest();
//        //获取请求头
//        String[] roleNames = authToken.role_name();
//        String id = request.getHeader("id");
////        if (roleNames.length <= 1) {
////            //只需要认证
////
////            //id 为空 证明用户没登录
////            if (id != null) {
////                return pjp.proceed();
////            }
////            return "请先登录";
////        }
//        if (id == null) {
//            return ResultCode.getMessage("USER_LOGIN_FIRST");
//        } else {
//            String role = request.getHeader("role");
//            User user = userService.authentication(Integer.parseInt(id), role);
//            System.out.println(user);
//            for (String roleName : roleNames) {
//                if (roleName.equals(user.getRole())) {
//                    //身份匹配成功 调用目标方法
//                    log.info(user.getCanDo());
//                    return pjp.proceed();
//                }
//            }
//            return ResultCode.getMessage("USER_RIGHT_LACKING");
//        }
//    }

    /**
     * object是指controller方法返回的类型
     */
    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        // 取得注解中的role_name的值
        String[] roleNames = authToken.role_name();
        //没有role的值
        if (roleNames.length <= 1) {
            // 只需认证
            String token = request.getHeader("token");
            String id = request.getParameter("id");
            Map<String, Object> map = mapper.getUserById(id);
            System.out.println(map.get("role_name"));
            // 如果id为空， 证明用户没有登录
            if (token != null && roleNames[0].equals(map.get("role_name"))) {
                // 返回controller方法的值
                return pjp.proceed();
            }
            return Result.success(ResultCode.PERMISSION_NO_ACCESS);
        } else {
            // 请求头中取出role，验证身份
            String id = request.getParameter("id");
            Map<String, Object> map = mapper.getUserById(id);
            for (String roleName : roleNames) {
                if (roleName.equals(map.get("role_name"))) {
                    // 身份匹配成功
                    return pjp.proceed();
                }
            }
            return Result.success(ResultCode.PERMISSION_NO_ACCESS);
        }
    }
}
