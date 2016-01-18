package com.RestfulService.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtility {
 private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
//             Properties prop = new Properties();
//                InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                String url = prop.getProperty("url");
//                String user = prop.getProperty("user");
//                String password = prop.getProperty("password");
         		Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager
                		.getConnection("jdbc:mysql://localhost:3306/taskdb","root", "root");
                System.out.println();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
            	System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            if (connection != null) {
        		System.out.println("You made it, take control your database now!");
        	} else {
        		System.out.println("Failed to make connection!");
        	}
            return connection;
        }

    }

}