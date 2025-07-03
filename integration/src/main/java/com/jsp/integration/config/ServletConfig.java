package com.jsp.integration.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration.Dynamic;

public class ServletConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		context.refresh();

		DispatcherServlet servlet = new DispatcherServlet(context);

		Dynamic dynamic = servletContext.addServlet("dispatcherServlet", servlet);
		dynamic.addMapping("/");
		dynamic.setLoadOnStartup(1);

	}

}
