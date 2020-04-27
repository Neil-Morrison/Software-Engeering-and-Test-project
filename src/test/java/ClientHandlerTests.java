import SoftwareProject.ClientHandler;
import SoftwareProject.Server;
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
        Server server = new Server(socketChannel,"localhost",3000);
        assertTrue(server.isSocket());
        assertEquals("localhost", server.getHost());
        assertEquals(3000, server.getPortnum());
    }
    @Test
    @Order(2)
    public void TestQuit(){
        Server server = new Server(socketChannel,"localhost",3000);
        ClientHandler cl = new ClientHandler(s);
        cl.CheckQuit("quit");
        assertTrue(cl.isQuit());
    }
}
