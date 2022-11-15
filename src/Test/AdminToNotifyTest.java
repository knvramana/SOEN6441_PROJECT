package Test;
/*
This a Junit test module for performing the unit test on the AdminToNotify module
 */
import Observer.AdminToNotify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AdminToNotifyTest {

    List<List<Integer>> link;
    AdminToNotify adminToNotify;
    @BeforeEach
    void init() {
        adminToNotify=new AdminToNotify();
        link=new ArrayList<>();
    }

    @Nested
    class TestAdminToNotify_Positive{

        @Test
        public void TestAdminToNotify_1()
        {
            adminToNotify.ToNotify(1192,35);
            link=adminToNotify.AfterNotify();
            assertEquals(1192,link.get(0).get(0));
            assertEquals(35,link.get(0).get(1));
        }
        @Test
        public void TestAdminToNotify_2()
        {
            adminToNotify.ToNotify(1192,35);
            adminToNotify.ToNotify(1719,70);
            link=adminToNotify.AfterNotify();
            assertEquals(1192,link.get(0).get(0));
            assertEquals(35,link.get(0).get(1));
            assertEquals(1719,link.get(1).get(0));
            assertEquals(70,link.get(1).get(1));
        }
    }

    @Nested
    class TestAdminToNotify_Negative{

        @Test
        public void TestAdminToNotify_1()
        {
            link=adminToNotify.AfterNotify();
            assertNotEquals(1,link.size());
        }
        @Test
        public void TestAdminToNotify_2()
        {
            adminToNotify.ToNotify(1192,35);
            adminToNotify.ToNotify(1719,70);
            link=adminToNotify.AfterNotify();
            assertEquals(1192,link.get(0).get(0));
            assertNotEquals(70,link.get(0).get(1));
            assertEquals(1719,link.get(1).get(0));
            assertNotEquals(35,link.get(1).get(1));
        }
        @Test
        public void TestAdminToNotify_3()
        {
            adminToNotify.ToNotify(1192,35);
            adminToNotify.ToNotify(1719,70);
            link=adminToNotify.AfterNotify();
            assertNotEquals(192,link.get(0).get(0));
            assertEquals(35,link.get(0).get(1));
            assertNotEquals(179,link.get(1).get(0));
            assertEquals(70,link.get(1).get(1));
        }
    }
}
