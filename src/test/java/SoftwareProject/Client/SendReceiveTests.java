//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 30/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.assertTrue;
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class SendReceiveTests {

    private static Socket socket;

    @BeforeAll
    static void startTests(){
        System.out.println("Beginning Tests for SendReceive Message");
        socket = new Socket();
        try {
            socket = new Socket("35.175.253.195", 6000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    static void finishedTest(){
        System.out.println("Finished Tests for SendReceive Message");
    }

    @BeforeEach
    void init(TestInfo testinfo, TestReporter testreporter){
        testreporter.publishEntry(("Testing " + testinfo.getDisplayName()));
    }

    @DisplayName("Sending Message")
    @Test
    @Order(1)
    void TestASendingMessage() {
        SendReceive.sendMessage(socket, "quit+server");
        assertTrue(SendReceive.sent);
    }

    @DisplayName("Receiving Message")
    @Test
    @Order(2)
    void TestBReceivingMessage() {
        SendReceive.receiveMessage(socket);
        assertTrue(SendReceive.received);
    }
}
