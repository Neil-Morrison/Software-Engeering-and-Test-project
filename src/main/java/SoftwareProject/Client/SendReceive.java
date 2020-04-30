package SoftwareProject.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendReceive {

    public static void sendMessage(Socket socketChannel, String message) {
        PrintWriter output = null;
        try {
            output = new PrintWriter(socketChannel.getOutputStream());
            System.out.println("Sending: " + message);
            output.write(message);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String receiveMessage(Socket socketChannel) {
        BufferedReader input = null;
        try {
            input = new BufferedReader(new InputStreamReader(socketChannel.getInputStream()));
            String message = input.readLine();
            System.out.println("Receiving: " + message);
            return message;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
