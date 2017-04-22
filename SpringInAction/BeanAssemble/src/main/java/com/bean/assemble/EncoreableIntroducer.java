package com.bean.assemble;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by zhuxinquan on 17-4-21.
 */
@Aspect
public class EncoreableIntroducer {
    @DeclareParents(value = "com.bean.assemble.PerformanceImp",
    defaultImpl = com.bean.assemble.EncoreableImp.class)
    public static EncoreableInterface encoreableInterface;
}
