//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 27/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import org.junit.jupiter.api.*;
import javax.swing.*;
import java.io.IOException;
import java.net.Socket;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MainGuiTests {

    private JFrame frame, MainFrame;
    private String path;
    private Socket socket;

    @BeforeAll
    static void startTests(){
        System.out.println("Beginning Tests for Main Gui");
    }

    @AfterAll
    static void finishedTest(){
        System.out.println("Finished Tests for Main Gui");
        
    }

    @BeforeEach
    void init(TestInfo testinfo, TestReporter testreporter){
        testreporter.publishEntry(("Testing " + testinfo.getDisplayName()));
    }

    @BeforeEach
    void Setup(){
        frame = new JFrame("Messaging App");
        MainFrame = new JFrame("Messaging App");
        socket = new Socket();
        path = "src/main/resources/pictures/hero.png";
    }

    @DisplayName("Constructor for Main Page")
    @Test
    @Order(1)
    void TestConstructor() {
        MainGui gui = new MainGui(frame, MainFrame, socket, 400, 600, path);
        assertEquals(frame, gui.window);
        assertEquals(MainFrame, gui.MainFrame);
        assertEquals(400, gui.width);
        assertEquals(600, gui.height);
        assertEquals(path, gui.image_path);
    }

    @DisplayName("JFrame Object")
    @Test
    @Order(2)
    void TestJframeObject() {
        final String error1 = "The JFrame must be swing object not null";
        Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new MainGui(null, MainFrame, socket, 400, 600, path));
        assertEquals(error1, titleException.getMessage());
    }

    @DisplayName("Main JFrame Object")
    @Test
    @Order(3)
    void TestMainJframeObject() {
        final String error1 = "The Main Frame must be swing object not null";
        Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new MainGui(frame, null, socket, 400, 600, path));
        assertEquals(error1, titleException.getMessage());
    }

    @DisplayName("Socket Object")
    @Test
    @Order(4)
    void TestSocketObject() {
        final String error1 = "The Socket Cannot be null";
        Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new MainGui(frame, MainFrame, null, 400, 600, path));
        assertEquals(error1, titleException.getMessage());
    }

    @DisplayName("width of Gui")
    @Test
    @Order(5)
    void TestWidth() {
        final String error1 = "Frame width must be 400";
        Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new MainGui(frame, MainFrame, socket, 40, 600, path));
        assertEquals(error1, titleException.getMessage());
    }

     @DisplayName("Path for background picture")
     @Test
     @Order(5)
     void TestHeightGui() {
         final String error1 = "Frame height must be 600";
         Exception titleException = assertThrows(IllegalArgumentException.class, ()-> new MainGui(frame, MainFrame, socket, 400, 600, "/find/picture"));
         assertEquals(error1, titleException.getMessage());
        
     }
}
