//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Thomas Martin +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 28/04/2020 +
//+ 
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Server;


public class User {
    private String name;
    private String password;
    private String email;
    private long phone;

    public User(String name, String password, String email, long phone) {
        if(name.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("No Name");
        }else{
            this.name = name;
        }
        if(password.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("No Password");
        }else{
            this.password = password;
        }
        if(email.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("No Email");
        }else{
            this.email = email;
        }
        if(phone/100000000 != 8) {
            throw new IllegalArgumentException("Incorrect Phone");
        }else{
            this.phone = phone;
        }
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
