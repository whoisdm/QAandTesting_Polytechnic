package com.example.kpz_kp;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewOrderTest {

    @Test
    void calculateTest1(){
        String choice = "Друк фото";
        String size = "4";
        String res;
        if (choice != null && size.matches("\\d+")){
            res = "Дані коректні";
        } else {
            res = "Дані некоректні";
        }
        Assertions.assertEquals("Дані коректні" , res);
    }

    @Test
    void calculateTest2(){
        String choice = null;
        String size = "asdasd";
        String res;
        if (choice != null && size.matches("\\d+")){
            res = "Дані коректні";
        } else {
            res = "Дані некоректні";
        }
        Assertions.assertEquals("Дані некоректні" , res);
    }

    @Test
    void new_orderTest1(){
        String phone = "380467754375";
        String payment = "60.00";
        double price = 50.00;
        String result;
        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double res = Double.parseDouble(payment) - price;
            if (res < 0){
                result = "Помилка, не вистачає грошей для оплати!";
            } else {
                result = "Замовлення успішно зареєстроване";
            }
        } else {
            result = "Помилка, некоретний номер телефону або сума оплати!";
        }
        Assertions.assertEquals("Замовлення успішно зареєстроване" , result);
    }

    @Test
    void new_orderTest2(){
        String phone = "380467754375";
        String payment = "60.00";
        double price = 70.00;
        String result;
        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double res = Double.parseDouble(payment) - price;
            if (res < 0){
                result = "Помилка, не вистачає грошей для оплати!";
            } else {
                result = "Замовлення успішно зареєстроване";
            }
        } else {
            result = "Помилка, некоретний номер телефону або сума оплати!";
        }
        Assertions.assertEquals("Помилка, не вистачає грошей для оплати!" , result);
    }

    @Test
    void new_orderTest3(){
        String phone = "3804";
        String payment = "asdas";
        double price = 70.00;
        String result;
        if (phone.matches("[0-9]{12}") && payment.matches("[0-9]+(\\.[0-9]{2})?")){
            double res = Double.parseDouble(payment) - price;
            if (res < 0){
                result = "Помилка, не вистачає грошей для оплати!";
            } else {
                result = "Замовлення успішно зареєстроване";
            }
        } else {
            result = "Помилка, некоретний номер телефону або сума оплати!";
        }
            Assertions.assertEquals("Помилка, некоретний номер телефону або сума оплати!" , result);
    }
}
