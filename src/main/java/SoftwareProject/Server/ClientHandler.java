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

public class ClientHandler extends Thread implements Runnable {
    private boolean quit;
    private Connector connector;
    final Socket PassableSocket;
    static volatile boolean threadrun = true;

    public ClientHandler(Socket sock, Connector connector) {
        this.PassableSocket = sock;
        this.quit = false;
        this.connector = connector;
    }
    public ClientHandler(Socket sock) {
        this.PassableSocket = sock;
        this.quit = false;
    }

    public void run() {
        while(threadrun) {
            String clientResponse = "";
            String response[] = null;
            int j = 0;
            for (Socket sc : Server.sock) {
                System.out.println("Connection No: " + (j + 1));
                System.out.println(sc);
                j++;
            }
            int count = 1;
            boolean running = true;
            while (running) {
                if (PassableSocket != null) {
                    while(clientResponse.equalsIgnoreCase("")) {
                        try {
                            clientResponse = HelperMethods.receiveMessage(PassableSocket);
                            response = clientResponse.split("\\+");
                        } catch (IOException e) {
                            System.err.println("No response");
                            try {
                                PassableSocket.close();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    }
                    System.out.println(clientResponse);
                    CheckQuit(clientResponse);
                    System.out.println(clientResponse);
                    if (response[0].equalsIgnoreCase("quit")) {
                        try {
                            HelperMethods.sendMessage(PassableSocket, "Server terminating\n");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            PassableSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        running = false;
                    } else if(response[0].equalsIgnoreCase("message")) {
                        for (Socket sc : Server.sock) {
                            if (sc != PassableSocket) {
                                try {
                                    HelperMethods.sendMessage(sc, clientResponse+"\n");
                                    System.out.println("Sending message: "+clientResponse+ "\nTO: "+sc+"\nFROM: "+PassableSocket);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                System.out.println("Socket " + PassableSocket.toString() + " sent: " + count + " message");
                                count++;
                            }
                        }
                    } else if(response[0].equalsIgnoreCase("login")){
                        User attemptedUser = connector.findUser(response[1]);
                        if(attemptedUser.getPassword().equals(response[2])){
                            try {
                                HelperMethods.sendMessage(PassableSocket,"Access Granted\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }else{
                            try{
                                HelperMethods.sendMessage(PassableSocket,"Access Denied\n");
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }else if(response[0].equalsIgnoreCase("NewUser")){
                        connector.insertNewUser(response[1],response[2],response[3],Long.parseLong(response[4]));
                    }
                clientResponse = "";
                }
            }
            System.out.println("ClientHandler Terminated for " + this.PassableSocket);
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