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
import java.awt.event.ActionEvent;
import java.nio.channels.SocketChannel;

public class MenuActions{

//    private String name;
//    private JFrame frame;
//    private StreamingTread thread;
//    private SocketChannel socketChannel;
//    private SetData data;
//    private StreamingTread Player;
//    public static int Count = 0;
//
//    public MenuActions(String name, JFrame frame, SocketChannel socketChannel , SetData data) {
//        super(name);
//        putValue( NAME, name );
//        this.name = name;
//        this.frame = frame;
//        this.socketChannel = socketChannel;
//        this.data = data;
//        this.Player = new StreamingTread(socketChannel, data.getquailty(), data.getframes(), frame);
//    }
//    public void actionPerformed(ActionEvent e) {
//        switch (name) {
//            case "About":
//                // load text file
//                System.out.println("About");
//                new About();
//                break;
//            case "Start Stream":
//                Count = Count + 1;
//                GameGui.Stream.setEnabled(false);
//                GameGui.Stop.setEnabled(true);
//                GameGui.audio.setEnabled(false);
//                GameGui.video.setEnabled(false);
//                frame.remove(GameGui.background);
//                frame.add(new PlayGif(frame)).setBackground(Color.black);
//                frame.revalidate();
//                frame.repaint();
//                Thread thread = new Thread(Player);
//                thread.start();
//                System.out.println("Stream");
//                break;
//            case "Audio":
//                // volume options
//                // sound on/off
//                System.out.println("audio");
//                break;
//            case "Video":
//                new VideoOptions(data);
//                System.out.println("video");
//                break;
//            case "Controller":
//                System.out.println("Controller");
//                // connect controller with bluetooth
//                break;
//            case "Stop Streaming":
//                // Stop the stream or the gif
//                String image = "C:\\Users\\neilm\\IdeaProjects\\GaminGui\\src\\MainGui\\Gifs\\ps4_wall_5.jpg";
//                JLabel background = new JLabel(new ImageIcon(image));
//                frame.remove(new PlayGif(frame));
//                frame.setBackground(Color.DARK_GRAY);
//                frame.getColorModel();
//                frame.add(background);
//                PlayGif.Gif = null;
//                Player.killThread();
//                GameGui.Stop.setEnabled(false);
//                GameGui.Stream.setEnabled(true);
//                GameGui.audio.setEnabled(true);
//                GameGui.video.setEnabled(true);
//                frame.revalidate();
//                frame.repaint();
//                Methods.sendMessage(socketChannel, "Stop Streaming");
//                new Stream(null,null).stop();
//                System.out.println("Stop Stream");
//                break;
//            case "Exit":
//                System.exit(0);
//                break;
//        }
//    }
}
