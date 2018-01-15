package com.jia;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "servletThree",
        urlPatterns = {"/jia/servletThree"}
)
public class ServletThree extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Enter ServletThree.doGet()");
        response.getWriter().write("Servlet Threee");
        System.out.println("Leaving ServletThree.doGet()");
    }

}
