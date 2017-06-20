package com.nick.soa.startup;

import com.nick.soa.threadpool.GoodsThreadContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ningyang on 2017/6/20.
 */
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = "com.nick.soa")
@EnableAsync
public class ApplicationStartup extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(ApplicationStartup.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStartup.class, args);
    }

    @Bean
    public GoodsThreadContext goodsThreadContext(){
        return new GoodsThreadContext(4, 20, 3000, 20);
    }
}
