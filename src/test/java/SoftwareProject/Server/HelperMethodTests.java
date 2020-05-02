package SoftwareProject.Server;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class HelperMethodTests {
    private Socket socket;
    private ServerSocket serverSocket;

    @BeforeAll
    public static void Setup(){
        System.out.println("Starting tests for Helper Methods");
    }

    @BeforeEach
    public void init() throws IOException {
        if(serverSocket != null && serverSocket.isBound())
            serverSocket.close();
        socket = new Socket();
        serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(3525));
    }
    @Test
    public void testSendMessage() {
        boolean thrown = false;

        try {
            HelperMethods.sendMessage(socket,"Hello World!");
        } catch (IOException e) {
            e.printStackTrace();
            thrown = true;
        }
        assertEquals(false, thrown);

    }

    @Test
    public void testReceiveMessage() {
        String received = null;
        try {
            received = HelperMethods.receiveMessage(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(received, "Hello World!");

    }
}
