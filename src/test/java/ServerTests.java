//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Denis Whelan +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 23/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

import SoftwareProject.Server;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.ServerSocket;

import static org.junit.jupiter.api.Assertions.*;


public class ServerTests {

    private  ServerSocket socketChannel;

    @BeforeAll
    static void startTests(){
        System.out.println("Beginning Tests");
    }

    @AfterAll
    static void finishedTest(){
        System.out.println("Finished Tests");
    }

    @BeforeEach
    void init(TestInfo testinfo, TestReporter testreporter){
        testreporter.publishEntry(("Testing " + testinfo.getDisplayName()));
    }

    @BeforeEach
    public void Setup() throws IOException {
        ServerSocket socket = new ServerSocket();
        socketChannel = socket;
    }

    @DisplayName("Constructor")
    @Test
    public void TestConstructor() throws IOException {
        Server server = new Server(socketChannel,"localhost",3000);
        assertTrue(server.isSocket());
        assertEquals("localhost", server.getHost());
        assertEquals(3000, server.getPortnum());
    }



}

