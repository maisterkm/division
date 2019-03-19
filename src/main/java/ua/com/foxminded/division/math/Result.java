package ua.com.foxminded.division.math;

import java.util.ArrayList;
import java.util.Collections;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Result {
    private int dividend;
    private int divisor;
    
    private ArrayList<Integer> digitsOfDividend = new ArrayList<Integer>();
    private ArrayList<Integer> partialDividend = new ArrayList<Integer>();
    private ArrayList<Integer> digitsOfQuotient = new ArrayList<Integer>();
    private ArrayList<Integer> product = new ArrayList<Integer>();
    private ArrayList<Integer> integralPartialDividend = new ArrayList<Integer>();
    private ArrayList<Integer> remainder = new ArrayList<Integer>();
    
    private int testVar;
    
    //Шаг деления с его параметрами (для подсвечивания) можно представить в виде 
    //(вложенного или внутреннего) класса Step или Stage.
    public class Step {}
}
