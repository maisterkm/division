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
    @Getter @Setter
    private int firstPartialDividend;
    
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    public ArrayList<Step> arrayOfSteps = new ArrayList<Step>();
    public ArrayList<Integer> digitsOfDividend = new ArrayList<Integer>();
    public ArrayList<Integer> partialDividend = new ArrayList<Integer>();
    public Step step = new Step();
    
    @Getter 
    @Setter
    public class Step {
        @Getter(AccessLevel.NONE)
        @Setter(AccessLevel.NONE)
        public ArrayList<Integer> digitsOfQuotient = new ArrayList<Integer>();
        private int product;
        private int integralPartialDividend;
        private int remainder;
    }
    
    public void addStep() {
        arrayOfSteps.add(step);
    }
    
    public int getValueOfLastIntegralPartialDividend() {
        return arrayOfSteps.get(arrayOfSteps.size()-1).getIntegralPartialDividend();
    }
    
    public int getTotalSizeDigitsOfQuotient() {
        int totalSize = 0;
        for (Step step : arrayOfSteps) {
            totalSize += step.digitsOfQuotient.size();
        }
        return totalSize;
    }
    
    public String getQuotientAsString() {
        String str = "";
        for (Step step : arrayOfSteps) {
            for (int item : step.digitsOfQuotient) {
                str += item;
            }
        }
        return str;
    }
    
    public int countDigitsInArray(ArrayList<Integer> array) {
        int counter = 0;
        for(int item : array) {
            int temp = item;
            if(item == 0) { counter++; } 
            while(temp > 0) {
                temp = temp - (temp%10);
                temp /= 10;
                counter++;
            }
        }
        return counter;
    }
    
    public int countDigitsInProduct(int i) {
        if(arrayOfSteps.get(i).getProduct() == 0) { return 1; }
        int temp = arrayOfSteps.get(i).getProduct();
        int counter = 0;
        while(temp>0) {
            temp = temp -(temp%10);
            temp /= 10;
            counter++;            
        }
        return counter;
    }
    
    public int countDigitsInIntegralPartialDividend(int i) {
        if(arrayOfSteps.get(i).getIntegralPartialDividend() == 0) { return 1; }
        int temp = arrayOfSteps.get(i).getIntegralPartialDividend();
        int counter = 0;
        while(temp>0) {
            temp = temp -(temp%10);
            temp /= 10;
            counter++;            
        }
        return counter;
    }
    
    public int countDigitsInRemainder(int i) {
        if(arrayOfSteps.get(i).getRemainder() == 0) { return 1; }
        int temp = arrayOfSteps.get(i).getRemainder();
        int counter = 0;
        while(temp>0) {
            temp = temp -(temp%10);
            temp /= 10;
            counter++;            
        }
        return counter;
    }
    
    public int getLength() {
      int counter = digitsOfDividend.size() - countDigitsInProduct(0);
      return counter;
  }
}