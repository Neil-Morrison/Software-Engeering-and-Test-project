//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 28/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import javax.swing.*;
import java.awt.*;
import java.net.Socket;

public class GuiHolder {

    static JTextField userFeild, passFeild;
    static JLabel userText, passText, title;
    static Socket socket;
    JFrame window;
    Button login;
    JLabel background;
    String image;
    String ButtonName;
    boolean connection;
    public boolean Sockclosed;
    public boolean buttonName;
    String serverIp;
    String fontText;
    int portnum;
    int width;
    int height;
    int font_size;


    public JFrame getWindow() {
        return window;
    }


    public static Socket getSocket() {
        return socket;
    }

    public JLabel getBackground() {
        return background;
    }

    public String getImage() {
        return image;
    }

    public String getButtonName() {
        return ButtonName;
    }

    public boolean isConnection() { return connection; }

    public String getServerIp() {
        return serverIp;
    }

    public int getPortnum() {
        return portnum;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getFont_size() {
        return font_size;
    }

    public String getFontText() {
        return fontText;
    }

}
