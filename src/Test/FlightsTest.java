package Test;

import Domain.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import Domain.Flight;
import TableDataGateway.FlightsTDG;

import java.util.List;
import java.util.Random;

public class FlightsTest {

    private FlightsTDG flightsTDG;
    private List<Flight> flightTest;
    private Flight flight = new Flight();

    @BeforeEach
    void init(){
        flightsTDG = flightsTDG.getInstance();
        flightTest =flightsTDG.View_flight_details();

    }

    @Nested
    class Test_View_flight_details_Positive{

        @Test
        public void Test_View_flight_details_01(){

            assertEquals(1038,flightTest.get(85).getFlight_Number());
            assertEquals("Vistara",flightTest.get(85).getAirline());
            assertEquals("PHX",flightTest.get(85).getOrigin());
            assertEquals("CVG",flightTest.get(85).getDestination());
            assertEquals(2237,flightTest.get(85).getArrival_Time());
            assertEquals(1612,flightTest.get(85).getDeparture_Time());
            assertEquals(181,flightTest.get(85).getAirtime());
            assertEquals("05/11/2022",flightTest.get(85).getDate());
            assertEquals("ORF",flightTest.get(85).getLayover_Location());
            assertEquals(58,flightTest.get(85).getLayover_Time());

        }

        @Test
        public void Test_View_flight_details_02(){

            assertEquals(1434,flightTest.get(54).getFlight_Number());
            assertEquals("GoAir",flightTest.get(54).getAirline());
            assertEquals("CLT",flightTest.get(54).getOrigin());
            assertEquals("BWI",flightTest.get(54).getDestination());
            assertEquals(2019,flightTest.get(54).getArrival_Time());
            assertEquals(1859,flightTest.get(54).getDeparture_Time());
            assertEquals(56,flightTest.get(54).getAirtime());
            assertEquals("01/11/2022",flightTest.get(54).getDate());
            assertNull(flightTest.get(54).getLayover_Location());
            assertEquals(0,flightTest.get(54).getLayover_Time());
        }

        @Test
        public void Test_View_flight_details_03(){

            assertEquals(703,flightTest.get(6).getFlight_Number());
            assertEquals("Emirates",flightTest.get(6).getAirline());
            assertEquals("PHX",flightTest.get(6).getOrigin());
            assertEquals("PDX",flightTest.get(6).getDestination());
            assertEquals(2238,flightTest.get(6).getArrival_Time());
            assertEquals(1655,flightTest.get(6).getDeparture_Time());
            assertEquals(316,flightTest.get(6).getAirtime());
            assertEquals("07/11/2022",flightTest.get(6).getDate());
            assertEquals("TPA",flightTest.get(6).getLayover_Location());
            assertEquals(51,flightTest.get(6).getLayover_Time());

        }

    }

    @Nested
    class Test_View_flight_details_Negative{

        @Test
        public void Test_View_flight_details_01(){

            assertNotEquals(10,flightTest.get(85).getFlight_Number());
            assertNotEquals("Vitara",flightTest.get(85).getAirline());
            assertNotEquals("PUX",flightTest.get(85).getOrigin());
            assertNotEquals("OYP",flightTest.get(85).getDestination());
            assertNotEquals(22,flightTest.get(85).getArrival_Time());
            assertNotEquals(112,flightTest.get(85).getDeparture_Time());
            assertNotEquals(11,flightTest.get(85).getAirtime());
            assertNotEquals("05/11/2021",flightTest.get(85).getDate());
            assertNotEquals("AL",flightTest.get(85).getLayover_Location());
            assertNotEquals(11,flightTest.get(85).getLayover_Time());

        }

        @Test
        public void Test_View_flight_details_02(){

            assertNotEquals(1038,flightTest.get(54).getFlight_Number());
            assertNotEquals("Vistara",flightTest.get(54).getAirline());
            assertNotEquals(1,flightTest.get(54).getOrigin());
            assertNotEquals("PHX",flightTest.get(54).getDestination());
            assertNotEquals(2000,flightTest.get(54).getArrival_Time());
            assertNotEquals(1500,flightTest.get(54).getDeparture_Time());
            assertNotEquals(76,flightTest.get(54).getAirtime());
            assertNotEquals("01/11/2020",flightTest.get(54).getDate());
            assertNotEquals("",flightTest.get(54).getLayover_Location());
            assertNotEquals("TU",flightTest.get(54).getLayover_Time());
        }

        @Test
        public void Test_View_flight_details_03(){

            assertNotEquals(300,flightTest.get(6).getFlight_Number());
            assertNotEquals("Indigo",flightTest.get(6).getAirline());
            assertNotEquals("CVG",flightTest.get(6).getOrigin());
            assertNotEquals("PHX",flightTest.get(6).getDestination());
            assertNotEquals(2237,flightTest.get(6).getArrival_Time());
            assertNotEquals(1613,flightTest.get(6).getDeparture_Time());
            assertNotEquals(181,flightTest.get(6).getAirtime());
            assertNotEquals("07/10/1920",flightTest.get(6).getDate());
            assertNotEquals("ORF",flightTest.get(6).getLayover_Location());
            assertNotEquals(40,flightTest.get(6).getLayover_Time());

        }

    }

    @Nested
    class Test_Add_Flight_Details_Positive{

        @Test
        public void Add_Flight_details_01(){

            try {
                Random random = new Random();
                int rd = random.nextInt(10000);

                flight.setFlight_Number(rd);
                flight.setAirline("NewAirline");
                flight.setOrigin("OXD");
                flight.setDestination("TRY");
                flight.setArrival_Time(2000);
                flight.setDeparture_Time(2300);
                flight.setAirtime(180);
                flight.setDate("22/03/2023");
                flight.setLayover_Location("null");
                flight.setLayover_Time(0);

                flightsTDG.Add_Flight_Details(flight);

                flightTest = flightsTDG.View_flight_details();
                int length = flightTest.size() - 1;


                assertEquals(rd, flightTest.get(length).getFlight_Number());
                assertEquals("NewAirline", flightTest.get(length).getAirline());
                assertEquals("OXD", flightTest.get(length).getOrigin());
                assertEquals("TRY", flightTest.get(length).getDestination());
                assertEquals(2000, flightTest.get(length).getArrival_Time());
                assertEquals(2300, flightTest.get(length).getDeparture_Time());
                assertEquals(180, flightTest.get(length).getAirtime());
                assertEquals("22/03/2023", flightTest.get(length).getDate());
                assertEquals("null", flightTest.get(length).getLayover_Location());
                assertEquals(0, flightTest.get(length).getLayover_Time());

            } catch (Exception e) {}


        }
        @Test
        public void Add_Flight_details_02() {
            try {
                Random random = new Random();
                int rd = random.nextInt(10000);
                flight.setFlight_Number(rd);
                flightsTDG.Add_Flight_Details(flight);
                flightTest = flightsTDG.View_flight_details();
                int length = flightTest.size() - 1;

                assertEquals(rd, flightTest.get(length).getFlight_Number());
                assertEquals(null, flightTest.get(length).getAirline());
                assertEquals(null, flightTest.get(length).getOrigin());
                assertEquals(null, flightTest.get(length).getDestination());
                assertEquals(0, flightTest.get(length).getArrival_Time());
                assertEquals(0, flightTest.get(length).getDeparture_Time());
                assertEquals(0, flightTest.get(length).getAirtime());
                assertEquals(null, flightTest.get(length).getDate());
                assertEquals(null, flightTest.get(length).getLayover_Location());
                assertEquals(0, flightTest.get(length).getLayover_Time());
            } catch (Exception e) {}

        }

        @Test
        public void Add_Flight_details_03() {

            try {

                flightsTDG.Add_Flight_Details(flight);
                flightTest =flightsTDG.View_flight_details();
                int length =  flightTest.size()-1;

            }
            catch (Exception e)
            {
                assertEquals(0,flight.getFlight_Number());
            }

        }

    }

    @Nested
    class Test_Add_Flight_Details_Negative{

        @Test
        public  void  Add_Flight_details_01(){

            try {
                Random random = new Random();
                int rd = random.nextInt(10000);

                flight.setFlight_Number(rd);
                flight.setAirline("NewAirlineTest");
                flight.setOrigin("TST");
                flight.setDestination("RET");
                flight.setArrival_Time(1200);
                flight.setDeparture_Time(1300);
                flight.setAirtime(60);
                flight.setDate("25/02/2023");
                flight.setLayover_Location("null");
                flight.setLayover_Time(0);

                flightsTDG.Add_Flight_Details(flight);

                flightTest = flightsTDG.View_flight_details();
                int length = flightTest.size() - 1;

                assertEquals(rd, flightTest.get(length).getFlight_Number());
                assertNotEquals("NewAirline", flightTest.get(length).getAirline());
                assertNotEquals("OXD", flightTest.get(length).getOrigin());
                assertNotEquals("TRY", flightTest.get(length).getDestination());
                assertNotEquals(2000, flightTest.get(length).getArrival_Time());
                assertNotEquals(2300, flightTest.get(length).getDeparture_Time());
                assertNotEquals(180, flightTest.get(length).getAirtime());
                assertNotEquals("22/03/2023", flightTest.get(length).getDate());
                assertNotEquals("YUL", flightTest.get(length).getLayover_Location());
                assertNotEquals(10, flightTest.get(length).getLayover_Time());

            } catch (Exception e) {}

        }

        @Test
        public void Add_Flight_Details_02(){
            try {

                Random random = new Random();
                int rd = random.nextInt(10000);
                flight.setFlight_Number(rd);
                flightsTDG.Add_Flight_Details(flight);
                flightTest = flightsTDG.View_flight_details();
                int length = flightTest.size() - 1;

                assertEquals(rd, flightTest.get(length).getFlight_Number());
                assertNotEquals("NewAirline", flightTest.get(length).getAirline());
                assertNotEquals("OXD", flightTest.get(length).getOrigin());
                assertNotEquals("TRY", flightTest.get(length).getDestination());
                assertNotEquals(2000, flightTest.get(length).getArrival_Time());
                assertNotEquals(2300, flightTest.get(length).getDeparture_Time());
                assertNotEquals(180, flightTest.get(length).getAirtime());
                assertNotEquals("22/03/2023", flightTest.get(length).getDate());
                assertNotEquals("YUL", flightTest.get(length).getLayover_Location());
                assertNotEquals(10, flightTest.get(length).getLayover_Time());
            } catch (Exception e) {}
        }

        @Test
        public void Add_Flight_Details_03(){
            try {

                flightsTDG.Add_Flight_Details(flight);
                flightTest =flightsTDG.View_flight_details();
                int length =  flightTest.size()-1;

            }
            catch (Exception e)
            {
                assertNotEquals(10,flight.getFlight_Number());
            }
        }
    }

}