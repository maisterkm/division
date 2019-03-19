package ua.com.foxminded.division.math;

import java.util.ArrayList;
import java.util.Collections;

public class Divider {
    private int indexDigitsOfDividend = 0;
    private Result result;
    private int dividend;
    private int divisor;
    
    private ArrayList<Integer> digitsOfDividend = new ArrayList<Integer>();
    private ArrayList<Integer> partialDividend = new ArrayList<Integer>();
    private ArrayList<Integer> digitsOfQuotient = new ArrayList<Integer>();
    private ArrayList<Integer> product = new ArrayList<Integer>();
    private ArrayList<Integer> integralPartialDividend = new ArrayList<Integer>();
    private ArrayList<Integer> remainder = new ArrayList<Integer>();
    
    
    private class Step {
        private int stepDigitsOfQuotient;
        private int stepProduct;
        private int stepIntegralPartialDividend;
        private int stepRemainder;
        
        public void sendDataToResult(int i) {
            
        }
        
        public void getDataFromResult(int i) {}
    }
    
    public Result divide(int dividend, int divisor) {
        Result result = new Result();
        Step step = new Step();
        this.dividend = dividend;
        this.divisor = divisor;
//        result.setDividend(dividend);
//        result.setDivisor(divisor);
        int i = 0;
        splitDividendIntoDigits(dividend);
        findFirstPartialDividend(i);
        indexDigitsOfDividend = countDigitsInArray(partialDividend);
        //step.stepDigitsOfQuotient = div(partialDividend.get(i), divisor);
        digitsOfQuotient.add(div(partialDividend.get(i), divisor));
        //step.stepProduct = multiply(digitsOfQuotient.get(i), divisor);
        product.add(multiply(digitsOfQuotient.get(i), divisor));
        //step.stepRemainder = partialDividend.get(i) - product.get(i);
        remainder.add(partialDividend.get(i) - product.get(i));
        if(indexDigitsOfDividend < digitsOfDividend.size()) {
            //step.stepIntegralPartialDividend = findIntegralPartialDividend(i);
            integralPartialDividend.add(findIntegralPartialDividend(i));
        }
        step.sendDataToResult(i);
        while(indexDigitsOfDividend < digitsOfDividend.size()) {
            digitsOfQuotient.add(div(integralPartialDividend.get(i), divisor));
            i++;
            product.add(multiply(digitsOfQuotient.get(i), divisor));
            remainder.add(integralPartialDividend.get(i-1) - product.get(i));
            integralPartialDividend.add(findIntegralPartialDividend(i));
        }
        
        return result;
    }
    
    private void findFirstPartialDividend(int i) {
        String tempDividendString = "";
        int tempDividendInt; 
        if(i == 0) { // Looking for the first value for ArrayList<Integer> partialDividend
            if (div(digitsOfDividend.get(i), divisor) > 0 || digitsOfDividend.get(i) == 0) {
                partialDividend.add(digitsOfDividend.get(i));
            } else {
                tempDividendString = Integer.toString(digitsOfDividend.get(i));
                tempDividendInt = Integer.parseInt(tempDividendString);
                i++;
                if(i < digitsOfDividend.size()) {
                    while(div(tempDividendInt, divisor) == 0) {
                        if (i == digitsOfDividend.size()) { break; }
                        tempDividendString = tempDividendString + Integer.toString(digitsOfDividend.get(i));
                        tempDividendInt = Integer.parseInt(tempDividendString); 
                       i++; 
                    }
                }
                partialDividend.add(tempDividendInt);
            } 
        }
    }
    
    private ArrayList<Integer> splitDividendIntoDigits(int dividend) {
        if(dividend == 0) {
            digitsOfDividend.add(0);
            return digitsOfDividend;
        }else {
            for(int j=10; dividend%j != 0 || dividend != 0;) {
                digitsOfDividend.add(dividend%j);
                    dividend = dividend-(dividend%j);
                    dividend/=j; 
            }
            Collections.reverse(digitsOfDividend);
            return digitsOfDividend;
        }  
    }
    
    private int findIntegralPartialDividend(int i) {
        String tempString = "";
        if (remainder.get(i) >= divisor)  { 
            return remainder.get(i);
        } else {        // Concatenate remainder and partialDividend
            if(remainder.get(i) != 0) { 
                tempString = Integer.toString(remainder.get(i)); 
            } else if(indexDigitsOfDividend < digitsOfDividend.size()) {
                tempString = Integer.toString(digitsOfDividend.get(indexDigitsOfDividend));
                indexDigitsOfDividend++;
            } 
            
            int indexIntegralPartialDividend = countDigitsInArray(partialDividend);
            while(Integer.parseInt(tempString) <= divisor && indexDigitsOfDividend < digitsOfDividend.size()) {
                tempString += Integer.toString(digitsOfDividend.get(indexIntegralPartialDividend)); 
                indexIntegralPartialDividend++;
                indexDigitsOfDividend++;
            } 
            if(remainder.get(i) == 0 && indexDigitsOfDividend == digitsOfDividend.size()) {
                digitsOfQuotient.add(0);
            }
            return Integer.parseInt(tempString);
        }
    }
    
    private int countDigitsInArray(ArrayList<Integer> array) {
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
    
    public int div(int dividend, int divisor) {
        int counter = 0;
        if(divisor == 0) { throw new ArithmeticException("Dividing a number by 0"); }
        if(dividend == 0 || dividend < divisor) {
            return 0;
        } else {
            while(dividend >= divisor) {
                dividend -= divisor;
                counter++;
            }
            return counter;
        }
    }
    
    public int multiply(int a, int b) {
        int sum = a;
        if(a == 0 || b == 0) {
            return 0;
        } else {
            for(int i=1; i < b; i++) {
                sum +=a;
            }
            return sum;
        }
    }
   
}
