package Database;

import Database.Tables.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by PolinaDomnina on 08.11.2015.
 */
public class DatabaseHelper {
    private static Connection connection = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;

    public void UsingDatabase(){
        try
        {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Medicineclinic.db");
            statement = connection.createStatement();

/*            CreateTables(statement);

            InsertBranchRecord(statement, "ул.Родионова д.197", "4609385");
            InsertBranchRecord(statement, "ул.Бекетова д.13", "4691827");
            InsertDoctorRecord(statement,"Иванов","Хирургия",1);
            InsertReceptionRecord(statement, "10.10.15");
            InsertServiceRecord(statement, "Консультация", 500);

            resultSet = statement.executeQuery("SELECT * FROM BRANCH");
            while (resultSet.next()){
                System.out.println("BRANCH ADDRESS:" + resultSet.getString("ADDRESS"));
            }

*/
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void CloseDatabase(){
        try
        {
//            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Branch> RequestBranch() throws SQLException {
        ArrayList<Branch> list=new ArrayList<Branch>();
        resultSet = statement.executeQuery("SELECT * FROM BRANCH");

        while (resultSet.next()){
            int id=Integer.parseInt(resultSet.getString("ID"));
            String address=resultSet.getString("ADDRESS");
            String number=resultSet.getString("NUMBER");
            Branch branch=new Branch(id,address,number);
            list.add(branch);
        }

        return list;
    }
    public ArrayList<Doctor> RequestDoctor() throws SQLException {
        ArrayList<Doctor> list=new ArrayList<Doctor>();
        resultSet = statement.executeQuery("SELECT * FROM DOCTOR");

        while (resultSet.next()){
            int id=Integer.parseInt(resultSet.getString("ID"));
            String name=resultSet.getString("NAME");
            String specialization=resultSet.getString("SPECIALIZATION");
            int id_branch=Integer.parseInt(resultSet.getString("ID_BRANCH"));
            Doctor doctor=new Doctor(id,name,specialization,id_branch);
            list.add(doctor);
        }

        return list;
    }
    public ArrayList<Reception> RequestReception() throws SQLException {
        ArrayList<Reception> list=new ArrayList<Reception>();
        resultSet = statement.executeQuery("SELECT * FROM RECEPTION");

        while (resultSet.next()){
            int id=Integer.parseInt(resultSet.getString("ID"));
            String date=resultSet.getString("DATE");
            Reception reception=new Reception(id,date);
            list.add(reception);
        }

        return list;
    }
    public ArrayList<Service> RequestService() throws SQLException {
        ArrayList<Service> list=new ArrayList<Service>();
        resultSet = statement.executeQuery("SELECT * FROM SERVICE");

        while (resultSet.next()){
            int id=Integer.parseInt(resultSet.getString("ID"));
            String name=resultSet.getString("NAME");
            int price=Integer.parseInt(resultSet.getString("PRICE"));
            Service service = new Service(id,name,price);
            list.add(service);
        }

        return list;
    }

    public static void CreateTables(Statement statement) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS BRANCH " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " ADDRESS        CHAR(50), " +
                " NUMBER         CHAR(10))";
        statement.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS DOCTOR " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME           CHAR(100)    NOT NULL, " +
                " SPECIALIZATION CHAR(100)   NOT NULL, " +
                " ID_BRANCH      INT         REFERENCES BRANCH(ID) )";
        statement.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS SERVICE " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME           CHAR(100)    NOT NULL, " +
                "PRICE           INT )";
        statement.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS RECEPTION " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " DATE      CHAR(50)          )";
        statement.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS SERVICE_RECEPTION " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ID_RECEPTION INT      REFERENCES RECEPTION(ID)," +
                " ID_SERVICE   INT     REFERENCES SERVICE(ID) )";
        statement.executeUpdate(sql);

        sql = "CREATE TABLE IF NOT EXISTS DOCTOR_RECEPTION " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ID_DOCTOR      INT   REFERENCES DOCTOR(ID)," +
                "ID_RECEPTION   INT   REFERENCES RECEPTION(ID) )";
        statement.executeUpdate(sql);

    }

    public static void InsertBranchRecord(Statement statement,String address,String number) throws SQLException {
        statement.execute("insert into 'BRANCH' ('ADDRESS', 'NUMBER') values ('"+address+"', '"+number+"'); ");
    }
    public static void InsertDoctorRecord(Statement statement,String name,String specialization,int id_branch) throws SQLException {
        statement.execute("insert into 'DOCTOR' ('NAME','SPECIALIZATION', 'ID_BRANCH') values ('"+name+"', '"+specialization+"','"+id_branch+"'); ");
    }
    public static void InsertReceptionRecord(Statement statement,String date) throws SQLException {
        statement.execute("insert into 'RECEPTION' ('DATE') values ('"+date+"'); ");
    }
    public static void InsertServiceRecord(Statement statement,String name,int price) throws SQLException {
        statement.execute("insert into 'SERVICE' ('NAME', 'PRICE') values ('"+name+"', '"+price+"'); ");
    }
}
