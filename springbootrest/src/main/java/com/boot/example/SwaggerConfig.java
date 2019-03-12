package com.boot.example;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//	@Bean
//	public Docket postsApi() {
//		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
//				.apiInfo(apiInfo()).select().paths(postPaths()).build();
//	}
	
	@Bean
	   public Docket api() {
	       return new Docket(DocumentationType.SWAGGER_2).select()
	               .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
	               .paths(PathSelectors.any()).build().pathMapping("/")
	               .apiInfo(apiInfo()).useDefaultResponseMessages(false);
	   }

	private Predicate<String> postPaths() {
		return or(regex("/*"), regex("/users/*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("User management API")
				.description("User management API By Restful WebService")
				.termsOfServiceUrl("http://ir.tfs.com")
				.contact("ion.reporter@lifetech.com").license("@IR License")
				.licenseUrl("ion.reporter@lifetech.com").version("1.0").build();
	}

}
