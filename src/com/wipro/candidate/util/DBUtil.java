/*   Created by IntelliJ IDEA.
 *   Author: Devansh Shukla (D_Coder135)
 *   File: DBUtil.java
 */

package com.wipro.candidate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/Candidate Management System";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }

    public static Connection getDBConn() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException exception) {
            System.err.println("Could not connect to the database." + " Please check the URL, Username and Password");
            exception.printStackTrace();
        } finally {
            printConnectionStatus();
        }
        return connection;
    }

    private static void printConnectionStatus() {
        System.out.println(connection == null ? "The connection to the database is inactive." :
                "The conncetion to the database is active.");
    }
}