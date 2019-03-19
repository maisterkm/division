package ua.com.foxminded.division;

import java.util.ArrayList;
import java.util.Collections;

import ua.com.foxminded.division.math.*;

public class Main {
    
    public static void main(String[] args) {
        int dividend = 1010;
        int divisor = 5;
        Divider divider = new Divider();
        divider.divide(dividend, divisor);
        System.out.println(dividend + " / " + divisor + " = " + divider.div(dividend, divisor));
        System.out.println();
        Result result = new Result();
        result.setTestVar(10);
        System.out.println("Lombok: Getter() " + result.getTestVar());
    }
}
