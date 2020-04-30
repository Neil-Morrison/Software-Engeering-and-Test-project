//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Thomas Martin +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 28/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject;

//import org.junit.Test;
import SoftwareProject.Server.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests {

    @BeforeAll
    public static void Setup(){
        System.out.println("Starting tests for User Class");
    }

   @Test
    public void GoodConstructor(){
        User user = new User("John","ABCD","john@gmail.com", 858451443L);
        assertEquals(User.class, user.getClass());
    }
    @Test
    public void NoNameConstructor(){
        boolean thrown = false;
        try{
            User user = new User("","ABCD","john@gmail.com", 858451443L);
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertEquals(true,thrown);
    }
    @Test
    public void NoPasswordConstructor(){
        boolean thrown = false;
        try{
            User user = new User("John","","john@gmail.com", 858451443L);
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertEquals(true,thrown);
    }
    @Test
    public void NoEmailConstructor(){
        boolean thrown = false;
        try{
            User user = new User("John","ABCD","", 858451443L);
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertEquals(true,thrown);
    }
    @Test
    public void NoPhoneConstructor(){
        boolean thrown = false;
        try{
            User user = new User("John","ABCD","john@gmail.com",12L );
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertEquals(true,thrown);
    }
}
