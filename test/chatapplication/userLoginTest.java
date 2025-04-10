/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package chatapplication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class userLoginTest {
    
    public userLoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkUserName method, of class userLogin.
     */
    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        userLogin instance = new userLogin();
        boolean expResult = false;
        boolean result = instance.checkUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class userLogin.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        userLogin instance = new userLogin();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCellPhoneNumber method, of class userLogin.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        userLogin instance = new userLogin();
        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class userLogin.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        userLogin instance = new userLogin();
        String expResult = "";
        String result = instance.registerUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class userLogin.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        userLogin instance = new userLogin();
        boolean expResult = false;
        boolean result = instance.loginUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnLoginStatus method, of class userLogin.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loginStatus = false;
        userLogin instance = new userLogin();
        instance.returnLoginStatus(loginStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class userLogin.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        userLogin instance = new userLogin();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class userLogin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        userLogin instance = new userLogin();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCellnumber method, of class userLogin.
     */
    @Test
    public void testGetCellnumber() {
        System.out.println("getCellnumber");
        userLogin instance = new userLogin();
        String expResult = "";
        String result = instance.getCellnumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRegistered method, of class userLogin.
     */
    @Test
    public void testIsRegistered() {
        System.out.println("isRegistered");
        userLogin instance = new userLogin();
        boolean expResult = false;
        boolean result = instance.isRegistered();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
