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

public class SendReceiveTests {

    private Socket socket;
    private SendReceive sendreceive;

    @BeforeAll
    static void startTests(){
        System.out.println("Beginning Tests for SendReceive Message");
    }

    @AfterAll
    static void finishedTest(){
        System.out.println("Finished Tests for SendReceive Message");
    }

    @BeforeEach
    void init(TestInfo testinfo, TestReporter testreporter){
        testreporter.publishEntry(("Testing " + testinfo.getDisplayName()));
    }

    @BeforeEach
    void Setup(){
        socket = new Socket();
        try {
            socket = new Socket("34.247.38.113", 6000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Sending Message")
    @Test
    @Order(1)
    void TestSendingMessage() {
        SendReceive.sendMessage(socket, "quit+server");
        assertTrue(SendReceive.sent);
    }

    @DisplayName("Receiving Message")
    @Test
    @Order(2)
    void TestReceivingMessage() {
        SendReceive.receiveMessage(socket);
        assertTrue(SendReceive.received);
    }
}
