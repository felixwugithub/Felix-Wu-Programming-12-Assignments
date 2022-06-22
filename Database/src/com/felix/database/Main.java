package com.felix.database;


import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static com.felix.database.DatabaseHandler handler;

    public static void addMember(String id, String name, String email, String nickName){ // Add members
        String qu = "INSERT INTO MEMBER VALUES (" +
                "'" + id + "'," +
                "'" + name + "'," +
                "'" + email + "'," +
                "'" + nickName + "')";
        handler.execAction(qu);
    }


    public static void retrieveInfoMember() { // get info from member table
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

    public static void retrieveInfoFile(String table) { // get info from specified folder
        String qu = "SELECT * FROM "+ table;
        ResultSet resultSet = handler.execQuery(qu);
        try{
            while (resultSet.next()){
                String name = resultSet.getString("NAME");
                String path = resultSet.getString("PATH");
                String extension = resultSet.getString("EXTENSION");
                String fileSize = resultSet.getString("FILE_SIZE");
                System.out.println("File Name=" + name + "\t| File Path=" + path + "\t| File Extension="+ extension+"\t| File Size=" + fileSize +" bytes");
            }
        } catch (SQLException e) {
         e.printStackTrace();
        }
    }

    public static void addFiles(String name, String path, String extension, String fileSize){ // add info thru absolute path
        String qu = "INSERT INTO "+ DatabaseHandler.name +" (name, path, extension, file_size) VALUES (" +
                "'" + name + "'," +
                "'" + path + "'," +
                "'" + extension + "'," +
                "'" + fileSize + "')";
        handler.execAction(qu);
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Create new table[a] / Retrieve table[b] ");
        if (myObj.nextLine().equals("a")) {
            System.out.println("Absolute path: ");
            String path = myObj.nextLine();
            File folder = new File(path);
            DatabaseHandler.name= folder.getName();
            handler = DatabaseHandler.getHandler(); // Set up handler
            ReadFolder.ReadFiles(folder);
        } else {
            System.out.println("folder name: ");
            String tableName = myObj.nextLine();
            handler = DatabaseHandler.getHandler(); // null handler when folder has no name
            retrieveInfoFile(tableName);
        }

    }
}
