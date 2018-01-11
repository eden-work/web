package com.wrox.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

@WebServlet(
        name = "loginServlet",
        urlPatterns = {"/wrox/login"}
)
public class LoginServlet extends HttpServlet {

    private static final Map<String, String> userDatabase = new Hashtable<>();

    static {
        userDatabase.put("admin1", "123");
        userDatabase.put("admin2", "123");
        userDatabase.put("admin3", "123");
        userDatabase.put("admin4", "123");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (request.getParameter("logout") != null) {
            session.invalidate();
            response.sendRedirect("login");
            return;
        }
        if (session.getAttribute("userName") != null) {
            response.sendRedirect("tickets");
            return;
        }
        request.setAttribute("loginFailed", false);
        request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("userName") != null) {
            response.sendRedirect("tickets");
            return;
        }
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        if (userName == null || password == null
                || !LoginServlet.userDatabase.containsKey(userName)
                || !password.equals(LoginServlet.userDatabase.get(userName))) {
            request.setAttribute("loginFailed", true);
            request.getRequestDispatcher("/WEB-INF/jsp/view/login.jsp").forward(request, response);
        } else {
            session.setAttribute("userName", userName);
            request.changeSessionId();
            response.sendRedirect("tickets");
        }
    }

}
