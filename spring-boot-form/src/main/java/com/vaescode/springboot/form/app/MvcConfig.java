package com.vaescode.springboot.form.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	@Qualifier("tiempoTranscurridoInterceptor")
	private HandlerInterceptor tiempoTranscurridoInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//Usando el interceptor en una rura especifica
		registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form/**");
		//Usando interceptor en más de una ruta
		//registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form/**","/ver/**");
	}

}
