package com.jia;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by eden on 2018/1/15.
 */
public class FilterB implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Entering FilterB.doFilter()");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Leaving FilterB.doFilter()");
    }

    @Override
    public void destroy() {

    }
}