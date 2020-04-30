//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 29/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.List;


public class NewUserGui extends JFrame{

    private JTextField userField, passField, emailField;
    private Button apply;
    private JLabel user, pass, email ,background;
    private Socket sock;

    public NewUserGui(Socket sock) {
        this.sock = sock;
    }
    public void run(){
        final JFrame smallwindow = new JFrame("Add User");
        String path = "src\\main\\resources\\pictures\\hero.png";
        background = new JLabel(new ImageIcon(path));
        smallwindow.setResizable(false);
        smallwindow.setSize(300, 300);
        setUpUserFields();
        background.add(user);
        background.add(userField);
        background.add(pass);
        background.add(passField);
        background.add(email);
        background.add(emailField);
        background.add(apply);
        smallwindow.getContentPane().add(background);
        smallwindow.setVisible(true);
        final SetNewUserData data = new SetNewUserData();
        apply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                data.setUserData(userField.getText());
                data.setUserData(passField.getText());
                data.setUserData(emailField.getText());
                List<String> Userlist = data.getUserData();
                if (Userlist.size() >= 3) {
                    SendReceive.sendList(sock, Userlist);
                    smallwindow.setVisible(false);
                }else
                    JOptionPane.showConfirmDialog(smallwindow,"All fields must be filled in", "Error", -1);
            }
        });
    }
    public void setUpUserFields(){
        userField = new JTextField();
        passField = new JPasswordField();
        emailField = new JTextField();
        user = new JLabel("Username");
        pass = new JLabel("Password");
        email = new JLabel("Email");
        apply = new Button("Apply");
        user.setBounds(15, 50, 80, 30);
        pass.setBounds(15,100, 80, 30);
        email.setBounds(15, 150, 80, 30);
        userField.setBounds(90, 50, 180, 30);
        passField.setBounds(90,100, 180, 30);
        emailField.setBounds(90, 150, 180, 30);
        apply.setBounds(120,220, 50, 30);
    }
}