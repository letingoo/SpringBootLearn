package lesson.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lesson.annotation.Cache;
import lesson.entity.Item;
import lesson.redis.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
@Aspect
public class CacheAspect {

    @Autowired
    private RedisCache redisCache;

    @Pointcut("execution(public * lesson.mapper.*.get*(..))")
    public void pointcutMethod() {}


    @Around("pointcutMethod()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        String argsSinguare = "";
        if (args != null && args.length > 0) {
            for (Object arg : args)
                argsSinguare += arg;
        }

        Class targetClass = joinPoint.getTarget().getClass();
        Method[] methods = targetClass.getMethods();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Class returnClass = methodSignature.getReturnType();
        Cache cache = method.getAnnotation(Cache.class);


        String className = joinPoint.getTarget().toString().split("@")[0];
        String methodName = joinPoint.getSignature().getName();
        String redisKey = className + ":" + methodName + "." + argsSinguare;
        String json = redisCache.getDataFromRedis(redisKey);
        if (json != null) {

            return JSON.parseObject(json, returnClass);
        }

        Object returnObj = null;
        try {
            returnObj = joinPoint.proceed();
            redisCache.setDataToRedis(redisKey, returnObj);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return returnObj;
    }

}
