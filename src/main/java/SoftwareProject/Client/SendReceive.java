//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 30/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SendReceive {

    public static boolean sent = false;
    public static boolean received = false;

    public static void sendMessage(Socket socketChannel, String message) {
        if (socketChannel != null){
            PrintWriter output = null;
            try {
                output = new PrintWriter(socketChannel.getOutputStream());
                if (!message.contains("+"))
                    System.out.println("Sending: " + message);
                else
                    System.out.println("Sending: ****************");
                output.write(message + "\n");
                output.flush();
                sent = true;
            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("There was a problem sending message from Client");
            }
        }
        else
            throw new IllegalArgumentException("The Socket Cannot be null");
    }

    public static String receiveMessage(Socket socketChannel) {
        if (socketChannel != null) {
            BufferedReader input = null;
            try {
                input = new BufferedReader(new InputStreamReader(socketChannel.getInputStream()));
                String message = input.readLine();
                System.out.println("Receiving: " + message);
                if (message != null) {
                    received = true;
                    System.out.println("NOT NULL");
                    return message;
                }else
                    throw new IllegalArgumentException("The message received was null");

            } catch (IOException e) {
                e.printStackTrace();
                throw new IllegalArgumentException("There was a problem receiving message from server");
            }
        }
        else
            throw new IllegalArgumentException("The Socket Cannot be null");
    }
}
