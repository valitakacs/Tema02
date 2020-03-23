package ro.Emanuel.Tema02.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {
    public static final String DB_USER = "root";
    public static final String DB_PASS = "root";
    public static final String DB_URL = "jdbc:mysql://localhost:3306/tema2";

    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.put("user", DB_USER);
        props.put("pasword", DB_PASS);

        Connection con = DriverManager.getConnection(DB_URL, props);
        System.out.println("Connected to database");
        return con;
    }

    public static void closeConnection(Connection con)throws SQLException{
        con.close();
        System.out.println("Conexiunea a fost inchisa");
    }

}
