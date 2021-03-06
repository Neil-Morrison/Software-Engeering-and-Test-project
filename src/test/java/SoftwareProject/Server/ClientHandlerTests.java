package SoftwareProject.Server;//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Denis Whelan +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 24/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
import SoftwareProject.Server.ClientHandler;
import SoftwareProject.Server.Server;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

public class ClientHandlerTests {
    private  ServerSocket socketChannel;
    private Socket s;

    @BeforeAll
    static void startTests(){
        System.out.println("Beginning ClientHandler Tests");
    }

    @AfterAll
    static void finishedTest(){
        System.out.println("Finished ClientHandler Tests");
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
    @Order(1)
    public void TestConstructor() throws IOException {
        Server server = new Server(socketChannel,"172.31.2.109",6000);
        assertTrue(server.isSocket());
        assertEquals("172.31.2.109", server.getHost());
        assertEquals(6000, server.getPortnum());
    }
    @DisplayName("Test Quit")
    @Test
    @Order(2)
    public void TestQuit(){
        //If "quit" is sent across the server will recognise and terminate server
        Server server = new Server(socketChannel,"172.31.2.109",6000);
        ClientHandler cl = new ClientHandler(s);
        cl.CheckQuit("quit");
        assertTrue(cl.isQuit());
    }
}
