package com.example.kpz_kp.QA;

import com.example.kpz_kp.LoginController;
import com.example.kpz_kp.controller.Register;
import com.example.kpz_kp.model.Calculator;
import com.example.kpz_kp.model.DataBase;
import com.example.kpz_kp.model.Organization;
import com.example.kpz_kp.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteOrderTest {

    @Test
    void DeleteOrderTest3(){
        String id = "12";
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        register.init_del();

        String res;

        if (id.matches("\\d+")){
            double compensation = register.cancelOrder(Integer.parseInt(id));
            if (compensation == -1){
                res ="Даного замовлення не існує, компенсація недоступна!";
            } else {
                res = "Замовлення успішно скасоване, компенсація: " + compensation +" грн.";
            }
        } else {
            res = "Помилка, номер замовлення має бути цілим числом!";
        }

        Assertions.assertEquals("Замовлення успішно скасоване, компенсація: 12.6 грн.", res);
    }

    @Test
    void DeleteOrderTest2(){
        String id = "13";
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        register.init_del();

        String res;

        if (id.matches("\\d+")){
            double compensation = register.cancelOrder(Integer.parseInt(id));
            if (compensation == -1){
                res ="Даного замовлення не існує, компенсація недоступна!";
            } else {
                res = "Замовлення успішно скасоване, компенсація: " + compensation +" грн.";
            }
        } else {
            res = "Помилка, номер замовлення має бути цілим числом!";
        }

        Assertions.assertEquals("Даного замовлення не існує, компенсація недоступна!", res);
    }

    @Test
    void DeleteOrderTest0(){
        String id = "qwerty";
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        register.init_del();

        String res;

        if (id.matches("\\d+")){
            double compensation = register.cancelOrder(Integer.parseInt(id));
            if (compensation == -1){
                res ="Даного замовлення не існує, компенсація недоступна!";
            } else {
                res = "Замовлення успішно скасоване, компенсація: " + compensation +" грн.";
            }
        } else {
            res = "Помилка, номер замовлення має бути цілим числом!";
        }

        Assertions.assertEquals("Помилка, номер замовлення має бути цілим числом!", res);
    }
}
