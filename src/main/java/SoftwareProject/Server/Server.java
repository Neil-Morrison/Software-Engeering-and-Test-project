//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Denis Whelan +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 23/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    static ArrayList<Socket> sock = new ArrayList<Socket>();

    private ServerSocket socket;
    private int portnum;
    private String host;
    private ServerSocket server;
    private boolean closed;
    private boolean bound;
    private boolean socketOpen;
    private boolean isSocket;
    private boolean portcheck;
    private boolean started;
    private boolean stopped;
    private boolean running = true;
    private Connector connector;
    public Socket incomingsocket;
    private Thread ClienthandlerTests;

    public Server(ServerSocket sock, String host, int port) {
        if (!sock.isClosed()) {
            this.socket = sock;
            this.isSocket = true;
        } else {
            throw new IllegalArgumentException("Socket is already connected");
        }
        if (!(port <= 0) && port < 65000) {
            this.portnum = port;
        } else {
            throw new IllegalArgumentException("the port number has to be between 1 and 65000");
        }
//        if (host.equals("localhost")) {
            this.host = host;
//        } else {
//            throw new IllegalArgumentException("Host name must be localhost");
//        }
        this.closed = false;
        this.bound = false;
        this.started = false;
        this.stopped = false;
        try {
            connector = new Connector();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Start() {
        try {
            CheckportNumber(portnum);
            SocketOpen(portnum);
            SocketBound(socket, host, portnum);
            System.out.println("Waiting for Client ...\r\n");
            while (running) {
                incomingsocket = socket.accept();
                System.out.println("New Socket: " + socket.toString());
                sock.add(incomingsocket);
                NewThread();
            }
        } catch (Exception ex) {
            SocketClose(socket);
            ex.printStackTrace();
        }
    }

    public void CheckportNumber(int port) {
        try {
            port = socket.getLocalPort();
            System.out.println(port);
            portcheck = true;
        } catch (Exception e) {
            throw new IllegalArgumentException("Port already in use");
        }
    }

    public void SocketOpen(int port) {
        try {
            socket = new ServerSocket();
            socketOpen = true;
        } catch (IOException e) {
            System.out.println(e);
            throw new IllegalArgumentException("Socket wont open");
        }
    }

    public void SocketBound(ServerSocket socketChannel, String host, int port) {
        try {
            socketChannel.bind(new InetSocketAddress(host, port));
            bound = true;
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred when closing the socket");
        }
    }

    public void SocketClose(ServerSocket socketChannel) {
        try {
            socketChannel.close();
            closed = true;
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred when closing the socket");
        }
    }

    public void NewThread() {
        try {
            System.out.println("Starting New Thread");
            ClienthandlerTests = new ClientHandler(incomingsocket, connector);
            ClienthandlerTests.start();
            started = true;
        } catch (Exception e) {
            throw new IllegalArgumentException("Thread Cant start");
        }
    }
    public boolean getSocketOpen() {
        return socketOpen;
    }
    public Socket getIncomingsocket(){
        return incomingsocket;
    }
    public int getPortnum() {
        return portnum;
    }
    //public Boolean getBound() { return socket.isBound(); }
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
    public boolean isBound() {
        return bound;
    }
    public boolean isStarted() {
        return started;
    }
    public boolean isStopped() {
        return stopped;
    }

}