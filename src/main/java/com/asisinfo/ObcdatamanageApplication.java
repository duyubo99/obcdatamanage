package com.asisinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ObcdatamanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObcdatamanageApplication.class, args);
    }
}
