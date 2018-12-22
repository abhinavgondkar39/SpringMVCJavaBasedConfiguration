package com.ab9.config;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class WebServletConfiguration implements WebApplicationInitializer{

	/**
	 * WebApplicationInitializer - programmatical way to implement 
	 * 							   ServeletContext rather than through web.xml
	 */
	
	public void onStartup(ServletContext ctx) throws ServletException {
		
		/*make use of this application context,
		the "contextClass" context-param for ContextLoader and/or 
		"contextClass" init-param for FrameworkServlet*/
		
		AnnotationConfigWebApplicationContext webCtx=new AnnotationConfigWebApplicationContext();
		webCtx.register(SpringConfiguration.class);
		webCtx.setServletContext(ctx);
		ServletRegistration.Dynamic servlet=ctx.addServlet("customermvc",new DispatcherServlet(webCtx));// distapatcher serverlet name
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
	}

}
