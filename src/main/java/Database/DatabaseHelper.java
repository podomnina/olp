package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by PolinaDomnina on 08.11.2015.
 */
public class DatabaseHelper {
    private static Connection connection = null;
    private static ResultSet resultSet = null;
    private static Statement statement = null;

    public static void main(String[] args)
    {


        try
        {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:D:\\clinic.db");
            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("SELECT NAME FROM Doctor");
            while (resultSet.next())
            {
                System.out.println("DOCTOR NAME:"
                        + resultSet.getString("NAME"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }



}
