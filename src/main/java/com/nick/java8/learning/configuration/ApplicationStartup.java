package com.nick.java8.learning.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Created by nick on 2016/12/14.
 * @author nick
 */
@SpringBootApplication
public class ApplicationStartup {

    @Bean
    @Profile("test")
    public DataSource testDataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .build();
    }

    public static void main(String[] args){
        SpringApplication.run(ApplicationStartup.class, args);
    }

}
