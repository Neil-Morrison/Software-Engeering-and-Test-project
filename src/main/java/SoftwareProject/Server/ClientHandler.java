//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Denis Whelan +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 24/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread implements Runnable {
    private boolean quit;
    private Connector connector;
    final Socket s;
    static volatile boolean threadrun = true;

    public ClientHandler(Socket s, Connector connector) {
        this.s = s;
        this.quit = false;
        this.connector = connector;
    }
    public ClientHandler(Socket s) {
        this.s = s;
        this.quit = false;
    }


    public void run() {
        while(threadrun) {
            String clientResponse = "";
            String response[] = null;
            //Not sure what this does, currently not entering it with one client
            int j = 0;
            for (Socket sc : Server.sock) {
                System.out.println("Connection No: " + (j + 1));
                System.out.println(sc);
                j++;
            }

            int count = 1;
            boolean running = true;

            while (running) {
                if (s != null) {
                    while(clientResponse.equalsIgnoreCase("")) {
                        try {
                            clientResponse = HelperMethods.receiveMessage(s);
                            response = clientResponse.split("\\+");
                        } catch (IOException e) {
                            System.err.println("No response");
                        }
                    }
                    System.out.println(clientResponse);
                    CheckQuit(clientResponse);
                    System.out.println(clientResponse);
                    if (response[0].equalsIgnoreCase("quit")) {
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
                    } else if(response[0].equalsIgnoreCase("message")) {
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

                    } else if(response[0].equalsIgnoreCase("login")){
                        User attemptedUser = connector.findUser(response[1]);
                        if(attemptedUser.getPassword().equals(response[2])){
                            try {
                                HelperMethods.sendMessage(s,"Access Granted\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else{
                            try{
                                HelperMethods.sendMessage(s,"Access Denied");
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                clientResponse = "";
                }
            }
            System.out.println("ClientHandler Terminated for " + this.s);
        }
        System.out.println("Threadrun false");
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
    public static boolean isThreadrun() {
        return threadrun;
    }
}