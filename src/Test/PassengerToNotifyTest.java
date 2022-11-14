package Test;
import Observer.PassengerToNotify;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PassengerToNotifyTest {
    private PassengerToNotify passengerToNotify;

    @BeforeEach
    void init() {
        passengerToNotify=new PassengerToNotify();
    }
    @Nested
    class TestPassengerToNotify_Positive{

        @Test
        public void TestPassengerToNotify_1()
        {
            passengerToNotify.addPassengerToNotify(1192,35);
            int status=passengerToNotify.removePassengerToNotify(1192,35);
            assertEquals(1,status);
        }
        @Test
        public void TestPassengerToNotify_2()
        {
            passengerToNotify.addPassengerToNotify(1192,35);
            passengerToNotify.addPassengerToNotify(1719,70);
            int status=passengerToNotify.removePassengerToNotify(1719,70);
            assertEquals(1,status);
            status=passengerToNotify.removePassengerToNotify(1192,35);
            assertEquals(1,status);
        }
    }

    @Nested
    class TestPassengerToNotify_Negative{

        @Test
        public void TestPassengerToNotify_1()
        {
            passengerToNotify.addPassengerToNotify(1192,35);
            int status=passengerToNotify.removePassengerToNotify(112,35);
            assertNotEquals(1,status);
        }
        @Test
        public void TestPassengerToNotify_2()
        {
            passengerToNotify.addPassengerToNotify(1192,35);
            int status=passengerToNotify.removePassengerToNotify(1192,70);
            assertNotEquals(1,status);
        }
        @Test
        public void TestPassengerToNotify_3()
        {
            int status=passengerToNotify.removePassengerToNotify(1719,35);
            assertNotEquals(1,status);
        }
    }
}
