package SoftwareProject.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HelperMethods {

    public static boolean sent = false;
    public static boolean received = false;

    public static void sendMessage(Socket socketChannel, String message) throws IOException {
        PrintWriter output = new PrintWriter(socketChannel.getOutputStream());
        System.out.println("Sending: " + message);
        output.write(message);
        output.flush();
        sent = true;
    }

    public static String receiveMessage(Socket socketChannel) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(socketChannel.getInputStream()));
        String message = input.readLine();
        System.out.println("Receiving: " + message);
        received = true;
        return message;
    }
}