package com.briup.kfc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//是为了解决跨域问题。
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**").allowedOrigins("*")
				.allowedMethods("GET","POST","PUT","OPTIONS","DELETE","PATCH")
				.allowCredentials(true).maxAge(3600);
	}
	
}
