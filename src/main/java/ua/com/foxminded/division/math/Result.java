package ua.com.foxminded.division.math;

import java.util.ArrayList;
import java.util.Collections;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


public class Result {
    @Getter @Setter
    private int dividend;
    @Getter @Setter
    private int divisor;
    
    public ArrayList<Integer> digitsOfQuotient = new ArrayList<Integer>();
    public ArrayList<Integer> product = new ArrayList<Integer>();
    public ArrayList<Integer> integralPartialDividend = new ArrayList<Integer>();
    public ArrayList<Integer> remainder = new ArrayList<Integer>();
    
//    @Getter(AccessLevel.NONE)
//    @Setter(AccessLevel.NONE)
//    public ArrayList<Step> arrayOfSteps = new ArrayList<Step>();
//    public Step step = new Step();
    
//    @Getter 
//    @Setter
//    public class Step {
//        private int digitsOfQuotient;
//        private int product;
//        private int integralPartialDividend;
//        private int remainder;
//    }
//    
//    public void addStep() {
//        System.out.println("In function addStet()");
//        arrayOfSteps.add(step);
//    }
}
