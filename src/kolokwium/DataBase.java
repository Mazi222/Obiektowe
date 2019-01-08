package kolokwium;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBase {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    DataBase()
    {
    }

    public void addPlayer(String query)
    {
        connect();
        statementCreation();
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {}
        closeAll();
    }



    public boolean isConnected()
    {
        return connection != null;
    }

    private void connect()
    {
        byte tries = 0;
        while(tries++<3) {
            try
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/rafalmaz", "rafalmaz", "39hrsexF2WWrpoPf");
                tries=3;
            }
            catch (SQLException ex)
            {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                if(connection==null)
                {
                    ++tries;
                }
                if(connection==null && tries==3)
                {
                    System.out.println("Brak połączenia z bazą spróbuj jeszcze raz");
                }
            }
        }
    }

    private void statementCreation()
    {
        if(isConnected())
        {
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {}
        }
    }

    private void closeAll()
    {
        if(resultSet!=null)
        {
            try
            {
                resultSet.close();
            }
            catch (SQLException e) {}
        }
        resultSet = null;

        if(statement!=null)
        {
            try
            {
                statement.close();
            }
            catch (SQLException e) {}
        }
        statement = null;

        if(connection != null)
        {
            try
            {
                connection.close();
            }
            catch (SQLException e) {}
        }
        connection = null;
    }



}
