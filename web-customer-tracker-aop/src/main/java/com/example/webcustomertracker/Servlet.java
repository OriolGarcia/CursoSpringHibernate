package com.example.webcustomertracker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.System.out;

@WebServlet(name = "Servlet", value = "/servlet")
public class Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String user = "springstudent";
        String pass = "springstudent";
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver ="org.mariadb.jdbc.Driver";
        try{
            PrintWriter out= response.getWriter();
            System.out.println("Connection to dtabase" +jdbcUrl);
            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("SUCCESS!");
            myConn.close();
        }catch(Exception exc) {

            exc.printStackTrace();
            throw new ServletException(exc);
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}
