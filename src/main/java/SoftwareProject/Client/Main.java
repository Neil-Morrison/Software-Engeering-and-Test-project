//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 27/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame LoginFrame = new JFrame("Messaging App");
        JFrame MainFrame = new JFrame("Messaging App");
        LoginFrame.setResizable(false);
        MainFrame.setResizable(false);
        LoginFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        MainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        String path = "src\\main\\resources\\pictures\\background.png";
        new LoginClient(LoginFrame, MainFrame, 400, 600, path).run();

    }

}