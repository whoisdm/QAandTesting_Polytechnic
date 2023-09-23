package com.example.kpz_kp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Service {
    private ArrayList<String> service_list = new ArrayList<>();
    private HashMap<String, Double> price_list = new HashMap<>();

    public ArrayList<String> getServiceList(Connection conn){
        try{
            PreparedStatement statement = conn.prepareStatement("select * from services;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                this.service_list.add(resultSet.getString("service_name"));
                this.price_list.put(resultSet.getString("service_name"), resultSet.getDouble("service_price"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return service_list;
    }

    public double getPriceFor1(String choice){
        return price_list.get(choice);
    }
}
