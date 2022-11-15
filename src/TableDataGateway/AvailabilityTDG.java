package TableDataGateway;
/*
This is Table Data gateway implementation for the Availability module.

This class uses Singleton pattern
 */
import Domain.Availability;
import JDBCConnection.JDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AvailabilityTDG {
    private static AvailabilityTDG instance = null;
    private AvailabilityTDG() {
    }
    public static AvailabilityTDG getInstance() {
        if(instance == null) {
            instance = new AvailabilityTDG();
        }
        return instance;
    }

    //This method takes flight number input and returns an availability object
    public Availability viewAvailableSeats(int flight_no)
    {
        Availability availability=new Availability();
        try {
            Connection conn = JDBConnection.getConnection();
            String sql = "select * from Availability where flight_number=?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,flight_no);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                availability.setFlight_Number(rs.getInt(1));
                availability.setTotal_No_of_Seats(rs.getInt(2));
                availability.setAvaliable_No_of_Seats(rs.getInt(3));
            }
        }catch (Exception e) {
            availability=null;
            e.printStackTrace();
            System.out.println("Please Try Again");
        }
        return availability;
    }
    //This method takes flight number input and returns an integer, reducing the number of seats in the availability
    public int reduceAvailableSeats(int flight_no)
    {
        int flag;
        try {
            Connection conn = JDBConnection.getConnection();
            String sql = "update Availability set Avaliable_no_seats=Avaliable_no_seats-1 where flight_number=?;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,flight_no);
            flag=stmt.executeUpdate();
        }catch (Exception e) {
            flag=0;
            e.printStackTrace();
            System.out.println("Please Try Again");
        }
        return flag;
    }
}
