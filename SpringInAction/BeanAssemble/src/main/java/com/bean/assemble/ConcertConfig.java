package com.bean.assemble;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by zhuxinquan on 17-4-19.
 */
@Configuration
@EnableAspectJAutoProxy
//@ComponentScan
public class ConcertConfig {
    @Bean
    public Audience audience(){
        return new Audience();
    }
    @Bean
    public PerformanceImp performance(){
        return new PerformanceImp();
    }
    @Bean
    public EncoreableIntroducer encoreableIntroducer(){
        return new EncoreableIntroducer();
    }
}
