package com.wrox.listener;

import com.wrox.filter.AuthenticationFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Configurator implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        FilterRegistration.Dynamic registration =
                context.addFilter("authenticationFilter", new AuthenticationFilter());
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null, false, "/wrox/tickets", "/wrox/sessions");

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
