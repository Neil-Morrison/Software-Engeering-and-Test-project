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


public class NewUserGui extends JFrame{

    private JTextField userField, passField, emailField,phoneField;
    private Button apply;
    private JLabel user, pass, email ,phone, background;
    private Socket sock;

    public NewUserGui(Socket sock) {
        this.sock = sock;
    }
    public void run(){
        final JFrame smallwindow = new JFrame("Add User");
        String path = "src\\main\\resources\\pictures\\hero.png";
        background = new JLabel(new ImageIcon(path));
        smallwindow.setResizable(false);
        smallwindow.setSize(300, 350);
        setUpUserFields();
        background.add(user);
        background.add(userField);
        background.add(pass);
        background.add(passField);
        background.add(email);
        background.add(emailField);
        background.add(phone);
        background.add(phoneField);
        background.add(apply);
        smallwindow.getContentPane().add(background);
        smallwindow.setVisible(true);
        final SetNewUserData data = new SetNewUserData(null, null,null,null);
        apply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                data.user = userField.getText();
                data.pass = passField.getText();
                data.email = emailField.getText();
                data.phone = phoneField.getText();
                if (data.getUser() != null && data.getPass() != null && data.getEmail() != null && data.getPhone() != null) {
                    String NewUser = "NewUser+" + data.getUser() + "+" + data.getPass() + "+" + data.getEmail() + "+" + data.getPhone() + "\n";
                    SendReceive.sendMessage(sock, NewUser);
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
        phoneField = new JTextField();
        phone = new JLabel("Phone");
        user = new JLabel("Username");
        pass = new JLabel("Password");
        email = new JLabel("Email");
        apply = new Button("Apply");
        user.setBounds(15, 50, 80, 30);
        pass.setBounds(15,100, 80, 30);
        email.setBounds(15, 150, 80, 30);
        phone.setBounds(15, 200, 80, 30);
        userField.setBounds(90, 50, 180, 30);
        passField.setBounds(90,100, 180, 30);
        emailField.setBounds(90, 150, 180, 30);
        phoneField.setBounds(90, 200, 180, 30);
        apply.setBounds(120,270, 50, 30);
    }
}