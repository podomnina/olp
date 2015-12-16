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

@WebServlet("/s")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        DatabaseHelper db=new DatabaseHelper();
        db.UsingDatabase();
       /* try {
            ArrayList<String> list=db.Request();
            if (list!=null){
            String varTextA = list.get(0);
            request.setAttribute("textA", varTextA);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        ArrayList<String> list=new ArrayList<String>();
        try {
            if (request.getParameter("select") == "branch") {
                list=BranchtoString(db.RequestBranch());
            }else if (request.getParameter("select") == "doctor"){
                list=DoctortoString(db.RequestDoctor());
            }else if (request.getParameter("select") == "reception"){
                list=ReceptiontoString(db.RequestReception());
            }else if (request.getParameter("select") == "service"){
                list=ServicetoString(db.RequestService());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list",list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        db.CloseDatabase();
    }
    public ArrayList<String> BranchtoString(ArrayList<Branch> branch){
        ArrayList<String> list=new ArrayList<String>();
        for (Branch br:branch) {
            StringBuilder str = new StringBuilder();
            str.append(br.getBranch_address() + " " + br.getBranch_number());
            list.add(str.toString());
        }
            return list;
    }
    public ArrayList<String> DoctortoString(ArrayList<Doctor> doctor){
        ArrayList<String> list=new ArrayList<String>();
        for (Doctor dc:doctor) {
            StringBuilder str = new StringBuilder();
            str.append(dc.getDoctor_name() + " " + dc.getSpecialization() + " " + dc.getId_branch());
            list.add(str.toString());
        }
        return list;
    }
    public ArrayList<String> ReceptiontoString(ArrayList<Reception> reception){
        ArrayList<String> list=new ArrayList<String>();
        for (Reception re:reception) {
            StringBuilder str = new StringBuilder();
            str.append(re.getDate());
            list.add(str.toString());
        }
        return list;
    }
    public ArrayList<String> ServicetoString(ArrayList<Service> service){
        ArrayList<String> list=new ArrayList<String>();
        for (Service srv:service) {
            StringBuilder str = new StringBuilder();
            str.append(srv.getService_name() + " " + srv.getPrice());
            list.add(str.toString());
        }
        return list;
    }
}