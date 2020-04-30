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
        JFrame frame = new JFrame("Messaging App");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        String path = "src/main/resources/pictures/background.png";
        new LoginClient(frame, 400, 600, path).run();

    }

}