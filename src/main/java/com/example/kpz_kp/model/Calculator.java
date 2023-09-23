package com.example.kpz_kp.model;

public class Calculator {
    private final double tax = 0.05;
    private final double compensation = 20.0;
    public double getTotalPrice(double price_for1 , int size ){
        return (price_for1*size)+((price_for1*size)*tax);
    }

    public double getChange(double price, double payment) {
        double change = payment - price;
        if (change < 0){
            return -1;
        } else {
            return change;
        }
    }

    public double getCompensation(double price) {
        return (Math.round(price * compensation)) / 100.0;
    }
}
