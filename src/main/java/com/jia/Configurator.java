package com.jia;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class Configurator implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context = servletContextEvent.getServletContext();
        //  添加过滤器
        FilterRegistration.Dynamic registration =
                context.addFilter("requestLogFilter", new RequestLogFilter());
        registration.addMappingForUrlPatterns(null, false, "/");
        registration = context.addFilter("compressionFilter", new CompressionFilter());
        registration.setAsyncSupported(true);
        registration.addMappingForUrlPatterns(null, false, "/");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
