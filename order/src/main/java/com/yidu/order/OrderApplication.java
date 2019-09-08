package com.yidu.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrix
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {


    @LoadBalanced //开启负载均衡
    @Bean //向spring容器注册restTemplate对象
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
