package com.example.kpz_kp;

import com.example.kpz_kp.model.DataBase;
import com.example.kpz_kp.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;

public class ServiceTest {

    @Test
    void getServiceListTest(){
        Service service = new Service();
        DataBase db = new DataBase();
        Connection connection = db.getDBConnection("jarvan4" , "shivana");
        ArrayList<String> res = service.getServiceList(connection);
        Assertions.assertAll( () -> Assertions.assertEquals("Друк фото" , res.get(0)),
                            () -> Assertions.assertEquals("Сканування " , res.get(3)),
                            () ->Assertions.assertEquals("ЧБ друк" , res.get(4)));
    }

    @Test
    void getPriceFor1Test(){
        Service service = new Service();
        DataBase db = new DataBase();
        Connection connection = db.getDBConnection("jarvan4" , "shivana");
        ArrayList<String> prep = service.getServiceList(connection);
        double res = service.getPriceFor1("ЧБ друк");
        Assertions.assertEquals(3.00 ,res);
    }
}
