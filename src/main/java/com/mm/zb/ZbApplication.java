package com.mm.zb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@ServletComponentScan
@EnableEurekaClient
public class ZbApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZbApplication.class, args);
    }

}
