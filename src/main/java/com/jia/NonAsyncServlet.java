package com.jia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "nonAsyncServlet",
        urlPatterns = {"/jia/regular"}
)
public class NonAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        System.out.println("Entering NonAsyncServlet.doGet().");
        request.getRequestDispatcher("/jia/nonAsync.jsp")
                .forward(request, response);
        System.out.println("Leaving NonAsyncServlet.doGet().");
    }

}
