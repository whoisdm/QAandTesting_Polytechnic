package com.example.kpz_kp.controller;

import com.example.kpz_kp.LoginController;
import com.example.kpz_kp.model.*;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Register {

    private final Service service;
    private Connection connection;
    private Order order;
    private final Calculator calculator;
    private final Organization organization;
    private final DataBase dataBase;

    public Register(Service service, Calculator calculator, Organization organization, DataBase dataBase) {
        this.service = service;
        this.calculator = calculator;
        this.organization = organization;
        this.dataBase = dataBase;
    }

    public ArrayList<String> init(){
        order = new Order();
        connection = dataBase.getDBConnection(LoginController.getUserLogin(), LoginController.getUserPassword());
        return order.getServiceList(connection, service);
    }

    public double getPrice(String choice, int size){
        return order.getPrice(choice, size, this.calculator);
    }

    public double makePayment(String name , String phone , double payment){
        return order.makePayment(name , phone ,payment, organization, dataBase);
    }


    public void init_del() {
        order = new Order();
        connection = dataBase.getDBConnection(LoginController.getUserLogin(), LoginController.getUserPassword());
    }
    public double cancelOrder(int id) {
        double res = order.cancelOrder(id, this.dataBase, this.calculator,this.connection);
        try{
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public void init_view() {
        order = new Order();
    }

    public ObservableList<Order> getOrders(String start , String end) {
        return order.getOrders(dataBase, start , end);
    }

    public void init_change() {
        order = new Order();
    }

    public int changeOrder(int id) {
        return order.changeOrder(id, this.dataBase);
    }
}
