package org.lanqiao.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect //当前是一个切面类
@Component
public class MyAspect {
    @Before(value = "myPointCut()")
    public void myTranction(){
        System.out.println("事务相关操作.......");
    }
    @After("execution(* *..UserService.doSome(..))")
    public void logRecord(){

        System.out.println("日志相关操作.......");
    }
    @AfterReturning(value = "myPointCut()",returning = "resulet")
    public void returnAdvice(Object resulet){
        System.out.println("返回通知执行.......");
        System.out.println(resulet);
    }
    @AfterThrowing(pointcut = "execution(* *..UserService.doSome(..))",throwing = "e")

    public void throwAdvice(ArithmeticException e){
        System.out.println("异常通知执行.......");
        System.out.println(e.getMessage());
    }
    @Around(value = "myPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知前.........");
        Object obj = pjp.proceed();
        System.out.println(obj);
        System.out.println("环绕通知后.........");
        return obj;
    }
    @Pointcut( "execution(* *..UserService.doSome(..))")
    private void myPointCut(){

    }
}
