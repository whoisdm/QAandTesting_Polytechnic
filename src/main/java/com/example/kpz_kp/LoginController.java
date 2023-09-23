package com.example.kpz_kp;


import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class LoginController {
    private static String userLogin;
    private static String userPassword;
    private static String UserRole;

    public static void authorizeUser(String userLogin, String userPassword, String UserRole) {
        LoginController.userLogin = userLogin;
        LoginController.userPassword = userPassword;
        LoginController.UserRole = UserRole;
    }
    public static int loginCheck(String user, String pass){
        String connectionString="jdbc:mysql://localhost:3306/kpz_kp";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            return -1;
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(connectionString, user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM kpz_kp.users where user_login = ?;");
            preparedStatement.setString(1, user);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            LoginController.authorizeUser(resultSet.getString("user_login"), resultSet.getString("user_pass"),resultSet.getString("user_role"));
            connection.close();
            return 1;
        } catch (SQLException e) {
            return -1;
        }
    }

    public static String getUserLogin() {
        return userLogin;
    }

    public static String getUserPassword() {
        return userPassword;
    }

    public static String getUserRole() {
        return UserRole;
    }
}
