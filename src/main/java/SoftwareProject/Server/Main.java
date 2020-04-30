package SoftwareProject.Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket();
            new Server(socket,"localhost",6000).Start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}