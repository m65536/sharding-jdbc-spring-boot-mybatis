package com.mo.test.annotation;

import io.shardingjdbc.core.api.HintManager;
import io.shardingjdbc.core.hint.HintManagerHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author MoXingwang on 2018/4/29.
 */
@Aspect
@Component
@Order(value = Integer.MAX_VALUE)
public class ShardingHintAop {
    @Pointcut("@annotation(ShardingHint)")
    public void hint(){

    }

    @Before("hint()")
    public void doHint(JoinPoint Point){
        HintManager hintManager = HintManager.getInstance();
        hintManager.setMasterRouteOnly();
    }

    @After("hint()")
    public void clear(JoinPoint Point) {
        HintManagerHolder.clear();
    }


}
