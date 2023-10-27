package com.example.kpz_kp.QA_lab5;

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
    void Class1Test(){
        String id = "15";
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
    void Class2Test(){
        String id = "15,4";
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

    @Test
    void Class3Test(){
        String id = "-4";
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

    @Test
    void Class4Test(){
        String id = "44";
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
}
