package javaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author 84338
 */
public class MainConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=InventoryManagement4;encrypt=true;trustServerCertificate=true;", "sa", "sqladmin");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return conn;
    }
    public static void main(String[] args) {
        if (MainConnection.getConnection() != null) {
            System.out.println("Ket noi thanh cong");
        }
    }
}