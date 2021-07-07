package com.frkblacksea.customertrigger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class CustomerTriggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerTriggerApplication.class, args);
    }

}
