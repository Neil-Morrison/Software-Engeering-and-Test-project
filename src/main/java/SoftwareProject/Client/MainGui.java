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
import java.awt.event.*;
import java.io.File;
import java.net.Socket;

import static java.awt.Color.orange;
import static java.lang.System.exit;

public class MainGui extends LoginClient{

    public JFrame window;
    public JFrame MainFrame;
    private Socket socket;
    public String image_path;
    public int width;
    public int height;
    private JMenu system;
    private JMenuBar menubar;
    private JTextField Clientmess;
    public static Action AddUser, Group_info, Logout;
    public static int clientCount = -1;
    static JTextPane textArea;
    Action action;
    JButton SendButton;


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
        new MessageHandler(MainFrame, socket).start();
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
        Clientmess.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                Clientmess.setText("");
            }
            @Override
            public void focusLost(FocusEvent e) {
            }
        });
        SendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = "message+" + Clientmess.getText() + "+" +  LoginClient.Clientname + "\n";
                System.out.println(message);
                messageArea(message);
                SendReceive.sendMessage(socket, message);
                Clientmess.setText("Enter Message!");
            }
        });
    }

    public void SetLoginFalse(){
        window.setVisible(false);
    }

    public void StartGui() {
        background = new JLabel(new ImageIcon(image_path));
        ImageIcon arrow = new ImageIcon("src\\main\\resources\\pictures\\sendButton.png");
        SendButton = new JButton(arrow);
        setupMenu();
        textArea = new JTextPane();
        JScrollPane scroll = new JScrollPane (textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textArea.add(background);
        textArea.setSize(new Dimension(300,240));
        SendButton.setBounds(315, 510, 50, 30);
        textArea.add(Clientmess);
        textArea.add(SendButton);
        MainFrame.getContentPane().add(BorderLayout.NORTH, menubar);
        MainFrame.getContentPane().add(BorderLayout.CENTER, scroll);
        Clientmess.addActionListener( action );
        MainFrame.setResizable(false);
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
        Clientmess.setBounds(5, 510, 310, 32);
        Clientmess.setBackground(orange);
    }
    public void messageArea(String message) {
        String[] mess = message.split("\\+");
        JLabel name = new JLabel();
        clientCount = clientCount + 1;
        MessageHandler.ServerCount = MessageHandler.ServerCount + 1;
        if (clientCount == 0){
            name.setText(mess[1]);
            name.setBounds(5,  6, 310, 10);
            textArea.add(name);
            MainFrame.repaint();
        }else if(clientCount == 1){
            name.setText(mess[1]);
            name.setBounds(5, 43, 310, 10);
            textArea.add(name);
            MainFrame.repaint();
        }else{
            int count = clientCount * 20;
            name.setText(mess[1]);
            name.setBounds(5, count * 2, 310, 10);
            textArea.add(name);
            MainFrame.repaint();
        }
    }
}

