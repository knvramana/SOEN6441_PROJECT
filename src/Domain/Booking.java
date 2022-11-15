/*
This file consists of Domain Booking class which implements the getters and setters.

As class members are private we can access the variables only through getters and setters.
 */
package Domain;

public class Booking {
    private String Booking_Reference;
    private Flight flight;
    private Passenger passenger;

    public String getBooking_Reference() {
        return Booking_Reference;
    }

    public void setBooking_Reference(String booking_Reference) {
        Booking_Reference = booking_Reference;
    }
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
