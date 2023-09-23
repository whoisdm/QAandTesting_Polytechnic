package com.example.kpz_kp;

import com.example.kpz_kp.model.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcTest {

    @Test
    void getTotalPriceTest(){
        Calculator calculator = new Calculator();
        double res = calculator.getTotalPrice(5 , 3 );
        Assertions.assertEquals(15.75 ,res);
    }

    @Test
    void getChangeTest1(){
        Calculator calculator = new Calculator();
        double res = calculator.getChange(60 , 65 );
        Assertions.assertEquals(5 ,res);
    }

    @Test
    void getChangeTest2(){
        Calculator calculator = new Calculator();
        double res = calculator.getChange(60 , 30 );
        Assertions.assertEquals(-1 ,res);
    }

    @Test
    void getCompensationTest(){
        Calculator calculator = new Calculator();
        double res = calculator.getCompensation(30 );
        Assertions.assertEquals(6 ,res);
    }
}
