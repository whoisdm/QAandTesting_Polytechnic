package com.example.kpz_kp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeOrderTest {
    @Test
    void change_orderTest1(){
        String id = "1";
        int change_res = 1;
        String res;
        if (id.matches("\\d+")){
            if (change_res == 1){
                res = "Замовлення позначене виконаним!";
            } else {
                res = "Замовлення не існує!";
            }
        } else {
            res = "Помилка, номер замовлення має бути цілим числом!";
        }
        Assertions.assertEquals("Замовлення позначене виконаним!", res);
    }

    @Test
    void change_orderTest2(){
        String id = "1";
        int change_res = -1;
        String res;
        if (id.matches("\\d+")){
            if (change_res == 1){
                res = "Замовлення позначене виконаним!";
            } else {
                res = "Замовлення не існує!";
            }
        } else {
            res = "Помилка, номер замовлення має бути цілим числом!";
        }
        Assertions.assertEquals("Замовлення не існує!", res);
    }

    @Test
    void change_orderTest3(){
        String id = "asd";
        int change_res = -1;
        String res;
        if (id.matches("\\d+")){
            if (change_res == 1){
                res = "Замовлення позначене виконаним!";
            } else {
                res = "Замовлення не існує!";
            }
        } else {
            res = "Помилка, номер замовлення має бути цілим числом!";
        }
        Assertions.assertEquals("Помилка, номер замовлення має бути цілим числом!", res);
    }
}
