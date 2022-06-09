package com.curso.webcustomertracker2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServlet", value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = "springstudent";
        String pass = "springstudent";
        String jdbcUrl = "jdbc:mariadb://localhost:3306/web_customer_tracker?useSSL=false";
        String driver ="mysql-connector-java:8.0.29";
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
