//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 27/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package ClientTests;

import SoftwareProject.Client.LoginClient;
import org.junit.jupiter.api.*;
import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTests {

    private JFrame frame;
    private String path;

    @BeforeAll
    static void startTests(){
        System.out.println("Beginning Tests for client login");
    }

    @AfterAll
    static void finishedTest(){
        System.out.println("Finished Tests for client login");
    }

    @BeforeEach
    void init(TestInfo testinfo, TestReporter testreporter){
        testreporter.publishEntry(("Testing " + testinfo.getDisplayName()));
    }
    @BeforeEach
    void Setup(){
        frame = new JFrame("Messaging App");
        path = "src\\main\\resources\\pictures\\background.png";
    }
    @DisplayName("Constructor for login page")
    @Test
    @Order(1)
    void TestConstructor() {
        LoginClient login = new LoginClient(frame, 400, 600, path);
        assertEquals(frame, login.getWindow());
        assertEquals(400, login.getWidth());
        assertEquals(600, login.getHeight());
        assertEquals(path, login.getImage());
    }
    @DisplayName("Testing set button name")
    @Test
    @Order(2)
    void TestButton() {
        LoginClient login = new LoginClient(frame, 400, 600, path);
        login.setButtonName("Login");
        assertTrue(login.buttonName);
    }


    @DisplayName("Font method")
    @Test
    @Order(3)
    void TestGetFont() {
        LoginClient login = new LoginClient(frame, 400, 600, path);
        login.getFont("Times New Roman", 25);
        assertEquals("Times New Roman", login.getFontText());
        assertEquals(25, login.getFont_size());
    }

    @DisplayName("Check Connection successful")
    @Test
    @Order(4)
    void TestConnect() {
        LoginClient login = new LoginClient(frame, 400, 600, path);
        login.connect("192.168.1.13", 2003);
        assertEquals("192.168.1.13", login.getServerIp());
        assertEquals(2003, login.getPortnum());
        assertTrue(login.isConnection());
    }

    @DisplayName("Check Connection closed successful")
    @Test
    @Order(5)
    void TestDisconnect() {
          LoginClient login = new LoginClient(frame, 400, 600, path);
          login.disconnect();
          assertTrue(login.Sockclosed);
    }
}

