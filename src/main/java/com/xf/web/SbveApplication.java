package com.xf.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({
"com.xf.web.mapper"
})
public class SbveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbveApplication.class, args);
    }

}
