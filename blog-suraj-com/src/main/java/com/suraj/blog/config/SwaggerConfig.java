package com.suraj.blog.config;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	private ApiKey apiKeys() {
		return new ApiKey("JWT", AppConstant.AUTHORIZATION_HEADER, "header");
	}
	
	private List<SecurityContext> securityContexts(){
		return Arrays.asList(
				SecurityContext.builder()
				.securityReferences(this.securityReferances())
				.build()
				);
	}
	
	private List<SecurityReference> securityReferances(){
		AuthorizationScope scopes = new AuthorizationScope("global", "access everything");
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {scopes}));
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.securityContexts(this.securityContexts())
				.securitySchemes(Arrays.asList(this.apiKeys()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
	
	private ApiInfo getInfo() {
		return new ApiInfo("Blogging Backend: API Documentation", "This is API Documentation for blogging website", "1.0", "Terms of Service",new Contact("Suraj", "https://www.linkedin.com/in/suraj-bhange/", "suraj.bhange.007@gmail.com"),"Licence of APIs", "API Licenece URL", Collections.EMPTY_LIST);
	}
}
