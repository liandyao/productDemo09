package com.yidu.product;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with IntelliJ IDEA.
 * User: liandyao
 * Date: 2019-09-04
 * Time: 17:44
 * Description: No Description
 */
@Configuration//配置类
@EnableSwagger2//启用Swagger
public class SwaggerConfig {
    @Bean//加入到spring的容器中
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yidu.product.controller"))//需要扫描的包路径
                .paths(PathSelectors.any())
                .build()
                .apiInfo(testApiInfo());
    }

    private ApiInfo testApiInfo() {
        ApiInfo build = new ApiInfoBuilder()
                .title("springBoot集成swagger构建api文档-商品信息")//标题
                .description("此处为详细描述")//详细描述
                .version("1.0")//版本
                .termsOfServiceUrl("服务地址")
                .contact(new Contact("yidu", "https://yidu.com", "yidu@yidu.com"))//作者的一些信息
                .license("The Apache License, Version 2.0")//发布遵循协议
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")//协议地址
                .build();
        return build;
    }

}
