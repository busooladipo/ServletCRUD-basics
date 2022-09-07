package com.ease.servletdb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SiteController", value = "/site")
public class SiteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        page = page.toLowerCase();

        switch (page) {
            case "home":
                home(request, response);
                break;
            default:
                error(request, response);

        }

    }

    public void home(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void error(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("error.jsp").forward(request, response);
    }


}
