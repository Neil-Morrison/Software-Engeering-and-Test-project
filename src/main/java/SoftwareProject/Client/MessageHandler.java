//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 01/05/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;

public class MessageHandler extends Thread implements Runnable {

    private JFrame frame;
    private Socket sock;
    volatile boolean ClientRunning;
    public static int ServerCount = -1;

    public MessageHandler(JFrame frame, Socket socket) {
        this.frame = frame;
        this.sock = socket;
        ClientRunning = true;
    }

    public void run() {
        while(ClientRunning){
            JLabel ServMess = new JLabel();
            String ServerMessage = SendReceive.receiveMessage(sock);
            String[] mess = ServerMessage.split("\\+");
            String Mess_to_show = mess[2] + ": " +  mess[1];
            MainGui.clientCount =  MainGui.clientCount + 1;
            ServerCount = ServerCount +1;
            if (ServerCount == 0){
                ServMess.setText(Mess_to_show);
                ServMess.setForeground(Color.BLUE);
                ServMess.setBounds(200,  6, 310, 10);
                MainGui.textArea.add(ServMess);
                frame.repaint();
            }else if(ServerCount == 1){
                ServMess.setText(Mess_to_show);
                ServMess.setForeground(Color.BLUE);
                ServMess.setBounds(200, 43, 310, 10);
                MainGui.textArea.add(ServMess);
                frame.repaint();
            }else{
                int count = ServerCount * 20;
                ServMess.setText(Mess_to_show);
                ServMess.setForeground(Color.BLUE);
                ServMess.setBounds(200, count * 2, 310, 10);
                MainGui.textArea.add(ServMess);
                frame.repaint();
            }

        }
    }
}
