package com.example.tp1_applicationentreprise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletWelcome", value = "/ServletWelcome")
public class ServletWelcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        PrintWriter pwriter = response.getWriter();
        if (session == null) {
            response.sendRedirect("ServletConnect");
        } else {
            String log= (String) session.getAttribute("login");

            pwriter.append("Welcome "+log);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
