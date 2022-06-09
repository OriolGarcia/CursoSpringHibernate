package com.luv2code.springsecurity.demo.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
            DemoApoConfig.class
        };
    }
@GetMapping

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
