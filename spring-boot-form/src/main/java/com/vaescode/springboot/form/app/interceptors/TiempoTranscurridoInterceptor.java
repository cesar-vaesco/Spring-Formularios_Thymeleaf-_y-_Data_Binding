package com.vaescode.springboot.form.app.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

	
	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando...");
		logger.info("Interceptando: " + handler);
		long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		/*Simulando una carga/demora en la petición(request)*/
		Random random = new Random();
		Integer demora = random.nextInt(500);
		Thread.sleep(demora);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		long tiempoFin = System.currentTimeMillis();
		long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		long tiempoTranscurrido = tiempoFin - tiempoInicio;
		
		if(modelAndView != null) {
			modelAndView.addObject("tiempoTranscurrido",tiempoTranscurrido);
		}
		logger.info("Tiempo Transcurrido: " + tiempoTranscurrido + "milisegundos");
		logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo...");
	}

	
}
