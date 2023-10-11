package com.example.kpz_kp.QA;

import com.example.kpz_kp.LoginController;
import com.example.kpz_kp.controller.Register;
import com.example.kpz_kp.model.Calculator;
import com.example.kpz_kp.model.DataBase;
import com.example.kpz_kp.model.Organization;
import com.example.kpz_kp.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeOrderTest {

    @Test
    void ChangeOrderTest3(){
        String id = "12";
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        register.init_change();

        String res;

        if (id.matches("\\d+")){
            int change_res = register.changeOrder(Integer.parseInt(id));
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
    void ChangeOrderTest2(){
        String id = "13";
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        register.init_change();

        String res;

        if (id.matches("\\d+")){
            int change_res = register.changeOrder(Integer.parseInt(id));
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
    void ChangeOrderTest0(){
        String id = "qwerty";
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        register.init_change();

        String res;

        if (id.matches("\\d+")){
            int change_res = register.changeOrder(Integer.parseInt(id));
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
