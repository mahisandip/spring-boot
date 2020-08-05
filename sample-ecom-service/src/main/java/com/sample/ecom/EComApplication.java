package com.sample.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sample.ecom.*" })
public class EComApplication extends SpringBootServletInitializer{
	
//	@Override
//	public void onStartup(ServletContext container) throws ServletException {
//        AnnotationConfigWebApplicationContext ctx
//          = new AnnotationConfigWebApplicationContext();
//        ctx.setServletContext(container);
// 
//        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", 
//          new DispatcherServlet(ctx));
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("/");
//     }
//
//	@Bean
//	public DispatcherServlet dispatcherServlet() {
//		return new DispatcherServlet();
//	}
//
//	@Bean
//	public ServletRegistrationBean dispatcherServletRegistration() {
//		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/");
//		registration.setName(
//				DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
//		return registration;
//	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EComApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EComApplication.class, args);
	}

}
