//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 29/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import java.util.ArrayList;
import java.util.List;

public class SetNewUserData {

    private List<String> UserData = new ArrayList<String>();

    public void setUserData(String userData) {
        if (userData !=null)
            UserData.add(userData);
        else
            throw new IllegalArgumentException("Data Cannot be null");
    }

    public List<String> getUserData() {
        return UserData;
    }
}
