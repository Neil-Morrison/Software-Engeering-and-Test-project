//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 28/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.Socket;

public class MenuActions extends AbstractAction {

    private String name;
    private JFrame frame, window;
    private Socket sock;

    public MenuActions(String name, JFrame MainFrame, JFrame window, Socket sock){
        super(name);
        putValue( NAME, name );
        this.name = name;
        this.frame = MainFrame;
        this.window = window;
        this.sock = sock;
    }
    public void actionPerformed(ActionEvent e) {
        if ("AddUser".equals(name)) {
            new NewUserGui(sock).run();
        } else if ("Group_info".equals(name)) {
            System.out.println("Group_info");

        } else if ("Logout".equals(name)) {
            frame.setVisible(false);
            window.setVisible(true);
            LoginClient.returned();
            System.out.println("Logout");

        }
    }
}
