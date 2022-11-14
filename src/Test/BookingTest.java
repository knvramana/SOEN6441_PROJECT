package Test;
import Domain.Booking;
import TableDataGateway.BookingTDG;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookingTest {
    private BookingTDG bookingTDG;

    private BookingTDG bookingTDG2;
    private List<Booking> book;
    private List<Integer> link;
    private List<List<Integer>> data;

    @BeforeEach
    void init() {
        bookingTDG=BookingTDG.getInstance();
        bookingTDG2=BookingTDG.getInstance();
        data=new ArrayList<>();
    }
    @Test
    public void TestBookingInstance()
    {
        assertSame(bookingTDG,bookingTDG2);
    }

    @Nested
    class TestView_booking_details_Positive{
        @Test
        public void TestView_Booking_Details_1() {
            book=bookingTDG.View_booking_details(70);
            assertEquals("N69736",book.get(0).getBooking_Reference());
            assertEquals(1212,book.get(0).getFlight().getFlight_Number());
            assertEquals(70,book.get(0).getPassenger().getPassenger_ID());
            assertEquals("76be5",book.get(1).getBooking_Reference());
            assertEquals(1270,book.get(1).getFlight().getFlight_Number());
            assertEquals(70,book.get(1).getPassenger().getPassenger_ID());
        }
        @Test
        public void TestView_Booking_Details_2() {
            book=bookingTDG.View_booking_details(35);
            assertEquals("N326US",book.get(0).getBooking_Reference());
            assertEquals(550,book.get(0).getFlight().getFlight_Number());
            assertEquals(35,book.get(0).getPassenger().getPassenger_ID());
            assertEquals("967f8",book.get(1).getBooking_Reference());
            assertEquals(906,book.get(1).getFlight().getFlight_Number());
            assertEquals(35,book.get(1).getPassenger().getPassenger_ID());
            assertEquals("19be8",book.get(2).getBooking_Reference());
            assertEquals(1773,book.get(2).getFlight().getFlight_Number());
            assertEquals(35,book.get(2).getPassenger().getPassenger_ID());
        }
        @Test
        public void TestView_Booking_Details_3() {
            book=bookingTDG.View_booking_details(1);
            assertEquals("N615DL",book.get(0).getBooking_Reference());
            assertEquals(346,book.get(0).getFlight().getFlight_Number());
            assertEquals(1,book.get(0).getPassenger().getPassenger_ID());
        }
        @Test
        public void TestView_Booking_Details_4() {
            book=bookingTDG.View_booking_details(150);
            assertEquals(0,book.size());
        }
    }

    @Nested
    class TestView_booking_details_Negative{
        @Test
        public void TestView_Booking_Details_1() {
            book=bookingTDG.View_booking_details(70);
            assertNotEquals("N6973",book.get(0).getBooking_Reference());
            assertNotEquals("1212",book.get(0).getFlight().getFlight_Number());
            assertNotEquals("70",book.get(0).getPassenger().getPassenger_ID());
        }
        @Test
        public void TestView_Booking_Details_2() {
            book=bookingTDG.View_booking_details(35);
            assertNotEquals("N559U",book.get(0).getBooking_Reference());
            assertNotEquals(373 ,book.get(0).getFlight().getFlight_Number());
            assertNotEquals(20,book.get(0).getPassenger().getPassenger_ID());
            assertNotEquals("",book.get(1).getBooking_Reference());
            assertNotEquals(1207,book.get(1).getFlight().getFlight_Number());
        }
        @Test
        public void TestView_Booking_Details_3() {
            book=bookingTDG.View_booking_details(150);
            assertNotEquals("NULL",book);
        }
    }

    @Nested
    class TestViewNewlyBookedFlights_Positive{
        @Test
        public void TestViewNewlyBookedFlights_1() {
            link=new ArrayList<>();link.add(1270);link.add(70);
            data.add(link);
            book=bookingTDG.ViewNewlyBookedFlights(data);
            assertEquals("76be5",book.get(0).getBooking_Reference());
            assertEquals(1270,book.get(0).getFlight().getFlight_Number());
            assertEquals(70,book.get(0).getPassenger().getPassenger_ID());
        }
        @Test
        public void TestViewNewlyBookedFlights_2() {
            link = new ArrayList<>();link.add(1270);link.add(70);data.add(link);
            link = new ArrayList<>();link.add(1773);link.add(35);data.add(link);
            book = bookingTDG.ViewNewlyBookedFlights(data);
            assertEquals("76be5", book.get(0).getBooking_Reference());
            assertEquals(1270, book.get(0).getFlight().getFlight_Number());
            assertEquals(70, book.get(0).getPassenger().getPassenger_ID());
            assertEquals("19be8", book.get(1).getBooking_Reference());
            assertEquals(1773, book.get(1).getFlight().getFlight_Number());
            assertEquals(35, book.get(1).getPassenger().getPassenger_ID());
        }
        @Test
        public void TestViewNewlyBookedFlights_3() {
            data=new ArrayList<>();
            book = bookingTDG.ViewNewlyBookedFlights(data);
            assertEquals(0,book.size());
        }
    }

    @Nested
    class TestViewNewlyBookedFlights_Negative{
        @Test
        public void TestViewNewlyBookedFlights_1() {
            link=new ArrayList<>();link.add(1434);link.add(55);
            data.add(link);
            book=bookingTDG.ViewNewlyBookedFlights(data);
            assertNotEquals("76be",book.get(0).getBooking_Reference());
            assertNotEquals(1270,book.get(0).getFlight().getFlight_Number());
            assertNotEquals(70,book.get(0).getPassenger().getPassenger_ID());
        }
        @Test
        public void TestViewNewlyBookedFlights_2() {
            link=new ArrayList<>();link.add(1434);link.add(55);
            data.add(link);
            book=bookingTDG.ViewNewlyBookedFlights(data);
            try {
                assertNotEquals("76be", book.get(0).getBooking_Reference());
                assertNotEquals(1270, book.get(0).getFlight().getFlight_Number());
                assertNotEquals(70, book.get(0).getPassenger().getPassenger_ID());
                assertEquals("19be8", book.get(1).getBooking_Reference());
                assertEquals(1773, book.get(1).getFlight().getFlight_Number());
                assertEquals(35, book.get(1).getPassenger().getPassenger_ID());
            }catch (Exception e)
            {
                assertNotEquals(2,data.size());
            }
        }
    }

    //--------------------------------------
    @Nested
    class TestNewFlightBooking_Positive{
        @Test
        public void TestNewFlightBooking_1() {
                int status = bookingTDG.newFlightBooking(2411, 77);
                book = bookingTDG.View_booking_details(77);
                assertEquals(1, status);
                assertEquals(2411, book.get(book.size() - 1).getFlight().getFlight_Number());
                assertEquals(77, book.get(book.size() - 1).getPassenger().getPassenger_ID());
        }
        @Test
        public void TestNewFlightBooking_2() {
            int status = bookingTDG.newFlightBooking(0, 77);
            book = bookingTDG.View_booking_details(77);
            assertEquals(1, status);
            assertEquals(0, book.get(book.size() - 1).getFlight().getFlight_Number());
            assertEquals(77, book.get(book.size() - 1).getPassenger().getPassenger_ID());
        }

    }

    @Nested
    class TestNewFlightBooking_Negative{

        @Test
        public void TestNewFlightBooking_1() {
            int status = bookingTDG.newFlightBooking(2411, 77);
            book = bookingTDG.View_booking_details(77);
            assertEquals(1, status);
            assertNotEquals("aef01",book.get(book.size() - 1).getBooking_Reference());
        }

        @Test
        public void TestNewFlightBooking_2() {
            int status = bookingTDG.newFlightBooking(2411, 0);
            book = bookingTDG.View_booking_details(0);
            assertNotEquals(0, status);
            assertNotEquals(1,book.size());
        }
    }
    @Nested
    class TestGetPassengerIDs_Positive{
        @Test
        public void TestGetPassengerIDs_1(){
            link=bookingTDG.getPassengerIDs(1719);
            assertEquals(36,link.get(0));
        }
        @Test
        public void TestGetPassengerIDs_2(){
            link=bookingTDG.getPassengerIDs(1192);
            assertEquals(98,link.get(0));
            assertEquals(35,link.get(1));
        }
        @Test
        public void TestGetPassengerIDs_3(){
            link=bookingTDG.getPassengerIDs(-1);
            assertEquals(0,link.size());
        }
    }

    @Nested
    class TestGetPassengerIDs_Negative{
        @Test
        public void TestGetPassengerIDs_1(){
            link=bookingTDG.getPassengerIDs(1192);
            assertNotEquals(35,link.get(0));
        }
        @Test
        public void TestGetPassengerIDs_2(){
            link=bookingTDG.getPassengerIDs(1719);
            try {
                assertEquals(35, link.get(1));
            }catch (Exception e)
            {
                assertNotEquals(2,link.size());
            }
        }
        @Test
        public void TestGetPassengerIDs_3(){
            try{
                link = bookingTDG.getPassengerIDs(Integer.parseInt(""));
            }catch (Exception e)
            {
                assertNull(link);
            }
        }
    }
}