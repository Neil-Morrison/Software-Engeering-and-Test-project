package SoftwareProject;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ClientHandler extends Thread implements Runnable {
    private boolean quit;
    final Socket s;

    public ClientHandler(Socket s) {
        this.s = s;
        this.quit = false;
    }


    public void run() {
        String clientResponse = "";
        //System.out.println("ClientHandler Started for " + this.socketChannel+ Thread.currentThread());
        //System.out.println("This is whats connected"+ChatServer.sock);
        int j = 0;
        for (Socket sc : Server.sock) {
            System.out.println("Connection No: " + (j + 1));
            System.out.println(sc);
            j++;
        }
       
        int count = 1;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        //HelperMethods.sendMessage(socketChannel, "Hello From Server");
        if (Server.sock.size() == 1) {
            try {
                HelperMethods.sendMessage(s, "Hello From Server");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        while (running) {

            if (s != null) {
                // while (running) {

                try {
                    clientResponse = HelperMethods.receiveMessage(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                CheckQuit(clientResponse);
                System.out.println(clientResponse);
                if (clientResponse.equalsIgnoreCase("quit")) {
                    try {
                        HelperMethods.sendMessage(s, "Server terminating\r\nSocket Channel Closed");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        s.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    running = false;
                } else {
                    for (Socket sc : Server.sock) {
                        if (sc != s) {
                            try {
                                HelperMethods.sendMessage(sc, clientResponse);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.println("Socket " + s.toString() + " sent: " + count + " message");
                            count++;
                        }
                    }

                }

            }
        }
        System.out.println("ClientHandler Terminated for " + this.s);
    }


    public void CheckQuit(String clientResponse) {
        if (clientResponse.equalsIgnoreCase("quit")) {
            System.out.println("Server terminating");
            quit = true;
        } else {
            quit = false;
        }
    }

    public boolean isQuit() {
        return quit;
    }
}