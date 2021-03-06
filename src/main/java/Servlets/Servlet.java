package Servlets;

import Database.DatabaseHelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

// Ctrl + Alt + O / Ctrl + Alt + L
// DAO - Data Access Object
// Query Submit Route: JSP - Servlet - DAO - DB
@WebServlet("/mainPage")
public class Servlet extends HttpServlet {

    DatabaseHelper db;
    List<Object> list;

    @Override
    public void init(ServletConfig servletConfig) {
        db = new DatabaseHelper();
        db.UsingDatabase();

        /*
        try {
            db.CreateTables();
            db.InsertBranchRecord("Branch2","2");
            db.InsertDoctorRecord("Doctor3","Spec3",2);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }*/

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        System.out.println("POST!");
        System.out.println(request.getParameter("tf1"));
        PrintWriter pw = response.getWriter();
        try {
            db.makeRequest(request.getParameter("tf1"),pw);
        } catch (java.sql.SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}