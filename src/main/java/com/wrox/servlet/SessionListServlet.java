package com.wrox.servlet;

import com.wrox.listener.SessionRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "sessionListServlet",
        urlPatterns = {"/wrox/sessions"}
)
public class SessionListServlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("userName") == null)
        {
            response.sendRedirect("login");
            return;
        }
        request.setAttribute("timestamp", System.currentTimeMillis());
        request.setAttribute("numberOfSessions",
                SessionRegistry.getNumberOfSessions());
        request.setAttribute("sessionList", SessionRegistry.getAllSessions());
        request.getRequestDispatcher("/WEB-INF/jsp/view/sessions.jsp")
                .forward(request, response);
    }

}
