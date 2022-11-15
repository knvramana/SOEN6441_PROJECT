package JDBCConnection;
/*
This class file is for setting the connection between Java and Sqlite3.

The JAR file should be added as a dependency to the project folder.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBConnection {
    public static Connection conn=null;

    public static Connection getConnection()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:/Users/ashish/IdeaProjects/APP_Project_V3/src/JDBCConnection/mDb.db";
            conn = DriverManager.getConnection(dbURL);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Please Try Again");
        }
        return conn;
    }
}
