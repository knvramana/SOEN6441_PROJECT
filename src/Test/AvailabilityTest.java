package Test;
/*
This a Junit test module for performing the unit test on the Availability module
 */
import Domain.Availability;
import TableDataGateway.AvailabilityTDG;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AvailabilityTest {
    private AvailabilityTDG availabilityTDG;
    private AvailabilityTDG availabilityTDG2;
    private Availability availability;

    @BeforeEach
    void init() {
        availabilityTDG=AvailabilityTDG.getInstance();
        availabilityTDG2=AvailabilityTDG.getInstance();
    }

    @Test
    public void TestAvailabilityInstance()
    {
        assertSame(availabilityTDG,availabilityTDG2);
    }

    @Nested
    class TestViewAvailableSeats_Positive
    {
        @Test
        public void TestViewAvailableSeats_1()
        {
            availability=availabilityTDG.viewAvailableSeats(1719);
            assertNotNull(availability);
            assertEquals(1719,availability.getFlight_Number());
            assertEquals(155,availability.getTotal_No_of_Seats());

        }
        @Test
        public void TestViewAvailableSeats_2()
        {
            availability=availabilityTDG.viewAvailableSeats(701);
            assertNotNull(availability);
            assertEquals(701,availability.getFlight_Number());
            assertEquals(152,availability.getTotal_No_of_Seats());
            assertTrue(availability.getAvaliable_No_of_Seats()>=0);
        }
        @Test
        public void TestViewAvailableSeats_3()
        {
            availability=availabilityTDG.viewAvailableSeats(1601);
            assertNotNull(availability);
            assertEquals(1601,availability.getFlight_Number());
            assertEquals(183,availability.getTotal_No_of_Seats());
            assertTrue(availability.getAvaliable_No_of_Seats()==0);
        }
    }
    @Nested
    class TestViewAvailableSeats_Negative
    {
        @Test
        public void TestViewAvailableSeats_1()
        {
            availability=availabilityTDG.viewAvailableSeats(1);
            assertEquals(0,availability.getFlight_Number());
            assertEquals(0,availability.getTotal_No_of_Seats());
            assertEquals(0,availability.getAvaliable_No_of_Seats());

        }
        @Test
        public void TestViewAvailableSeats_2()
        {
            availability=availabilityTDG.viewAvailableSeats(1719);
            assertNotNull(availability);
            assertNotEquals("155",availability.getFlight_Number());
            assertNotEquals("155",availability.getTotal_No_of_Seats());
        }
        @Test
        public void TestViewAvailableSeats_3()
        {
            availability=availabilityTDG.viewAvailableSeats(1461);
            assertNotNull(availability);
            assertFalse(availability.getAvaliable_No_of_Seats()<0);

        }

    }
}
