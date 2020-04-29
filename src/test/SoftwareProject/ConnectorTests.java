//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Thomas Martin +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 27/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConnectorTests {
    @BeforeAll
    public static void Setup(){
        System.out.println("Starting Connector Tests");
    }

    @Test
    public void ConstructorAndConnect(){
        boolean thrown = false;
        try {
            new Connector();
        } catch (Exception e) {
            thrown = true;
        }

        assertEquals(false,thrown);
    }

    @Test
    public void FindFromSQL(){
        User user = null;
        try {
            user = new Connector().findUser("Neil");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(User.class, user.getClass());
    }

    @Test
    public void InsertToSQL(){
        int result = 0;
        try {
            result = new Connector().insertNewUser("Frank","1234","Frank@gmail.com",856783442L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1,result);
    }
}
