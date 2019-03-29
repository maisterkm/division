package ua.com.foxminded.division.text;

import java.util.ArrayList;

import ua.com.foxminded.division.math.Result;
import ua.com.foxminded.division.math.Result.Step;

public class ClassicFormatter implements Formatter {
    private Result result;
    private Result.Step step = new Result().new Step();
    private String output = "";
    private int positionsBeforProduct = 0;
    private int positionBiforeIntegralPartialDividend = 1;
    
    public String format(Result r) {
        result = r;
        concatenateFirstStep();
        output += "\n";
        int j=1;
//        positionsBeforProduct = positionBiforeIntegralPartialDividend;
//        while(j < result.integralPartialDividend.size()) {
//            if(result.countDigitsInIntegralPartialDividend(j-1) == result.countDigitsInProduct(j)) { positionsBeforProduct++; }
//            for(int i=0; i < positionsBeforProduct; i++) { output += " "; }
//            output += result.product.get(j) + "\n";
//            for(int i=0; i < positionsBeforProduct; i++) { output += " "; }
//            for(int i=0; i < result.countDigitsInProduct(j); i++) { output += "-"; }
//            output += "\n";
//            if (result.product.get(j)-1 != 1) {
//                positionBiforeIntegralPartialDividend += result.countDigitsInRemainder(j);
//            }
//            if (j <= result.integralPartialDividend.size()-1) {
//                for(int i=0; i < positionBiforeIntegralPartialDividend; i++) { output += " "; }
//                output += "_" + result.integralPartialDividend.get(j) + "\n";
//            } else {
//                if(result.countDigitsInIntegralPartialDividend(j) != 1) { 
//                    positionBiforeIntegralPartialDividend += result.countDigitsInProduct(j-1) - result.countDigitsInIntegralPartialDividend(j);  
//                }
//                if(result.countDigitsInIntegralPartialDividend(j) == 1) { positionBiforeIntegralPartialDividend++; }
//                if(result.countDigitsInIntegralPartialDividend(j) == 1 && result.countDigitsInProduct(j - 1) == 1) { positionBiforeIntegralPartialDividend--; }
//                for(int i=0; i < positionBiforeIntegralPartialDividend; i++) { output += " "; }
//                output += result.integralPartialDividend.get(j) + "\n";
//            }
//            j++;
//        }
//    if (result.integralPartialDividend.size() == 1 && result.product.size() == 1) { return output; }
//    concatenateLastIteration(j);
      return output;
    }
    
    private void concatenateFirstStep() {
        output = "_" + result.getDividend() + "|" + result.getDivisor() + "\n";
        positionsBeforProduct = result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0);
        output += " ";
        for(int i=0; i < positionsBeforProduct; i++) { output += " "; }
        output += Integer.toString(result.arrayOfSteps.get(0).getProduct()); //System.out.print(product.get(0));
        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.getLength(); i++) {
                output += " ";
            } 
        }
        output += "|";
        for (int i = 0; i < result.getTotalSizeDigitsOfQuotient(); i++) { output +="-"; }
        output += "\n";
        output += " ";
        for(int i=0; i < positionsBeforProduct; i++) { output += " "; }
        for(int i=0; i < result.countDigitsInProduct(0); i++) { output += "-"; }
        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.getLength(); i++) {
                output += " ";
            } 
        }
        output += "|";
        output += result.getQuotientAsString();
        output += "\n";
        if (result.arrayOfSteps.size() <= 2 && result.arrayOfSteps.get(0).getIntegralPartialDividend() != 0) { //If there is only one iteration
            if (result.arrayOfSteps.get(0).getRemainder() != 0) {
                positionBiforeIntegralPartialDividend += result.countDigitsInProduct(0) - result.countDigitsInIntegralPartialDividend(0);
            }
            if(result.arrayOfSteps.get(0).getRemainder() == 0) { 
                if (result.arrayOfSteps.size() == 1 && result.arrayOfSteps.get(0).getIntegralPartialDividend() != 0) {
                    for (int i = 0; i < result.countDigitsInProduct(0); i++) { positionBiforeIntegralPartialDividend++; } 
                } else {
                    for (int i = 0; i < result.countDigitsInProduct(0)-1; i++) { positionBiforeIntegralPartialDividend++; }
                }
            }
            for(int i=0; i < positionBiforeIntegralPartialDividend; i++) { output += " "; }
            if (result.arrayOfSteps.size() > 1) {
                output += "_" + result.arrayOfSteps.get(0).getIntegralPartialDividend();
            } else { 
                    if(result.arrayOfSteps.get(0).getRemainder() == 0) {
//                        for(int i = 0; i < positionBiforeIntegralPartialDividend; i++) { output += " "; } 
                        output += result.arrayOfSteps.get(0).getIntegralPartialDividend();
                    } else {
                            for(int i = 0; i < result.countDigitsInProduct(0); i++) { output += " "; } 
                            output += result.arrayOfSteps.get(0).getIntegralPartialDividend();
                    }
                }
        } else if(result.arrayOfSteps.size() == 1 && result.arrayOfSteps.get(0).getIntegralPartialDividend() == 0) {
            positionsBeforProduct += result.countDigitsInProduct(0) - result.countDigitsInRemainder(0) + 1;
            for(int i=0; i < positionsBeforProduct; i++) { output += " "; }
            output += result.arrayOfSteps.get(0).getRemainder();
        }
        if (result.arrayOfSteps.size() == 2) {
            concatenateIfIntegralPartialDividendMoreOne();
        }
    }
    
    private void concatenateIfIntegralPartialDividendMoreOne() {
        switch (result.countDigitsInIntegralPartialDividend(0)) {
        case (1):
            if (result.countDigitsInProduct(0) == 2) {
                positionBiforeIntegralPartialDividend += 1;
            }
            break;
        case (2):
        case (3):
            positionsBeforProduct = positionBiforeIntegralPartialDividend + (result.countDigitsInIntegralPartialDividend(0) - result.countDigitsInProduct(1));
            break;
        }
        output += "\n";
        for(int i=0; i < positionsBeforProduct; i++) { output +=" "; }
        if (result.digitsOfDividend.size() - result.countDigitsInArray(result.partialDividend) + 1 == 1) {
            output += result.arrayOfSteps.get(0).getIntegralPartialDividend();
        } else if(result.getValueOfLastIntegralPartialDividend() == 0) { // without minus
                   output += " " + result.arrayOfSteps.get(1).getProduct(); 
               } else { output += "_" + result.arrayOfSteps.get(1).getProduct(); }
        output += "\n ";
        for (int i = 0; i < positionsBeforProduct; i++) { output+= " "; }
        for (int i = 0; i < result.countDigitsInProduct(1); i++) { output+= "-"; }
        output += "\n";
        positionsBeforProduct += 1 + result.countDigitsInProduct(1) - result.countDigitsInRemainder(1);
        for(int i=0; i < positionsBeforProduct; i++) { output +=" "; }
        output += result.arrayOfSteps.get(1).getRemainder();
        
    }
    
//    private void concatenateLastIteration(int j) {
//        if (j == result.integralPartialDividend.size() && result.integralPartialDividend.size() == 1) { // was > 1
//            if (result.countDigitsInIntegralPartialDividend(j - 1) == result.countDigitsInProduct(j-1)) {
//                positionsBeforProduct = positionBiforeIntegralPartialDividend + 1;
//                if(result.remainder.get(j-1) == 0) { positionsBeforProduct++; }
//            }
//            if (result.product.size() > 1) {
//              for (int i = 0; i < positionsBeforProduct; i++) {
//                  output += " ";
//              }
//              output += result.product.get(j) + "\n";
//              for (int i = 0; i < positionsBeforProduct; i++) {
//                  output += " ";
//              }
//              for (int i = 0; i < result.countDigitsInProduct(j); i++) {
//                  output += "-";
//              }
//              output += "\n";
//              if (result.product.size() > 1) {
//                positionBiforeIntegralPartialDividend += result.countDigitsInProduct(j) - result.countDigitsInRemainder(j) + 1;
//              }
//          }
//          for (int i = 0; i < positionBiforeIntegralPartialDividend; i++) { output += " "; }
//            output += result.remainder.get(j);
//          } else if(j == result.integralPartialDividend.size() && result.integralPartialDividend.size() > 1) {
//              positionsBeforProduct++;
//              for (int i = 0; i < positionsBeforProduct; i++) { output += " "; }
//              output += result.product.get(j) + "\n";
//              for (int i = 0; i < positionsBeforProduct; i++) { output += " "; }
//              for(int i=0; i < result.countDigitsInProduct(j); i++) { output += "-"; }
//              output += "\n";
//              positionBiforeIntegralPartialDividend = positionsBeforProduct + result.countDigitsInProduct(j) - result.countDigitsInRemainder(j);
//              for (int i = 0; i < positionBiforeIntegralPartialDividend; i++) { output += " "; }
//              output += result.remainder.get(j);
//        }
//    }
}