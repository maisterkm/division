package ua.com.foxminded.division;

import java.util.ArrayList;

import ua.com.foxminded.division.math.*;
import ua.com.foxminded.division.text.ClassicFormatter;
import ua.com.foxminded.division.text.Formatter;

public class Main {
    
    public static void main(String[] args) {
        int dividend = 1260257;
        int divisor = 37;
        Divider divider = new Divider();
        Result result = new Result();
        result = divider.divide(dividend, divisor);
        Formatter formatter = new ClassicFormatter();
        String output = formatter.format(result);
        System.out.printf(output);
    }
}
