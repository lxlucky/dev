package com.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class MySwaggerConfig {
	
	@Bean  
    public Docket commonDocket() {  
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		ApiInfo apiInfo = new ApiInfo("基础框架", "项目接口API文档", "1.0", "lixiong.com", new Contact("lixiong", "", "lxlucky93@163.com"), "", "");
		docket.apiInfo(apiInfo);
		return docket;
    }  
  
   
}
