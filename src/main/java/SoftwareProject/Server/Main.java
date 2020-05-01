package SoftwareProject.Server;

import SoftwareProject.Server.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket();
            new Server(socket,"34.255.98.100",6000).Start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //new Server(,"localhost",6000).Start();
    }
}
