package com.felix.database;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static DatabaseHandler handler;

    public static void addMember(String id, String name, String email, String nickName){
        String qu = "INSERT INTO MEMBER VALUES (" +
                "'" + id + "'," +
                "'" + name + "'," +
                "'" + email + "'," +
                "'" + nickName + "')";
        handler.execAction(qu);
    }

    public static void retrieveInfo() {
        String qu = "SELECT * FROM MEMBER";
        ResultSet resultSet = handler.execQuery(qu);
        try{
            while (resultSet.next()){
                String id = resultSet.getString("ID");
                String name = resultSet.getString("NAME");
                System.out.println("Entry: ID" + id + "\tName: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addFiles(){
        String path = System.getProperty("user.dir");
        System.out.println(path);
        File file = new File("123");
    }

    public static void main(String[] args) {
        handler = DatabaseHandler.getHandler();

    }
}
