package com.bean.assemble;


import org.aspectj.lang.annotation.*;

/**
 * Created by zhuxinquan on 17-4-19.
 */
@Aspect
public class Audience {
    @Pointcut("execution(* com.bean.assemble.PerfromanceInterface.perform())")
    public void performance(){}

    @Before("performance()")
    public void silenceCellPhones(){
        System.out.println("silenceCellPhones");
    }

    @Before("performance()")
    public void takeSeats(){
        System.out.println("takeSeats");
    }

    @AfterReturning("performance()")
    public void applause(){
        System.out.println("applause");
    }

    @AfterThrowing("performance()")
    public void demand(){
        System.out.println("demand");
    }
}
