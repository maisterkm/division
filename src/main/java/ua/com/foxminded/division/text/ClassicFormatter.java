package ua.com.foxminded.division.text;

import java.util.ArrayList;

import ua.com.foxminded.division.math.Result;

public class ClassicFormatter implements Formatter {
    private Result result;
    
    public String format(Result r) {
        result = r;
        String output = "";
        int positionsBeforProduct = 0;
        int positionBiforeIntegralPartialDividend = 1;
        
        //BEGIN OF HEAD
        output = "_" + result.getDividend() + "|" + result.getDivisor() + "\n";
        positionsBeforProduct = result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0);
        output += " ";
        for(int i=0; i < positionsBeforProduct; i++) { output += " "; }
        output += Integer.toString(result.product.get(0)); //System.out.print(product.get(0));
        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.getLength(); i++) {
                output += " ";
            } 
        }
        output += "|";
        for (int i = 0; i < result.digitsOfQuotient.size(); i++) { output +="-"; }
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
        for (int item : result.digitsOfQuotient) { output += Integer.toString(item); }
        output += "\n";
        if (result.integralPartialDividend.size() == 1) { //If there is only one iteration
            if (result.remainder.get(0) != 0) {
                positionsBeforProduct += result.countDigitsInProduct(0) - result.countDigitsInIntegralPartialDividend(0) + 1;
            }
            if(result.remainder.get(0) == 0) { 
                for (int i = 0; i < result.countDigitsInIntegralPartialDividend(0); i++) { positionsBeforProduct++; }
            }
            for(int i=0; i < positionsBeforProduct; i++) { output += " "; }
            if (result.remainder.size() > 1) {
                output += "_" + result.integralPartialDividend.get(0);
            } else { 
                    if(result.remainder.get(0) == 0) {
                        for(int i = 0; i < result.countDigitsInProduct(0); i++) { output += " "; } 
                        output += result.integralPartialDividend.get(0);
                    } else {
                        for(int i = 0; i < result.product.size(); i++) { output += " "; } 
                        output += result.integralPartialDividend.get(0);
                    }
                }
        } else if(result.integralPartialDividend.size() == 0) {
            positionsBeforProduct += result.countDigitsInProduct(0) - result.countDigitsInRemainder(0) + 1;
            for(int i=0; i < positionsBeforProduct; i++) { output += " "; }
            output += result.remainder.get(0);
        }
        if (result.integralPartialDividend.size() > 1) {
            switch (result.countDigitsInIntegralPartialDividend(0)) {
            case (1):
                if (result.countDigitsInProduct(0) == 2) {
                    positionBiforeIntegralPartialDividend += 1;
                }
                break;
            case (2):
                positionBiforeIntegralPartialDividend = result.countDigitsInProduct(0) - 1;
                break;
            }
            for(int i=0; i < positionBiforeIntegralPartialDividend; i++) { output +=" "; }
            if (result.digitsOfDividend.size() - result.countDigitsInArray(result.partialDividend) + 1 == 1) {
                output += result.integralPartialDividend.get(0);
            } else if(result.integralPartialDividend.size() == 1) { /////////////?????? without minus!!!
                       output += " " + result.integralPartialDividend.get(0); 
                   } else { output += "_" + result.integralPartialDividend.get(0); }
        }
      //END OF HEAD
      output += "\n";
      int j=1;
      positionsBeforProduct = positionBiforeIntegralPartialDividend;
      while(j < result.integralPartialDividend.size()) {
          if(result.countDigitsInIntegralPartialDividend(j-1) == result.countDigitsInProduct(j)) { positionsBeforProduct++; }
          for(int i=0; i < positionsBeforProduct; i++) { output += "*"; }
          output += result.product.get(j) + "\n";
          for(int i=0; i < positionsBeforProduct; i++) { output += " "; }
          for(int i=0; i < result.countDigitsInProduct(j); i++) { output += "-"; }
          output += "\n";
          if (result.product.get(j)-1 != 1) {
              positionBiforeIntegralPartialDividend += result.countDigitsInRemainder(j);
          }
          if (j <= result.integralPartialDividend.size()-1) {
              for(int i=0; i < positionBiforeIntegralPartialDividend; i++) { output += "."; }
              output += "_" + result.integralPartialDividend.get(j) + "\n";
          } else {
              if(result.countDigitsInIntegralPartialDividend(j) != 1) { 
                  positionBiforeIntegralPartialDividend += result.countDigitsInProduct(j-1) - result.countDigitsInIntegralPartialDividend(j);  
              }
              if(result.countDigitsInIntegralPartialDividend(j) == 1) { positionBiforeIntegralPartialDividend++; }
              if(result.countDigitsInIntegralPartialDividend(j) == 1 && result.countDigitsInProduct(j - 1) == 1) { positionBiforeIntegralPartialDividend--; }
              for(int i=0; i < positionBiforeIntegralPartialDividend; i++) { output += "~"; }
              output += result.integralPartialDividend.get(j) + "\n";
          }
          j++;
        }
    //Last iteration, concatenate last product and last remainder
    if (result.integralPartialDividend.size() == 1 && result.product.size() == 1) { return output; }
    if (j == result.integralPartialDividend.size() && result.integralPartialDividend.size() == 1) { // was > 1
          if (result.countDigitsInIntegralPartialDividend(j - 1) == result.countDigitsInProduct(j-1)) {
//              
              positionsBeforProduct = positionBiforeIntegralPartialDividend + 1;
              if(result.remainder.get(j-1) == 0) { positionsBeforProduct++; }
          }
          if (result.product.size() > 1) {
            for (int i = 0; i < positionsBeforProduct; i++) {
                output += ":";
            }
            output += result.product.get(j) + "\n";
            for (int i = 0; i < positionsBeforProduct; i++) {
                output += ":";
            }
            for (int i = 0; i < result.countDigitsInProduct(j); i++) {
                output += "-";
            }
            output += "\n";
            if (result.product.size() > 1) {
              positionBiforeIntegralPartialDividend += result.countDigitsInProduct(j) - result.countDigitsInRemainder(j) + 1;
            }
        }
      
        for (int i = 0; i < positionBiforeIntegralPartialDividend; i++) { output += "^"; }
          output += result.remainder.get(j);
        } else if(j == result.integralPartialDividend.size() && result.integralPartialDividend.size() > 1) {
//            o += "\n";
//            positionsBeforProduct = positionBiforeIntegralPartialDividend + result.countDigitsInIntegralPartialDividend(j-1) - result.countDigitsInProduct(j-1) + 1;
            positionsBeforProduct++;
            for (int i = 0; i < positionsBeforProduct; i++) { output += ":"; }
            output += result.product.get(j) + "\n";
            for (int i = 0; i < positionsBeforProduct; i++) { output += " "; }
            for(int i=0; i < result.countDigitsInProduct(j); i++) { output += "-"; }
            output += "\n";
            positionBiforeIntegralPartialDividend = positionsBeforProduct + result.countDigitsInProduct(j) - result.countDigitsInRemainder(j);
            for (int i = 0; i < positionBiforeIntegralPartialDividend; i++) { output += " "; }
            output += result.remainder.get(j);
      }
      return output;
    }
}
