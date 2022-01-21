package com.example.tp1_applicationentreprise;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDevinetteRes", value = "/ServletDevinetteRes")
public class ServletDevinetteRes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int nombre=Integer.parseInt(request.getParameter("nombre"));
        int alea=(int)getServletContext().getAttribute("alea");

        if(nombre==alea)
        {
            response.getWriter().print("Bien joue !!");
        }
        else
        {
            if(nombre<alea)
            {
                RequestDispatcher rd = request.getRequestDispatcher("ServletDevinette");

                request.setAttribute("msg", "Le nombre recherche est plus grand");
                rd.forward(request, response);

            }
            else
            {
                response.getWriter().append("Le nombre recherche est plus petit");
                RequestDispatcher rd = request.getRequestDispatcher("ServletDevinette");

                request.setAttribute("msg", "Le nombre recherche est plus petit");
                rd.forward(request, response);


            }
        }

    }
}
