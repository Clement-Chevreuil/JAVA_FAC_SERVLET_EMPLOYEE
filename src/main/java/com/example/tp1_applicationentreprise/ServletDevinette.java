package com.example.tp1_applicationentreprise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletDevinette", value = "/ServletDevinette")
public class ServletDevinette extends HttpServlet {
    int alea;
    @Override
    public void init() throws ServletException {
        super.init();
        alea = alea();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        getServletContext().setAttribute("alea", alea);
        PrintWriter pwriter = response.getWriter();
        System.out.println("alea "+ alea);
        if(request.getAttribute("msg")!=null)
        {


            pwriter.append("<font color=\"red\" > "+(String)request.getAttribute("msg")+"</font>");
            request.getRequestDispatcher("devinette.html").include(request, response);

        }
        else
            request.getRequestDispatcher("ServletDevinetteRes").forward(request, response);

    }
    private int alea ()
    {
        return (int)(Math.random()*100);

    }
}
