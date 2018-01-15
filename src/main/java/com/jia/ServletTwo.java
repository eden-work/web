package com.jia;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "servletTwo",
        urlPatterns = {"/jia/servletTwo"}
)
public class ServletTwo extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Enter ServletTwo.doGet()");
        response.getWriter().write("Servlet Two");
        System.out.println("Leaving ServletTwo.doGet()");
    }

}
