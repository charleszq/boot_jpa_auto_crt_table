package com.example;

import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DemoApplication.class);
    }

    @Bean
    public CXFNonSpringJaxrsServlet odataServiceDispatcherServlet() {
        return new CXFNonSpringJaxrsServlet();
    }

    @Bean
    public DispatcherServlet springDispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(odataServiceDispatcherServlet(), "/sampleodata2/*");
        Map<String, String> params = new HashMap<String, String>();
        params.put("javax.ws.rs.Application", "org.apache.olingo.odata2.core.rest.app.ODataApplication");
        params.put("org.apache.olingo.odata2.service.factory", "com.example.service.MyServiceFactory");
        registration.setInitParameters(params);
        return registration;
    }

    @Bean
    public ServletRegistrationBean springDispatcherServletRegistration() {
        ServletRegistrationBean springServletBean = new ServletRegistrationBean(springDispatcherServlet(), "/rest/*");
        return springServletBean;
    }
}
