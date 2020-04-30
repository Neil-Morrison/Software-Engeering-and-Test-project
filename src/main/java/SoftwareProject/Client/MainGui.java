//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 27/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.net.Socket;

import static java.awt.Color.orange;
import static java.lang.System.exit;

public class MainGui extends LoginClient{

    private JFrame window, MainFrame;
    private JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9, text10;
    private Socket socket;
    private String image_path;
    private int width, height;
    private JMenu system;
    private JMenuBar menubar;
    private JTextField Clientmess, Servermess;
    public static Action AddUser, Group_info, Logout;


    public MainGui(JFrame frame, JFrame mainFrame, Socket socket, int width, int height, String path) {
        super();
        if (frame != null)
            this.window = frame;
        else
            throw new IllegalArgumentException("The JFrame must be swing object not null");
        if (mainFrame != null)
            this.MainFrame = mainFrame;
        else
            throw new IllegalArgumentException("The Main Frame must be swing object not null");
        if (socket != null)
            this.socket = socket;
        else
            throw new IllegalArgumentException("The Socket Cannot be null");
        File tempFile = new File(path);
        if (tempFile.exists())
            this.image_path = path;
        else
            throw new IllegalArgumentException("Path does not exist for the background image for Main Frame");
        if (!(width > 400) && !(width < 399))
            this.width = width;
        else
            throw new IllegalArgumentException("Frame width must be 400");
        if (!(height > 600) && !(height < 599))
            this.height = height;
        else
            throw new IllegalArgumentException("Frame height must be 600");
    }

    public void run(){
        SetLoginFalse();
        setSize();
        SetupFields();
        StartGui();
        MainFrame.addWindowListener(new WindowAdapter() {
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
    }

    public void SetLoginFalse(){
        window.setVisible(false);
    }

    public void StartGui(){
        background = new JLabel(new ImageIcon(image_path));
        background.add(Clientmess);
        setupMenu();
        MainFrame.getContentPane().add(background);
        MainFrame.getContentPane().add(BorderLayout.NORTH, menubar);
        MainFrame.setVisible(true);
    }

    public void setupMenu(){
        menubar = new JMenuBar();
        system = new JMenu("Options");
        menubar.add(system);
        AddUser = new MenuActions("AddUser", MainFrame, window, socket);
        system.add(AddUser);
        Group_info = new MenuActions("Group_info", MainFrame, window, socket);
        system.add(Group_info);
        Logout = new MenuActions("Logout", MainFrame, window, socket);
        system.add(Logout);
    }

    public void setSize(){
        MainFrame.setSize(this.width, this.height);
    }

    public void SetupFields(){
        Clientmess = new JTextField();
        Servermess = new JTextField();
        Clientmess.setBounds(15, 565, 300, 35);
        Clientmess.setBackground(orange);
    }
}
