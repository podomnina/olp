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
            CreateTables();


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

    public ArrayList<Object> makeRequest(String sql) throws SQLException {

        resultSet = statement.executeQuery(sql);
        ArrayList<Object> list=null;
        int choice=-1;
        if (sql.contains(" branch"))
            choice=0;
        else if (sql.contains(" doctor"))
            choice=1;
        else if (sql.contains(" reception"))
            choice=2;
        else if (sql.contains(" service"))
            choice=3;

        switch (choice){
            case 0:
                list=new ArrayList<Object>();
                while (resultSet.next()){
                    int id=Integer.parseInt(resultSet.getString("ID"));
                    String address=resultSet.getString("ADDRESS");
                    String number=resultSet.getString("NUMBER");
                    Branch obj=new Branch(id,address,number);
                    list.add(obj);
                }

                break;
            case 1:
                list=new ArrayList<Object>();
                while (resultSet.next()){
                    int id=Integer.parseInt(resultSet.getString("ID"));
                    String name=resultSet.getString("NAME");
                    String spec=resultSet.getString("SPECIALIZATION");
                    int id_br=Integer.parseInt(resultSet.getString("ID_BRANCH"));
                    Doctor obj=new Doctor(id,name,spec,id_br);
                    list.add(obj);
                }
                break;
            case 2:
                list=new ArrayList<Object>();
                while (resultSet.next()){
                    int id=Integer.parseInt(resultSet.getString("ID"));
                    String date=resultSet.getString("DATE");
                    Reception obj=new Reception(id,date);
                    list.add(obj);
                }
                break;
            case 3:
                list=new ArrayList<Object>();
                while (resultSet.next()){
                    int id=Integer.parseInt(resultSet.getString("ID"));
                    String name=resultSet.getString("NAME");
                    int price=Integer.parseInt(resultSet.getString("PRICE"));
                    Service obj=new Service(id,name,price);
                    list.add(obj);
                }
                break;
        }

      /*  int colomnCount = resultSet.getMetaData().getColumnCount();
        while(resultSet.next()) {
            for (int i=1; i<=colomnCount; i++){
                System.out.print(resultSet.getString(i)+" ");
            }
            System.out.println();
        }*/

        return list;
    }



    public static void CreateTables() throws SQLException {
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
        statement.close();

    }

    public void InsertBranchRecord(String address,String number) throws SQLException {
        statement.execute("insert into 'BRANCH' ('ADDRESS', 'NUMBER') values ('"+address+"', '"+number+"'); ");
    }
    public void InsertDoctorRecord(String name,String specialization,int id_branch) throws SQLException {
        statement.execute("insert into 'DOCTOR' ('NAME','SPECIALIZATION', 'ID_BRANCH') values ('"+name+"', '"+specialization+"','"+id_branch+"'); ");
    }
    public void InsertReceptionRecord(Statement statement,String date) throws SQLException {
        statement.execute("insert into 'RECEPTION' ('DATE') values ('"+date+"'); ");
    }
    public void InsertServiceRecord(Statement statement,String name,int price) throws SQLException {
        statement.execute("insert into 'SERVICE' ('NAME', 'PRICE') values ('"+name+"', '"+price+"'); ");
    }
}
