package com.hape.common.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@ApiOperation("swagger配置文件")
public class SwaggerConfiguration {
    @Bean
    Docket baseDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(Stream.of("application/xml", "application/json").collect(Collectors.toSet()))
                .select().apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any()).build().protocols(Stream.of("http", "https").collect(Collectors.toSet()));
    }
}
