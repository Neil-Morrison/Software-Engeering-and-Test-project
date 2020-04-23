//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Denis Whelan +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 23/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package main.java.SoftwareProject;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class Server {
    private Socket socket;
    private int portnum;
    private String host;
    private DataInputStream input;
    private DataOutputStream output;
    private ServerSocket server;
    public Server(Socket sock, String host, int port){
        this.socket = sock;
        this.portnum = port;
        this.host = host;
        try {
            CheckportNumber(port);
            SocketOpen(host,port);

            boolean running = true;
            while (running) {
                System.out.println("Waiting for Client ...\r\n");
                Socket socketChannel = server.accept();
                System.out.println("New Socket: " + socketChannel.toString());
            }
        }catch (Exception ex) {
            SocketClose(socket);
            ex.printStackTrace();
        }
    }
    public void CheckportNumber(int port) {
        try {
            Socket sock = new Socket("localhost",port);
            sock.close();

        }catch (Exception e){
            throw new  IllegalArgumentException("Port already in use");
        }

    }
    public void SocketOpen(String host, int port)  {
        try {
            Socket sock = new Socket(host,port);
            socket = sock;
        } catch (IOException e) {
            throw new IllegalArgumentException("Socket wont open");
        }
    }
    public void SocketSend(Socket socketChannel) throws IOException {
       input = new DataInputStream(socketChannel.getInputStream());
    }
    public void SocketReceive(Socket socketChannel) throws IOException {
        output = new DataOutputStream(socketChannel.getOutputStream());
    }
    public void SocketClose(Socket socketChannel)   {
        try {
            socketChannel.close();
        }catch(Exception e){
            throw new IllegalArgumentException("An error occurred when closing the socket");
        }
    }
    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getPortnum() {
        return portnum;
    }

    public void setPortnum(int portnum) {
        this.portnum = portnum;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

}

