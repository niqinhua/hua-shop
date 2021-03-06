package com.hua.shop.pms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@MapperScan("com.hua.shop.pms.dao")
public class ShopPmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopPmsApplication.class, args);
    }

}
