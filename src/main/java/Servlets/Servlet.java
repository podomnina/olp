package Servlets;

import Database.DatabaseHelper;
import Database.Tables.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/mainPage")
public class Servlet extends HttpServlet {

    DatabaseHelper db;
    List<Object> list;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //super.doPost(request, response);
       // response.setContentType("text/html");
        //request.setCharacterEncoding("UTF-8");


        response.sendRedirect("index");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
       request.setCharacterEncoding("UTF-8");
       response.setCharacterEncoding("UTF-8");

        //response.setContentType("text/html");
        db=new DatabaseHelper();
        db.UsingDatabase();

        request.setAttribute("list",list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        db.CloseDatabase();}
        catch (Exception e){
            e.printStackTrace();
        }
    }

}