package zti.lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LabIndex", value = "/LabIndex-lab01")
public class LabIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println ("<title>ZTI - Lab01</title>");

        out.println ("<h1>ZTI - Lab01 : Servlets and JSP scripts </h1>");
        out.println ("<ol>");
        out.println ("<li><a href='Example'>[Example] First Example</a></li>");
        out.println ("</ol>");
        out.println ("<li><a href='ReadReqParam'>[Servlet] Read Request Parameter</a></li>");
        out.println ("<li><a href='FormData.html'>[Servlet] Read the data from the html form</a></li>");
        out.println ("<li><a href='ReadRecDB'>[Servlet (JDBC)] Read the records from the PostgreSQL database</a></li>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
