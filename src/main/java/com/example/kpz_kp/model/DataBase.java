package com.example.kpz_kp.model;

import com.example.kpz_kp.LoginController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DataBase {
    public Connection getDBConnection(String user, String pass) {
        String connectionString="jdbc:mysql://localhost:3306/kpz_kp";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection connection;
        try {
            connection = DriverManager.getConnection(connectionString, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public int newOrder(Connection connection, String service_name, int size, double price, String client, String phone) {
        try {
            PreparedStatement statement = connection.prepareStatement("insert into orders (service_name , order_size , order_price, order_date, order_status, client_name , client_phone) \n" +
                    "values (? , ? , ? , CURRENT_TIMESTAMP(), 'У черзі' , ? , ?);");
            statement.setString(1, service_name);
            statement.setInt(2, size);
            statement.setDouble(3, price);
            statement.setString(4, client);
            statement.setString(5, "+".concat(phone));
            statement.execute();
            statement = connection.prepareStatement("select order_id from orders order by order_id desc limit 1;");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            int res = resultSet.getInt("order_id");
            connection.close();
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double cancelOrder(Connection connection, int id) {
        try{
            PreparedStatement statement = connection.prepareStatement("select order_price from orders where order_id = ?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            double res;
            if (!resultSet.next()){
                res = -1;
            } else {
                res = resultSet.getDouble("order_price");
                statement = connection.prepareStatement("delete from orders where order_id = ?");
                statement.setInt(1, id);
                statement.execute();
            }
            return res;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Order> getOrders(String start , String end) {
        Connection connection = this.getDBConnection(LoginController.getUserLogin() , LoginController.getUserPassword());
        ObservableList<Order> orders = FXCollections.observableArrayList();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from orders where order_date between ? and ?;");
            statement.setString(1, start);
            statement.setString(2, end);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Order order = new Order(resultSet.getInt("order_id"), resultSet.getString("service_name"), resultSet.getInt("order_size"),
                        resultSet.getDouble("order_price"), resultSet.getString("order_date"), resultSet.getString("order_status"),
                        resultSet.getString("client_name"),resultSet.getString("client_phone"));
                orders.add(order);
            }
            connection.close();
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int changeOrder(int id) {
        Connection connection = this.getDBConnection(LoginController.getUserLogin() , LoginController.getUserPassword());
        try {
            PreparedStatement statement = connection.prepareStatement("select order_id from orders where order_id = ?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                statement = connection.prepareStatement("update orders set order_status = 'Виконано' where order_id = ?;");
                statement.setInt(1, id);
                statement.execute();
                connection.close();
                return 1;
            } else {
                connection.close();
                return -1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
