//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//+ .Project: Messaging APP+
//+ .LANGUAGE: Java +
//+ .FRAMEWORK: Maven +
//+ .AUTHOR: Thomas Martin +
//+ .COLLEGE: Galway-Mayo institute of Technology +
//+ .DATE: 27/04/2020 +
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package SoftwareProject.Server;

import java.sql.*;

public class Connector {
    private PreparedStatement sqlInsertNew;
    private PreparedStatement sqlFind;
    private Connection connection;
    public Connector() throws Exception{

            connect();
            sqlInsertNew = connection.prepareStatement(
                    "INSERT INTO users ( name, password, email, phone ) " +
                            "VALUES ( ? , ? ,?,?);" );
            sqlFind = connection.prepareStatement(
                    "SELECT * from users WHERE users.name = ? ;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    private void connect() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/AndroidDB";
        String driver = "com.mysql.cj.jdbc.Driver";

        // load database driver class
        Class.forName( driver );

        // connect to database
        connection = DriverManager.getConnection( url , "root", "mynewpassword" );

        // Require manual commit for transactions. This enables
        // the program to rollback transactions that do not
        // complete and commit transactions that complete properly.
        connection.setAutoCommit( false );
    }

    public int insertNewUser(String name, String password, String email, long phone){
        int result = 0;
        try {
            sqlInsertNew.setString(1,name);
            sqlInsertNew.setString(2,password);
            sqlInsertNew.setString(3,email);
            sqlInsertNew.setLong(4,phone);

            result = sqlInsertNew.executeUpdate();
            connection.commit();
            System.out.println(sqlInsertNew);
        } catch (SQLException throwables) {
            try {
                System.out.println("failed @ "+throwables.getMessage());
                connection.rollback(); // rollback update

            }

            // handle exception rolling back transaction
            catch ( SQLException exception ) {
                exception.printStackTrace();
            }
        }
        return result;
    }

    public User findUser(String username){
        User user = null;
        try {
            sqlFind.setString(1, username);
            ResultSet resultSet = sqlFind.executeQuery();
            System.out.println(sqlFind);

            if(!resultSet.next())
                return null;

            String name = resultSet.getString(1);
            String password = resultSet.getString(2);
            String email = resultSet.getString(3);
            long phone = Long.parseLong(resultSet.getString(4));

            user = new User(name,password,email,phone);

            System.out.println(user.toString());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return user;
    }
}
