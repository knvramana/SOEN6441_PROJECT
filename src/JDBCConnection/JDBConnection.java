package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnection {
    public static Connection conn=null;

    public static Connection getConnection()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:D:\\InteliJ\\SOEN6441_Project\\src\\JDBCConnection\\mDb.db";
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception ex) {
        }
        return conn;
    }
}
