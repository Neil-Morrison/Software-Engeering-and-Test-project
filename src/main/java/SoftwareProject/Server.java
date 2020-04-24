//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Denis Whelan +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 23/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    private ServerSocket socket;
    private int portnum;
    private String host;
    private ServerSocket server;
    private boolean closed;
    private boolean socketOpen;
    private boolean isSocket;
    private boolean portcheck;


    public Server(ServerSocket sock, String host, int port) {
        if (!sock.isClosed()){
            this.socket = sock;
            this.isSocket = true;
        }
        else{
            throw new IllegalArgumentException("Socket is already connected");
        }
        if (!(port <= 0) && port < 65000) {
            this.portnum = port;
        }
        else{
            throw new IllegalArgumentException("the port number has to be between 1 and 65000");
        }
        if (host.equals("localhost")){
            this.host = host;
        }
        else{
            throw new IllegalArgumentException("Host name must be localhost");
        }
        this.closed = false;
    }

    public void Start(){
        try {
            SocketOpen(host, portnum);
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
            socket = new ServerSocket(port);
            socket.close();
            portcheck = true;
        }catch (Exception e){
            throw new  IllegalArgumentException("Port already in use");
        }

    }

    public void SocketOpen(String host, int port)  {
        try {
            socket = new ServerSocket(port);
            socketOpen = true;
        } catch (IOException e) {
            System.out.println(e);
            throw new IllegalArgumentException("Socket wont open");
        }
    }

    public void SocketClose(ServerSocket socketChannel)   {
        try {
            socketChannel.close();
            closed = true;
        }catch(Exception e){
            throw new IllegalArgumentException("An error occurred when closing the socket");
        }
    }

    public boolean getSocketOpen() {
        return socketOpen;
    }


    public int getPortnum() {
        return portnum;
    }


    public String getHost() {
        return host;
    }

    public boolean getclosed() {
        return closed;
    }
    public boolean isSocket() {
        return isSocket;
    }

    public boolean isPortcheck() {
        return portcheck;
    }

}