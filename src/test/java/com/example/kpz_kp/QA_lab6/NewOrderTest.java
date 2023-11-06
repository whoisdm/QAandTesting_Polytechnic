package com.example.kpz_kp.QA_lab6;

import com.example.kpz_kp.LoginController;
import com.example.kpz_kp.controller.Register;
import com.example.kpz_kp.model.Calculator;
import com.example.kpz_kp.model.DataBase;
import com.example.kpz_kp.model.Organization;
import com.example.kpz_kp.model.Service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewOrderTest {

    @Test
    void Test11(){
        String choice = "Друк фото";
        String size = "0";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        Assertions.assertEquals("Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!", res1);
    }

    @Test
    void Test12(){
        String choice = "Друк фото";
        String size = "1";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        Assertions.assertEquals("Вартість замовлення: 15.75 грн.", res1);
    }

    @Test
    void Test13(){
        String choice = "Друк фото";
        String size = "2";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        Assertions.assertEquals("Вартість замовлення: 31.5 грн.", res1);
    }

    @Test
    void Test21(){
        String choice = "Друк фото";
        String size = "4";
        String phone = "99999999999";
        String payment = "63.00";
        String name = "Tester";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name , phone , Double.parseDouble(payment));
            if (order_res == -1){
                res2 = "Помилка, некоретний номер телефону або сума оплати!";
            } else {
                res2 = "Замовлення успішно зареєстроване, решта: " + order_res + " грн.";
            }
        } else {
            res2 = "Помилка, некоретний номер телефону або сума оплати!";
        }

        Assertions.assertEquals("Вартість замовлення: 63.0 грн.", res1);
        Assertions.assertEquals("Помилка, некоретний номер телефону або сума оплати!", res2);
    }

    @Test
    void Test22(){
        String choice = "Друк фото";
        String size = "4";
        String phone = "100000000000";
        String payment = "63.00";
        String name = "Tester";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name , phone , Double.parseDouble(payment));
            if (order_res == -1){
                res2 = "Помилка, некоретний номер телефону або сума оплати!";
            } else {
                res2 = "Замовлення успішно зареєстроване, решта: " + order_res + " грн.";
            }
        } else {
            res2 = "Помилка, некоретний номер телефону або сума оплати!";
        }

        Assertions.assertEquals("Вартість замовлення: 63.0 грн.", res1);
        Assertions.assertEquals("Замовлення успішно зареєстроване, решта: 0.0 грн.", res2);
    }

    @Test
    void Test23(){
        String choice = "Друк фото";
        String size = "4";
        String phone = "100000000001";
        String payment = "63.00";
        String name = "Tester";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name , phone , Double.parseDouble(payment));
            if (order_res == -1){
                res2 = "Помилка, некоретний номер телефону або сума оплати!";
            } else {
                res2 = "Замовлення успішно зареєстроване, решта: " + order_res + " грн.";
            }
        } else {
            res2 = "Помилка, некоретний номер телефону або сума оплати!";
        }

        Assertions.assertEquals("Вартість замовлення: 63.0 грн.", res1);
        Assertions.assertEquals("Замовлення успішно зареєстроване, решта: 0.0 грн.", res2);
    }

    @Test
    void Test24(){
        String choice = "Друк фото";
        String size = "4";
        String phone = "999999999999";
        String payment = "63.00";
        String name = "Tester";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name , phone , Double.parseDouble(payment));
            if (order_res == -1){
                res2 = "Помилка, некоретний номер телефону або сума оплати!";
            } else {
                res2 = "Замовлення успішно зареєстроване, решта: " + order_res + " грн.";
            }
        } else {
            res2 = "Помилка, некоретний номер телефону або сума оплати!";
        }

        Assertions.assertEquals("Вартість замовлення: 63.0 грн.", res1);
        Assertions.assertEquals("Замовлення успішно зареєстроване, решта: 0.0 грн.", res2);
    }

    @Test
    void Test25(){
        String choice = "Друк фото";
        String size = "4";
        String phone = "1000000000";
        String payment = "63.00";
        String name = "Tester";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name , phone , Double.parseDouble(payment));
            if (order_res == -1){
                res2 = "Помилка, некоретний номер телефону або сума оплати!";
            } else {
                res2 = "Замовлення успішно зареєстроване, решта: " + order_res + " грн.";
            }
        } else {
            res2 = "Помилка, некоретний номер телефону або сума оплати!";
        }

        Assertions.assertEquals("Вартість замовлення: 63.0 грн.", res1);
        Assertions.assertEquals("Помилка, некоретний номер телефону або сума оплати!", res2);
    }

    @Test
    void Test26(){
        String choice = "Друк фото";
        String size = "4";
        String phone = "1000000001";
        String payment = "63.00";
        String name = "Tester";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name , phone , Double.parseDouble(payment));
            if (order_res == -1){
                res2 = "Помилка, некоретний номер телефону або сума оплати!";
            } else {
                res2 = "Замовлення успішно зареєстроване, решта: " + order_res + " грн.";
            }
        } else {
            res2 = "Помилка, некоретний номер телефону або сума оплати!";
        }

        Assertions.assertEquals("Вартість замовлення: 63.0 грн.", res1);
        Assertions.assertEquals("Помилка, некоретний номер телефону або сума оплати!", res2);
    }

    @Test
    void Test31(){
        String choice = "Друк фото";
        String size = "4";
        String phone = "380467754375";
        String payment = "-1.00";
        String name = "Tester";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name , phone , Double.parseDouble(payment));
            if (order_res == -1){
                res2 = "Помилка, некоретний номер телефону або сума оплати!";
            } else {
                res2 = "Замовлення успішно зареєстроване, решта: " + order_res + " грн.";
            }
        } else {
            res2 = "Помилка, некоретний номер телефону або сума оплати!";
        }

        Assertions.assertEquals("Вартість замовлення: 63.0 грн.", res1);
        Assertions.assertEquals("Помилка, некоретний номер телефону або сума оплати!", res2);
    }

    @Test
    void Test32(){
        String choice = "Друк фото";
        String size = "4";
        String phone = "380467754375";
        String payment = "0.00";
        String name = "Tester";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name , phone , Double.parseDouble(payment));
            if (order_res == -1){
                res2 = "Помилка, некоретний номер телефону або сума оплати!";
            } else {
                res2 = "Замовлення успішно зареєстроване, решта: " + order_res + " грн.";
            }
        } else {
            res2 = "Помилка, некоретний номер телефону або сума оплати!";
        }

        Assertions.assertEquals("Вартість замовлення: 63.0 грн.", res1);
        Assertions.assertEquals("Помилка, некоретний номер телефону або сума оплати!", res2);
    }

    @Test
    void Test33(){
        String choice = "Друк фото";
        String size = "4";
        String phone = "380467754375";
        String payment = "1.00";
        String name = "Tester";
        Register register = new Register(new Service(), new Calculator(), new Organization(), new DataBase());
        LoginController.authorizeUser("jarvan4","shivana","менеджер");
        register.init();
        String res1;
        String res2;

        if (choice != null && size.matches("\\d+") && Integer.parseInt(size) > 0){
            double price = register.getPrice(choice , Integer.parseInt(size));
            res1 = ("Вартість замовлення: " + price + " грн.");

        } else {
            res1 = "Помилка, послуга має бути обрана, а обсяг замовлення має бути цілим числом!";
        }

        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double order_res = register.makePayment(name , phone , Double.parseDouble(payment));
            if (order_res == -1){
                res2 = "Помилка, некоретний номер телефону або сума оплати!";
            } else {
                res2 = "Замовлення успішно зареєстроване, решта: " + order_res + " грн.";
            }
        } else {
            res2 = "Помилка, некоретний номер телефону або сума оплати!";
        }

        Assertions.assertEquals("Вартість замовлення: 63.0 грн.", res1);
        Assertions.assertEquals("Помилка, некоретний номер телефону або сума оплати!", res2);
    }
}
