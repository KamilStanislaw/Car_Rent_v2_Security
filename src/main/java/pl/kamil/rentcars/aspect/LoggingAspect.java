package pl.kamil.rentcars.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());


    // setup Pointcut declarations; to not repeat in Advices
    @Pointcut("execution(* com.kamil.rentcars.controller.*.*(..))") // any - class, method, num of args
    private void forControllerPackage() {}

    @Pointcut("execution(* com.kamil.rentcars.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* com.kamil.rentcars.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}


    // add @Before Advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        // display called method
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("=====> in @Before: calling method: " + theMethod);

        // get the args
        Object[] args = joinPoint.getArgs();

        // loop trough  and display args
        for (Object tempArg : args) {
            logger.info("=====> argument: " + tempArg);
        }
    }


    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint joinPoint, Object theResult) {

        // display method
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info("=====> in @AfterReturning: from method: " + theMethod);

        // display data returned
        logger.info("=====> result: " + theResult);

    }

}
