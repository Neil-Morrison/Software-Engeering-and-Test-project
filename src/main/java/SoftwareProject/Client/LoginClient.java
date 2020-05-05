//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 27/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.*;
import javax.swing.*;
import static java.awt.Color.*;
import static java.lang.System.exit;

public class LoginClient extends GuiHolder{

    private JFrame Mainframe;
    static String Clientname;

    public LoginClient(JFrame frame, JFrame Mainframe, int frame_width, int frame_height, String path) {
        if (frame != null)
            window = frame;
        else
            throw new IllegalArgumentException("The JFrame must be swing object not null");
        File tempFile = new File(path);
        if (tempFile.exists())
            image = path;
        else
            throw new IllegalArgumentException("Path does not exist for the background image for Login Frame");
        if (!(frame_width > 400) && !(frame_width < 399))
            width = frame_width;
        else
            throw new IllegalArgumentException("Frame width must be 400");
        if (!(frame_height > 600) && !(frame_height < 599))
            height = frame_height;
        else
            throw new IllegalArgumentException("Frame height must be 600");
        this.Mainframe = Mainframe;
    }
    public LoginClient() { }
    public void run(){
        setSize();
        setUserFields();
        setButtonName("Login");
        setGui();
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int check = JOptionPane.showConfirmDialog(window,"Are you sure you want to exit", "Exit", -1);
                if (check == 0){
                    if (socket != null)
                        disconnect();
                    exit(0);
                }
            }
        });
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connect("35.175.253.195", 6000);
                String username = userFeild.getText();
                String pass = passFeild.getText();
                String message = "login+" + username + "+" + pass;
                SendReceive.sendMessage(socket, message);
                String rec = SendReceive.receiveMessage(socket);
                String image_path = "src/main/resources/pictures/hero.png";
                if (rec.equals("Access Granted")){
                    Clientname = username;
                    new MainGui(window, Mainframe, socket, width, height, image_path).run();
                } else{
                    JOptionPane.showConfirmDialog(window,"Incorrect Details", "Details", -1);
                }
            }
        });
    }
    public void setGui(){
        background = new JLabel(new ImageIcon(getImage()));
        background.add(title);
        background.add(userText);
        background.add(passText);
        background.add(userFeild);
        background.add(passFeild);
        background.add(login);
        window.getContentPane().add(background);
        window.setVisible(true);
    }
    public void connect(String ServerAddress, int ServerPort) {
        //String zeroTo255 = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";
        //String pattern = zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255;
        //if (ServerAddress.matches(pattern)){
            serverIp = ServerAddress;
        //}else{
        //   throw new IllegalArgumentException("This doesn't match ip address pattern");
        //}
        if (ServerPort > 0 && ServerPort < 65000){
            portnum = ServerPort;
        }else{
            throw new IllegalArgumentException("port number must be between 0 and 65000");
        }
        try {
            socket = new Socket(serverIp, portnum);
            connection = true;
        } catch (IOException e) {
            throw new IllegalArgumentException("A problem occurred when trying to open the SocketChannel");
        }
    }
    public void disconnect() {
        try {
            socket.close();
            Sockclosed = true;
        } catch (IOException e) {
            throw new IllegalArgumentException("A problem occurred when trying to close the SocketChannel");
        }
    }
    public void setButtonName(String name){
        ButtonName = name;
        login = new Button();
        login.setBounds(150,400,100,30);
        if (name.equals("Login")){
            login.setLabel(ButtonName);
            buttonName = true;
        }else{
            throw new IllegalArgumentException("Name should be Login");
        }
    }
    public void setUserFields(){
        userFeild = new JTextField();
        passFeild = new JPasswordField();
        userText = new JLabel("Username");
        passText = new JLabel("Password");
        title = new JLabel("Login Page");
        title.setForeground(orange);
        Font font = getFont("Times New Roman", 25);
        title.setFont(font);
        title.setBounds(120,50, 150,50);
        userText.setBounds(50, 150, 60, 35);
        userFeild.setBounds(50, 180, 300, 35);
        passText.setBounds(50, 210, 60, 35);
        passFeild.setBounds(50, 240, 300, 35);
        userFeild.setBackground(orange);
        passFeild.setBackground(orange);
    }
    public void setSize(){
        window.setSize(this.width, this.height);
    }
    public Font getFont(String font, int size){
        if (findfont(font)){
            fontText = font;
        } else{
            throw new IllegalArgumentException("Font type does not exist");
        }
        if (size > 10 && size < 30){
            font_size = size;
        }
        else{
            throw new IllegalArgumentException("Font size must be greater than 10 and less than 30");
        }
        return new Font(fontText, Font.BOLD, font_size);
    }
    public static boolean findfont(String font) {
        GraphicsEnvironment g= null;
        g=GraphicsEnvironment.getLocalGraphicsEnvironment();
        String []fonts=g.getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
            if((fonts[i]).equals(font)){
                return true;
            }
        }
        return false;
    }
    public static void returned(){
        userFeild.setText("");
        passFeild.setText("");
    }




}