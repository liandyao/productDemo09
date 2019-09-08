package com.yidu.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

    /**
     * 新版（Spring Cloud 2.0 以上）的security默认启用了csrf检验，
     * 要在eurekaServer端配置security的csrf检验为false
     */
    @EnableWebSecurity
    static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            super.configure(http);//加这句是为了访问eureka控制台和/actuator时能做安全控制
            http.csrf().disable();
        }
    }


}
