package Test;

/*
This a Junit test module for performing the unit test on the admin module
 */
import Domain.Admin;

import TableDataGateway.AdminTDG;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class AdminTest {

    private AdminTDG adminTDG;
    private AdminTDG adminTDG2;
    private List<Admin> adminTest;

    @BeforeEach
    void init() {
        adminTDG=AdminTDG.getInstance();
        adminTDG2=AdminTDG.getInstance();
        adminTest = adminTDG.Admin_Login();
    }

    @Test
    public void TestAdminInstance()
    {
        assertSame(adminTDG,adminTDG2);
    }

    @Test
    public  void TestAdminLogin_Positive(){
        assertEquals("Jtn1",adminTest.get(0).getUsername());
        assertEquals("1234J",adminTest.get(0).getPassword());

        assertEquals("Sr02",adminTest.get(1).getUsername());
        assertEquals("234S",adminTest.get(1).getPassword());

        assertEquals("Krd3",adminTest.get(2).getUsername());
        assertEquals("456K",adminTest.get(2).getPassword());

        assertEquals("Mst4",adminTest.get(3).getUsername());
        assertEquals("567M",adminTest.get(3).getPassword());

        assertEquals("Tal5",adminTest.get(4).getUsername());
        assertEquals("789T",adminTest.get(4).getPassword());

    }

    @Test
    public  void TestAdminLogin_Negative(){

        assertEquals("Jtn1",adminTest.get(0).getUsername());
        assertNotEquals("Sro23",adminTest.get(0).getPassword());

        assertNotEquals("123J",adminTest.get(1).getUsername());
        assertEquals("234S",adminTest.get(1).getPassword());

        assertNotEquals(1234,adminTest.get(2).getUsername());
        assertEquals("456K",adminTest.get(2).getPassword());

        assertEquals("Mst4",adminTest.get(3).getUsername());
        assertNotEquals(2345,adminTest.get(3).getPassword());

        assertNotEquals("",adminTest.get(4).getUsername());
        assertNotEquals("",adminTest.get(4).getPassword());

    }


}
