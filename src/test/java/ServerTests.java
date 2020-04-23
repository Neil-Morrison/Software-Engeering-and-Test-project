//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Denis Whelan +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 23/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package test.java;
import main.java.SoftwareProject.Server;
import org.junit.jupiter.api.*;

import java.net.Socket;
import java.nio.channels.ServerSocketChannel.*;
import java.nio.channels.SocketChannel;

import static org.junit.jupiter.api.Assertions.*;


public class ServerTests {
    private Socket socketChannel;

    @BeforeAll
    public void setup(){
        socketChannel = new Socket();
    }
    @Test
    public void TestConstructor(){

        Server server = new Server(socketChannel,"localhost",3000);
//        assertEquals("",server.getSocket());
        assertEquals("localhost",server.getHost());
        assertEquals(3000,server.getPortnum());

    }
//    @Test
//    public void TestPortAvailable(){
//
//    }
//    @Test
//    public void TestServerOpen(){
//
//    }
//    @Test
//    public void TestBind(){
//
//    }
//    @Test
//    public void TestSocketTeardown(){
//
//    }

}

