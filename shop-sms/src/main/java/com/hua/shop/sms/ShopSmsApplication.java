package com.hua.shop.sms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@MapperScan("com.hua.shop.sms.dao")
public class ShopSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopSmsApplication.class, args);
    }

}
