package TableDataGateway;
/*
This is Table Data gateway implementation for the Flights module.

This class uses Singleton pattern
 */
import Domain.Flight;
import JDBCConnection.JDBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightsTDG {
    private static FlightsTDG instance = null;

    private FlightsTDG() {
    }

    public static FlightsTDG getInstance() {
        if (instance == null) {
            instance = new FlightsTDG();
        }
        return instance;
    }
// this method is used for viewing the flight data without taking any parameter and returns list of flight objects
    public List<Flight> View_flight_details() {
        List<Flight> flight = new ArrayList<>();
        try {
            Connection conn = JDBConnection.getConnection();
            String statement = "Select * from Flights;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(statement);
            while (rs.next()) {
                Flight flight_details = new Flight();
                flight_details.setFlight_Number(rs.getInt("Flight_Number"));
                flight_details.setAirline(rs.getString("Airline"));
                flight_details.setOrigin(rs.getString("Orgin"));
                flight_details.setDestination(rs.getString("Destination"));
                flight_details.setDeparture_Time(rs.getInt("Departure_Time"));
                flight_details.setArrival_Time(rs.getInt("Arrival_Time"));
                flight_details.setAirtime(rs.getInt("Airtime"));
                flight_details.setDate(rs.getString("Date"));
                flight_details.setLayover_Location(rs.getString("Layover_Location"));
                flight_details.setLayover_Time(rs.getInt("Layover_Time"));
                flight.add(flight_details);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Please Try Again");
        }
        return flight;
    }
//This method will take a flight object as a parameter and inserts them into the flight database
    public int Add_Flight_Details(Flight flight) {
        int flag;
        try {
            Connection conn = JDBConnection.getConnection();
            String statement = "insert into Flights values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.setInt(1,flight.getFlight_Number());
            stmt.setString(2,flight.getAirline());
            stmt.setString(3,flight.getOrigin());
            stmt.setString(4,flight.getDestination());
            stmt.setInt(5,flight.getArrival_Time());
            stmt.setInt(6,flight.getDeparture_Time());
            stmt.setInt(7,flight.getAirtime());
            stmt.setString(8,flight.getDate());
            stmt.setString(9,flight.getLayover_Location());
            stmt.setInt(10,flight.getLayover_Time());
            flag= stmt.executeUpdate();
            if (flag==1)
            {
                int totmin=100;
                int totmax=250;
                int avamin=0;
                int avamax=100;
                int tot=(int)((Math.random()*(totmax-totmin))+totmin);
                int ava=(int)((Math.random()*(avamax-avamin))+avamin);
                statement = "insert into Availability values(?,?,?);";
                stmt=conn.prepareStatement(statement);
                stmt.setInt(1,flight.getFlight_Number());
                stmt.setInt(2,tot);
                stmt.setInt(3,ava);
                flag= stmt.executeUpdate();
            }
        } catch (Exception e) {
            flag=0;
            e.printStackTrace();
            System.out.println("Please Try Again");
        }
        return flag;
    }
//This method is used for modifying  the flight details by flight object as parameter and modifies in database
    public int modify_flight_details(Flight flight)
    {
        int flag ;
        try{
            Connection conn = JDBConnection.getConnection();
            String statement = "update flights set Airline=?,Orgin=?,Destination=?,Arrival_Time=?,Departure_Time=?,AirTime=?,Date=?,Layover_Location=?,Layover_Time=? where Flight_Number=?;";
            PreparedStatement stmt = conn.prepareStatement(statement);
            stmt.setString(1,flight.getAirline());
            stmt.setString(2,flight.getOrigin());
            stmt.setString(3,flight.getDestination());
            stmt.setInt(4,flight.getArrival_Time());
            stmt.setInt(5,flight.getDeparture_Time());
            stmt.setInt(6,flight.getAirtime());
            stmt.setString(7,flight.getDate());
            stmt.setString(8,flight.getLayover_Location());
            stmt.setInt(9,flight.getLayover_Time());
            stmt.setInt(10,flight.getFlight_Number());
            flag= stmt.executeUpdate();
        }catch (Exception e) {
            flag=0;
            e.printStackTrace();
            System.out.println("Please Try Again");
        }
        return flag;
    }
}
