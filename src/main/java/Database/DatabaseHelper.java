package Database;

import Database.Tables.*;

import java.io.PrintWriter;
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

    public void makeRequest(String sql, PrintWriter pw) throws SQLException {
        resultSet = statement.executeQuery(sql);
        String str = resultSetToJSON(resultSet);
        pw.println(str);
        System.out.println(str);


        /*
        int colomnCount = resultSet.getMetaData().getColumnCount();
        while(resultSet.next()) {
            for (int i=1; i<=colomnCount; i++){
                pw.print(resultSet.getString(i)+" ");
            }
            pw.println();
        }*/
    }

    /*
    public JsonObject resultSetToJSON(ResultSet rs) throws java.sql.SQLException {
        JsonObjectBuilder responseBuilder = Json.createObjectBuilder();
        JsonArrayBuilder colsArrayBuilder = Json.createArrayBuilder();
        for (int i=1; i<=rs.getMetaData().getColumnCount(); i++) {
            colsArrayBuilder.add(rs.getMetaData().getColumnName(i));
        }
        responseBuilder.add("colNames",colsArrayBuilder);
        JsonArrayBuilder dataArrayBuilder = Json.createArrayBuilder();
        while (rs.next()){
            JsonArrayBuilder tmpBuilder = Json.createArrayBuilder();
            for (int i=1; i<=rs.getMetaData().getColumnCount(); i++) {
                tmpBuilder.add(rs.getString(i));
            }
            dataArrayBuilder.add(tmpBuilder);
        }
        responseBuilder.add("data",dataArrayBuilder);
        JsonObject response = responseBuilder.build();
        return response;
    }*/

    public String resultSetToJSON(ResultSet rs) throws java.sql.SQLException {
        String response = "{ \"colNames\":[";
        response = response + '"' + rs.getString(1) + '"';
        for (int i=2; i<=rs.getMetaData().getColumnCount(); i++){
            response = response + ',' + '"' + rs.getMetaData().getColumnLabel(i) + '"';
        }
        response += "], \"dataArray\":[";
        rs.next();
        response +="[" + '"' + rs.getString(1) + '"';
        for (int i=2; i<=rs.getMetaData().getColumnCount(); i++) {
            response +=", " + '"' + rs.getString(i) + '"';
        }
        response +="]";
        while (rs.next()){
            response +=",[" + '"' + rs.getString(1) + '"';
            for (int i=2; i<=rs.getMetaData().getColumnCount(); i++) {
                response +=", " + '"' + rs.getString(i) + '"';
            }
            response +="]";
        }
        response +="]}";
        return response;
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
