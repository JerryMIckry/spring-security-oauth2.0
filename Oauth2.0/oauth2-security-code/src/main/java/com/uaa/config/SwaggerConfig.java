package com.uaa.config; /**
 * @date 2020/7/23  15:18
 * @author Jerry
 */

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.URL;
import java.util.ArrayList;

/**
 * @author : Yusentong
 * @Date: 2020/7/23 15:18
 * @Description:
 */
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "swagger", name = "open", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //这里采用包含注解的方式来确定要显示的接口（建议采取这种）
                .apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置swagger 文档显示的相关标识（信息会显示到swagger页面）
     *
     * @return
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("鉴权服务项目", "", "18222767925@163.com");
        return new ApiInfo(
                "鉴权服务项目",
                "鉴权服务项目的接口",
                "v1.0",
                "",
                contact,
                "",
                "",
                new ArrayList<>()
        );
    }
}
