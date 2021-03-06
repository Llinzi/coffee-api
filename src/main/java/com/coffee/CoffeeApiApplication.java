package com.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableSwagger2  //开启swagger2
@MapperScan("com.coffee.mapper")
public class CoffeeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeApiApplication.class, args);
    }

}
