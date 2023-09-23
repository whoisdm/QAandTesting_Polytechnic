package com.example.kpz_kp;

import com.example.kpz_kp.model.DataBase;;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class DataBaseTest {

    @Test
    void cancelOrderTest1(){
        DataBase db = new DataBase();
        Connection connection = db.getDBConnection("jarvan4" , "shivana");
        double res = db.cancelOrder(connection, 2);
        Assertions.assertEquals(75.00 ,res);
    }

    @Test
    void cancelOrderTest2(){
        DataBase db = new DataBase();
        Connection connection = db.getDBConnection("jarvan4" , "shivana");
        double res = db.cancelOrder(connection, 3);
        Assertions.assertEquals(-1 ,res);
    }

    @Test
    void getOrdersTest(){
        DataBase db = new DataBase();
        LoginController.authorizeUser("jarvan4" , "shivana","менеджер");
        String res = db.getOrders("2023-06-7", "2023-06-12").get(0).getService_name();
        Assertions.assertEquals( "Друк фото",res);
    }

    @Test
    void changeOrderTest1(){
        DataBase db = new DataBase();
        LoginController.authorizeUser("jarvan4" , "shivana","менеджер");
        int res = db.changeOrder(1);
        Assertions.assertEquals(1 ,res);
    }

    @Test
    void changeOrderTest2(){
        DataBase db = new DataBase();
        LoginController.authorizeUser("jarvan4" , "shivana","менеджер");
        int res = db.changeOrder(3);
        Assertions.assertEquals(-1 ,res);
    }
}
