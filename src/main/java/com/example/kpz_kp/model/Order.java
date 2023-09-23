package com.example.kpz_kp.model;

import javafx.collections.ObservableList;

import java.sql.Connection;
import java.util.ArrayList;

public class Order {
    private int number;
    private String service_name;
    private int size;
    private double price;
    private String date;
    private String status;
    private String clientName;
    private String phone;

    private Service service;
    private Calculator calculator;
    private Organization organization;
    private DataBase dataBase;
    private Connection conn;
    public ArrayList<String> getServiceList(Connection conn, Service service){
        this.service = service;
        this.conn = conn;
        return service.getServiceList(conn);
    }

    public double getPrice(String choice , int size, Calculator calculator) {
        this.service_name = choice;
        this.size = size;
        this.calculator = calculator;
        double price_for1 = service.getPriceFor1(choice);
        this.price = calculator.getTotalPrice(price_for1 , size);
        return this.price;
    }

    public double makePayment(String name , String phone , double payment , Organization organization, DataBase db){
        this.organization = organization;
        this.dataBase = db;
        double order_res = calculator.getChange(price, payment);
        if (order_res != -1){
            this.clientName = name;
            this.phone = phone;
            this.number = this.dataBase.newOrder(this.conn, this.service_name, this.size , this.price , this.clientName, this.phone);
            organization.printCheck(this.service_name , this.size , this.price , this.number);
        }
        return order_res;
    }

    public double cancelOrder(int id, DataBase db, Calculator calculator, Connection connection) {
        double compensation = db.cancelOrder(connection,id);
        if (compensation!=-1){
            compensation = calculator.getCompensation(compensation);
        }
        return compensation;
    }

    public Order() {
    }

    public Order(int number, String service_name, int size, double price, String date, String status, String clientName, String phone) {
        this.number = number;
        this.service_name = service_name;
        this.size = size;
        this.price = price;
        this.date = date;
        this.status = status;
        this.clientName = clientName;
        this.phone = phone;
    }

    public ObservableList<Order> getOrders(DataBase db, String start , String end) {
        return db.getOrders(start, end);
    }

    public int getNumber() {
        return number;
    }

    public String getService_name() {
        return service_name;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhone() {
        return phone;
    }

    public int changeOrder(int id, DataBase db) {
        return db.changeOrder(id);
    }
}
