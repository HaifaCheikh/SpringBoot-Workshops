package org.example.springproject.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class ServiceAspect {

    @Pointcut("execution(* org.example.springproject.Services.*.*(..))")
    public void servicePointcut() {}

    @Before("servicePointcut()")
    public void beforeAdvice(JoinPoint joinPoint) {
        log.info("[BEFORE] Méthode appelée : {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        log.info("[BEFORE] Arguments : {}",
                Arrays.toString(joinPoint.getArgs()));
    }

    @After("servicePointcut()")
    public void afterAdvice(JoinPoint joinPoint) {
        log.info("[AFTER] Méthode terminée : {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "servicePointcut()",
            returning = "result"
    )
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        log.info("[AFTER RETURNING] Méthode : {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        log.info("[AFTER RETURNING] Résultat retourné : {}", result);
    }

    @AfterThrowing(
            pointcut = "servicePointcut()",
            throwing = "exception"
    )
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception exception) {
        log.error("[AFTER THROWING] Exception dans : {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        log.error("[AFTER THROWING] Message : {}", exception.getMessage());
    }

    @Around("servicePointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[AROUND] Début d'exécution : {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());

        long startTime = System.currentTimeMillis();

        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("[AROUND] Exception interceptée : {}", e.getMessage());
            throw e;
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        log.info("[AROUND] Fin d'exécution : {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        log.info("[AROUND] Temps d'exécution : {} ms", duration);

        return result;
    }
}