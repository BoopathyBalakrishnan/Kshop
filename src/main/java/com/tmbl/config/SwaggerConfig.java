package com.tmbl.config;

import org.springframework.context.annotation.Bean;
import static springfox.documentation.builders.PathSelectors.regex;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {/*
	 @Bean
	    public Docket newsApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .groupName("greetings")
	                .apiInfo(apiInfo())
	                .select()
	                .paths(regex("/student.*"))
	                .build();
	    }
	     
	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Spring REST Sample with Swagger")
	                .description("Spring REST Sample with Swagger")
	                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
	                .contact("Niklas Heidloff")
	                .license("Apache License Version 2.0")
	                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
	                .version("2.0")
	                .build();
	    }
*/}
