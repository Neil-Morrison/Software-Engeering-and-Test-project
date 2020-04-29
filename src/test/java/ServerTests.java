//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Denis Whelan +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 23/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

import SoftwareProject.ClientHandler;
import SoftwareProject.Server;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

public class ServerTests {
    private static Server server;
    private static ServerSocket socketChannel;

    @BeforeAll
    static void startTests(){
        System.out.println("Beginning Tests");

        ServerSocket socket = null;
        try {
            socket = new ServerSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
        socketChannel = socket;
        server = new Server(socketChannel,"localhost",3000);
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
//        ServerSocket socket = new ServerSocket();
//        socketChannel = socket;
    }


    @DisplayName("Constructor")
    @Test
    @Order(1)
    public void TestConstructor() throws IOException {
//        Server server = new Server(socketChannel,"localhost",3000);
        assertTrue(server.isSocket());
        assertEquals("localhost", server.getHost());
        assertEquals(3000, server.getPortnum());
    }
    @DisplayName("Check port")
    @Test
    @Order(2)
    public void TestPort() {
//        Server server = new Server(socketChannel,"localhost",3000);
        server.CheckportNumber(server.getPortnum());
        assertTrue(server.isPortcheck());

    }

    @DisplayName("Sockets Open")
    @Test
    @Order(3)
    public void TestServerOpen() {
//        Server server = new Server(socketChannel,"localhost",3000);
        server.SocketOpen(server.getPortnum());
        assertTrue(server.getSocketOpen());

    }
    @DisplayName("Socket Bound")
    @Test
    @Order(4)
    public void TestSocketBound() {
//        Server server = new Server(socketChannel,"localhost",3000);
        //server.SocketBound(socketChannel,"localhost",3000);
        assertTrue(server.getBound());


    }
    @DisplayName("Socket closes")
    @Test
    @Order(5)
    public void TestSocketTeardown() {
//        Server server = new Server(socketChannel,"localhost",3000);
        server.SocketClose(socketChannel);
        assertTrue(server.getclosed());
    }
    @DisplayName("Thread Start")
    @Test
    @Order(5)
    public void TestThreadStart() {
//        Server server = new Server(socketChannel,"localhost",3000);
        server.NewThread();
        assertTrue(server.isStarted());
    }
    @DisplayName("Thread Stop")
    @Test
    @Order(5)
    public void TestThreadStop() {
//        Server server = new Server(socketChannel,"localhost",3000);
//        server.NewThread();
        server.StopThread();
        assertFalse(ClientHandler.isThreadrun());

    }
}

