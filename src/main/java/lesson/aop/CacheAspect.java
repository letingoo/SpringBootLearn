package lesson.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CacheAspect {


    @Pointcut("@annotation(lesson.annotation.Cache)")
    public void pointcutMethod() {}


    public Object around(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();

        String argsSinguare = "";
        if (args != null && args.length > 0) {
            for (Object arg : args)
                argsSinguare += arg;
        }

        String className = joinPoint.getTarget().toString().split("@")[0];

        String methodName = joinPoint.getSignature().getName();

        String redisKey = className + ":" + methodName + "." + argsSinguare;
    }

}
