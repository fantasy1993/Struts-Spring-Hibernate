package com.condation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.activation.DataSource;

/**
 * Created by zhuxinquan on 17-4-9.
 */

@Configuration
public class SayConfig {

    @Bean()
    @Profile("dev")
    public Interf devSay(){
        return new DevSay();
    }

    @Bean()
    @Profile("prod")
    public Interf prodSay(){
        return new ProdSay();
    }

}
