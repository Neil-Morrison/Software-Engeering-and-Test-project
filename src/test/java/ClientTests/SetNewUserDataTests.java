//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 29/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package ClientTests;

import SoftwareProject.Client.SetNewUserData;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SetNewUserDataTests {

    private SetNewUserData data;

    @BeforeAll
    static void startTests(){
        System.out.println("Beginning Tests for SetNewUserData");
    }

    @AfterAll
    static void finishedTest(){
        System.out.println("Finished Tests for SetNewUserData");
    }

    @BeforeEach
    void init(TestInfo testinfo, TestReporter testreporter){
        testreporter.publishEntry(("Testing " + testinfo.getDisplayName()));
    }

    @DisplayName("Constructor")
    @Test
    @Order(1)
    void TestConstructor() {
        data = new SetNewUserData("Neil", "888888888", "neil@gmail.com", "873564526");
        assertEquals("Neil", data.getUser());
        assertEquals("888888888", data.getPass());
        assertEquals("neil@gmail.com", data.getEmail());
        assertEquals("873564526", data.getPhone());
    }
    @DisplayName("setName")
    @Test
    @Order(2)
    void TestUserName() {
        final String error1 = "The user name cannot be null";
        Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new SetNewUserData(null,"888888888", "neil@gmail.com", "873564526"));
        assertEquals(error1, titleException.getMessage());
    }

    @DisplayName("setPassword")
    @Test
    @Order(3)
    void TestPassword() {
        final String error1 = "The password must be at least 7 digits long";
        Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new SetNewUserData("Neil","34534", "neil@gmail.com", "873564526"));
        assertEquals(error1, titleException.getMessage());
    }

    @DisplayName("setEmail")
    @Test
    @Order(3)
    void TestEmail() {
        final String error1 = "The email must be type email";
        Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new SetNewUserData("Neil","888888888", "neilgmail.com", "873564526"));
        assertEquals(error1, titleException.getMessage());
    }

    @DisplayName("setPhone")
    @Test
    @Order(3)
    void TestPhone() {
        final String error1 = "The phone number must be 9 digits";
        Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new SetNewUserData("Neil","888888888", "neil@gmail.com", "3434"));
        assertEquals(error1, titleException.getMessage());
    }
}
