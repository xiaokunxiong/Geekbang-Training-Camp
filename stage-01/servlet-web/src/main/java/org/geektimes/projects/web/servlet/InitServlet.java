package org.geektimes.projects.web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @title: myServlet
 * @Author sean
 * @Date: 2021/6/12 3:44 下午
 */
@WebServlet(urlPatterns = "/init")
public class InitServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.getRequestDispatcher("/forward").forward(request,response);
    }
}
