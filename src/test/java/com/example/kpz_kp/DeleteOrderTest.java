package com.example.kpz_kp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteOrderTest {

    @Test
    void delete_orderTest1(){
        String id = "1";
        double compensation = 5.00;
        String res;
        if (id.matches("\\d+")){
            if (compensation == -1){
                res="Даного замовлення не існує, компенсація недоступна!";
            } else {
                res = "Замовлення успішно скасоване.";
            }
        } else {
            res = "Помилка, номер замовлення має бути цілим числом!";
        }
        Assertions.assertEquals("Замовлення успішно скасоване." , res);
    }

    @Test
    void delete_orderTest2(){
        String id = "1";
        double compensation = -1;
        String res;
        if (id.matches("\\d+")){
            if (compensation == -1){
                res="Даного замовлення не існує, компенсація недоступна!";
            } else {
                res = "Замовлення успішно скасоване.";
            }
        } else {
            res = "Помилка, номер замовлення має бути цілим числом!";
        }
        Assertions.assertEquals("Даного замовлення не існує, компенсація недоступна!" , res);
    }

    @Test
    void delete_orderTest3(){
        String id = "asd";
        double compensation = -1;
        String res;
        if (id.matches("\\d+")){
            if (compensation == -1){
                res="Даного замовлення не існує, компенсація недоступна!";
            } else {
                res = "Замовлення успішно скасоване.";
            }
        } else {
            res = "Помилка, номер замовлення має бути цілим числом!";
        }
        Assertions.assertEquals("Помилка, номер замовлення має бути цілим числом!" , res);
    }
}
