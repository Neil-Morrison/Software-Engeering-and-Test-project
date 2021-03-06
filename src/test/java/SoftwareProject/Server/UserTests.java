//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Thomas Martin +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 28/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Server;
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

    @Test
    public void NameGetter(){
        User user = new User();
        user.setName("John");
        assertEquals("John", user.getName());
    }
    @Test
    public void PasswordGetter(){
        User user = new User();
        user.setPassword("ABCD");
        assertEquals("ABCD", user.getPassword());
    }
    @Test
    public void EmailGetter(){
        User user = new User();
        user.setEmail("MAIL");
        assertEquals("MAIL", user.getEmail());
    }
    @Test
    public void PhoneGetter(){
        User user = new User();
        user.setPhone(858451443);
        assertEquals(858451443, user.getPhone());
    }
}
