package com.felix.database;
import java.sql.*;

public class DatabaseHandler {
    private static final String DB_url = "jdbc:derby:database/forum;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;
    public static DatabaseHandler handler;
    public static String name;

    public DatabaseHandler() {
        createConnection();
        createList();
    }

    public static DatabaseHandler getHandler() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }

    private void createList() {
        String TABLE_NAME = name; // folder name
        try{
            stmt = conn.createStatement();
            DatabaseMetaData dmn = conn.getMetaData();
            ResultSet tables = dmn.getTables(null,null,TABLE_NAME,null);
            if(tables.next()){
                System.out.println("Table "+TABLE_NAME+" already exists");
            }else{
                String statement = "CREATE TABLE "+TABLE_NAME+" ("
                        + "num INT NOT NULL  GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) , \n "
                        + "name varchar(200), \n"
                        + "path varchar(200), \n"
                        + "extension varchar(200), \n"
                        + "file_size varchar(200))";
                stmt.execute(statement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_url);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public boolean doThings(String qu) {
        try{
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        } catch (SQLException e) {System.out.println(e);System.out.println("No data");}
        return false;
    }

    public ResultSet doThingsAgain(String query) {
        ResultSet resultSet;
        try{
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return resultSet;
    }
}