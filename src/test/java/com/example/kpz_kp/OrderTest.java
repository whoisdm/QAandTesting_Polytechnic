package com.example.kpz_kp;

import com.example.kpz_kp.model.Calculator;
import com.example.kpz_kp.model.DataBase;
import com.example.kpz_kp.model.Order;
import com.example.kpz_kp.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

public class OrderTest {

    @Test
    void getPriceTest(){
        Calculator calculator = new Calculator();
        Order order = new Order();
        DataBase db = new DataBase();
        Connection connection = db.getDBConnection("jarvan4" , "shivana");
        Service service = new Service();
        ArrayList<String> lsit = order.getServiceList(connection,service);
        double res = order.getPrice("Друк фото", 4, calculator);
        Assertions.assertEquals(63.00 ,res);
    }

}
