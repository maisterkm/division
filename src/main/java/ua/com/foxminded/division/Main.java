package ua.com.foxminded.division;

import java.util.ArrayList;

import ua.com.foxminded.division.math.*;

public class Main {
    
    public static void main(String[] args) {
        int dividend = 333;
        int divisor = 8;
        Divider divider = new Divider();
        Result result = new Result();
        result = divider.divide(dividend, divisor);
        System.out.println(dividend + " / " + divisor + " = " + divider.div(dividend, divisor));

        System.out.println("In class Result: digitsOfQuotient=" + divider.result.digitsOfQuotient.size() +
                " product=" + divider.result.product.size() +
                " remainder=" + divider.result.remainder.size() +
                " integralPartialDividend=" + result.integralPartialDividend.size());
        System.out.println("digitsOfQuotient=" + result.digitsOfQuotient +
                " remainder=" + divider.result.remainder +
                " integralPartialDividend=" + result.integralPartialDividend + 
                " product=" + result.product);
    }
}
