/*
This is Table Data gateway implementation for the Admin module.

This class uses Singleton pattern
 */
package TableDataGateway;
import Domain.Admin;
import JDBCConnection.JDBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AdminTDG {
    private static AdminTDG instance = null;
    private AdminTDG() {
    }
    public static AdminTDG getInstance() {
        if(instance == null) {
            instance = new AdminTDG();
        }
        return instance;
    }

    //returns the list of admin credentials for login
    public List<Admin> Admin_Login()
    {
        List<Admin> admin = new ArrayList<>();
        try {
            Connection conn = JDBConnection.getConnection();
            String statement = "Select * from Admin;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while (rs.next()){
                Admin admin_details=new Admin();
                admin_details.setAdmin_ID(rs.getInt("Admin_ID"));
                admin_details.setFirstname(rs.getString("Firstname"));
                admin_details.setLastname(rs.getString("Lastname"));
                admin_details.setUsername(rs.getString("Username"));
                admin_details.setPassword(rs.getString("Password"));
                admin.add(admin_details);
            }
        } catch (Exception e) {
            admin=null;
            e.printStackTrace();
            System.out.println("Please Try Again");
        }
        return admin;
    }
}
