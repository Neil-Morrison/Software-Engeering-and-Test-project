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

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    @BeforeEach
    void Setup(){
      data = new SetNewUserData();
    }
    @DisplayName("Adding Data To List")
    @Test
    @Order(1)
    void TestAddingDataToList() {
        data.setUserData("Denise");
        data.setUserData("Thomaseena");
        List<String> userdata = data.getUserData();
        assertEquals(2, userdata.size());
    }
    @DisplayName("Names are correct")
    @Test
    @Order(2)
    void TestCorrectstring() {
        List<String> testing = Arrays.asList("Thomas", "Denis", "Neil");
        data.setUserData("Thomas");
        data.setUserData("Denis");
        data.setUserData("Neil");
        assertEquals(testing, data.getUserData());
    }
}
