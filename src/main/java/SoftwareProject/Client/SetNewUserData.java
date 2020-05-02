//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP                                            +
//+ .LANGUAGE: Java                                                    +
//+ .FRAMEWORK: Maven                                                  +
//+ .AUTHOR: Neil Morrison                                             +
//+ .COLLEGE: Galway-Mayo institute of Technology                      +
//+ .DATE: 29/04/2020                                                  +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Client;

import java.util.List;

public class SetNewUserData {

    String user;
    String pass;
    String email;
    String phone;
    List<String> userData;

    public SetNewUserData(){}

    public SetNewUserData(String user, String pass, String email, String phone) {
        if (user != null)
            this.user = user;
        else
            throw new IllegalArgumentException("The user name cannot be null");
        if (pass.length() > 7)
            this.pass = pass;
        else
            throw new IllegalArgumentException("The password must be at least 7 digits long");
        if (email.contains("@"))
            this.email = email;
        else
            throw new IllegalArgumentException("The email must be type email");
        if (phone.length() == 9)
            this.phone = phone;
        else
            throw new IllegalArgumentException("The phone number must be 9 digits");
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getUserData(){
        userData.add(user);
        userData.add(pass);
        userData.add(phone);
        userData.add(email);
        return userData;
    }

    public void setUser(String user) {
        if (user != null)
            this.user = user;
        else
            throw new IllegalArgumentException("The user name cannot be null");
    }

    public void setPass(String pass) {
        if (pass.length() > 7)
            this.pass = pass;
        else
            throw new IllegalArgumentException("The password must be at least 7 digits long");
    }

    public void setEmail(String email) {
        if (email.contains("@"))
            this.email = email;
        else
            throw new IllegalArgumentException("The email must be type email");
    }

    public void setPhone(String phone) {
        if (phone.length() == 9)
            this.phone = phone;
        else
            throw new IllegalArgumentException("The phone number must be 9 digits");
    }
}
