package ua.com.foxminded.division.math;

import java.util.ArrayList;
import java.util.Collections;

public class Divider {
    public Result result = new Result();
    private int indexDigitsOfDividend = 0;
    private int indexOfZeroInQuotient = 0;
    private boolean shiftDigit = false;
    private int dividend;
    private int divisor;
    
    private ArrayList<Integer> digitsOfDividend = new ArrayList<Integer>();
    private ArrayList<Integer> partialDividend = new ArrayList<Integer>();
    
    public Result divide(int dividend, int divisor) {
        this.dividend = dividend;
        this.divisor = divisor;
        result.setDividend(dividend);
        result.setDivisor(divisor);
        int i = 0;
        splitDividendIntoDigits(dividend);
        findFirstPartialDividend(i);
        indexDigitsOfDividend = countDigitsInArray(partialDividend);
        result.digitsOfQuotient.add(div(partialDividend.get(i), divisor)); 
        result.product.add(multiply(result.digitsOfQuotient.get(i), divisor)); 
        result.remainder.add(partialDividend.get(i) - result.product.get(i)); 
        if(indexDigitsOfDividend < digitsOfDividend.size()) {
            result.integralPartialDividend.add(findIntegralPartialDividend(i)); 
        } else if(indexDigitsOfDividend == digitsOfDividend.size() && shiftDigit == false) { 
            return result; 
        }else if(indexDigitsOfDividend == digitsOfDividend.size() && shiftDigit == true && result.integralPartialDividend.get(i) >= divisor) {
            result.digitsOfQuotient.add(div(result.integralPartialDividend.get(i), divisor));
            result.product.add(multiply(result.digitsOfQuotient.get(i), divisor)); 
            result.remainder.add(partialDividend.get(i) - result.product.get(i));
            return result;
        } else if(indexDigitsOfDividend == digitsOfDividend.size() && shiftDigit == true && result.integralPartialDividend.get(i) < divisor) {
            return result;
        }
        while(indexDigitsOfDividend <= digitsOfDividend.size()) {
            if (result.integralPartialDividend.get(i) < divisor) { break; }
            result.digitsOfQuotient.add(div(result.integralPartialDividend.get(i), divisor));
            if (countDigitsInIntegralPartialDividend(i) - countDigitsInRemainder(i) > 1 && result.remainder.get(i) != 0) { indexOfZeroInQuotient = i+1; } 
                i++;
                if (result.digitsOfQuotient.get(i) == 0) {
                    result.product.add(multiply(result.digitsOfQuotient.get(i+1), divisor));
                } else { result.product.add(multiply(result.digitsOfQuotient.get(i), divisor)); }
                result.remainder.add(result.integralPartialDividend.get(i - 1) - result.product.get(i));
            if(indexDigitsOfDividend < digitsOfDividend.size()) {
                result.integralPartialDividend.add(findIntegralPartialDividend(i)); 
            } else { indexDigitsOfDividend++; }
        }
        if(indexOfZeroInQuotient != 0) { result.digitsOfQuotient.add(indexOfZeroInQuotient, 0); }
        return result;
    }
    
    private void findFirstPartialDividend(int i) {
        String tempDividendString = "";
        int tempDividendInt; 
        if(i == 0) {    // Looking for the first value for ArrayList<Integer> partialDividend
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
    
    private void splitDividendIntoDigits(int dividend) {
        if(dividend == 0) {
            digitsOfDividend.add(0);
        }else {
            for(int j=10; dividend%j != 0 || dividend != 0;) {
                digitsOfDividend.add(dividend%j);
                    dividend = dividend-(dividend%j);
                    dividend/=j; 
            }
            Collections.reverse(digitsOfDividend);
        }  
    }
    
    private int findIntegralPartialDividend(int i) {
        String tempString = "0";
        if (result.remainder.get(i) >= divisor)  { 
            return result.remainder.get(i);
        } else {    // Concatenate remainder and partialDividend
            if(result.remainder.get(i) != 0) { 
                tempString = Integer.toString(result.remainder.get(i)); 
            } else if(indexDigitsOfDividend < digitsOfDividend.size()) {
                tempString = Integer.toString(digitsOfDividend.get(indexDigitsOfDividend));
                indexDigitsOfDividend++;
            } 
            
            while(Integer.parseInt(tempString) <= divisor && indexDigitsOfDividend < digitsOfDividend.size()) {
                tempString += Integer.toString(digitsOfDividend.get(indexDigitsOfDividend)); 
                indexDigitsOfDividend++;
            } 
            if(result.remainder.get(i) == 0 && indexDigitsOfDividend == digitsOfDividend.size()) {
                result.digitsOfQuotient.add(0);
                shiftDigit = true;
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
    
    private int countDigitsInIntegralPartialDividend(int i) {
        if(result.integralPartialDividend.get(i) == 0) { return 1; }
        int temp = result.integralPartialDividend.get(i);
        int counter = 0;
        while(temp>0) {
            temp = temp -(temp%10);
            temp /= 10;
            counter++;            
        }
        return counter;
    }
    
    private int countDigitsInRemainder(int i) {
        if(result.remainder.get(i) == 0) { return 1; }
        int temp = result.remainder.get(i);
        int counter = 0;
        while(temp>0) {
            temp = temp -(temp%10);
            temp /= 10;
            counter++;            
        }
        return counter;
    }
}
