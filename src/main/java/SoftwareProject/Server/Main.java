package SoftwareProject.Server;

import SoftwareProject.Server.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket();
            new Server(socket,"172.31.2.109",6000).Start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //new Server(,"localhost",6000).Start();
    }
}
