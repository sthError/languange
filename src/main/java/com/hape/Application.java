package com.hape;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@MapperScan("com.hape.dao.*.mapper")
@SpringBootApplication
//@EnableTransactionManagement // 事务自动配置
@EnableSwagger2WebMvc
@EnableNacosDiscovery
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
