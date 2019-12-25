package com.coffee.config;

import com.google.common.base.Predicates;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @ClassName : Swagger2Config
 * @Description : swagger2文档接口配置
 * @Author : 王显成
 * @Date: 2019-12-23 11:26
 */
@Configuration
public class Swagger2Config {

    /**
     * api信息
     *
     * @param name        标题
     * @param description 描述
     * @param version     版本
     * @return
     */
    private ApiInfo apiInfo(String name, String description, String version) {
        return new ApiInfoBuilder().title(name).description(description).version(version).build();
    }

    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("咖啡后台管理员 API 文档","admin-api","1.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.coffee.controller.admin"))//扫码包下的接口类
                .paths(PathSelectors.any())
                .build()
                .groupName("管理员接口文档"); //配置多个路径，不加这个会报错

    }

    // http://ip:端口/swagger-ui.html

    @Bean
    public Docket usersApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo("用户接口文档","users-api","1.0"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.coffee.controller.users"))//扫码包下的接口类
                .paths(PathSelectors.any())
                .build()
                .groupName("用户接口文档");
    }
}
