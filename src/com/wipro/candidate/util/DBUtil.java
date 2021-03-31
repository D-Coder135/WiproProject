package com.wipro.candidate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/Candidate Management System";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static Connection connection = null;

    public static Connection getDBConn() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException exception) {
            System.err.println("The connection to the database could not be made."
                    + " Please check the URL, USERNAME and PASSWORD!");
            exception.printStackTrace();
        }
    }

}