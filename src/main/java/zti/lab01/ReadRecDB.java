package zti.lab01;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name = "ReadRecDB", value = "/ReadRecDB")
public class ReadRecDB extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at: ").append(request.getContextPath());
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out= response.getWriter();
        out.println("<h1>Dane z bazy danych PostgreSQL - ElephantSQL</h1>") ;

        try
        {
            // Class.forName("org.apache.derby.jdbc.ClientDriver");
            // url = "jdbc:postgresql://host:port/database"
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://trumpet.db.elephantsql.com:5432/vppbhvzu";
            String username = "vppbhvzu" ;
            String password = "jSQW8UyiwBWLu9xSsjYnRzV3NLU3J8Xs" ;
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM public.person";
            ResultSet rs = stmt.executeQuery( sql );
            out.println("<table>") ;
            out.println("<tr><th>Lp.</th><th>Imię</th><th>Nazwisko</th><th>Miasto</th></tr>") ;
            while(rs.next())  {
                out.print("<tr><td>" + rs.getInt("ID") + "</td><td>" + rs.getString("FNAME") + "</td>" ) ;
                out.println ( "<td>" + rs.getString("LNAME") + "</td><td>" + rs.getString("CITY") + "</td></tr>" ) ;
            }
            out.println("</table>") ;
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {  out.println (e) ; }

    }
}
