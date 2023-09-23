package com.example.kpz_kp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ViewOrderTest {

    @Test
    void view_orderTest1(){
        String start = "2023-06-07";
        String end = "2023-06-11";
        String res;
        if (start != null && end != null){
            res = "Замовлення виведені на екран";
        } else{
            res = "Оберіть дати пошуку!";
        }
        Assertions.assertEquals("Замовлення виведені на екран" , res);
    }

    @Test
    void view_orderTest2(){
        String start = null;
        String end = null;
        String res;
        if (start != null && end != null){
            res = "Замовлення виведені на екран";
        } else{
            res = "Оберіть дати пошуку!";
        }
        Assertions.assertEquals("Оберіть дати пошуку!" , res);
    }
}
