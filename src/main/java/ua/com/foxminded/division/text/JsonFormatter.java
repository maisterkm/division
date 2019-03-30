package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Result;

public class JsonFormatter implements Formatter {
    private Result result;
    
    public String format(Result r) {
        result = r;
        String output = "";
        
        output += "{\n";
        
        output += "\"dividend\":" + result.getDividend() + ",\n";
        output += "\"divisor\":" + result.getDivisor() + ",\n";
        output += "\"partialDividend\":" + result.partialDividend.get(0) + ",\n";
        output += "\"digitsOfDividend\":" + "[";
        for(int i = 0; i < result.digitsOfDividend.size(); i++) { 
            output += result.digitsOfDividend.get(i);
            if(i != result.digitsOfDividend.size()-1) { output += ", "; }
        }
        output += "],\n";
        
        output += "\"digitsOfQuotient\":" + "[";
        for(int i = 0; i < result.arrayOfSteps.size(); i++) { 
            for (int j = 0; j < result.arrayOfSteps.get(i).digitsOfQuotient.size(); j++) {
                output += result.arrayOfSteps.get(i).digitsOfQuotient.get(j);
            }
            if(i != result.arrayOfSteps.size()-1) { output += ", "; }
        }
        output += "],\n";
        
        output += "\"product\":" + "[";
        for(int i = 0; i < result.arrayOfSteps.size(); i++) { 
            output += result.arrayOfSteps.get(i).getProduct();
            if(i != result.arrayOfSteps.size()-1) { output += ", "; }
        }
        output += "],\n";
        
        output += "\"integralPartialDividend\":" + "[";
        for(int i = 0; i < result.arrayOfSteps.size(); i++) { 
            output += result.arrayOfSteps.get(i).getIntegralPartialDividend();
            if(i != result.arrayOfSteps.size()-1) { output += ", "; }
        }
        output += "],\n";
        
        output += "\"remainder\":" + "[";
        for(int i = 0; i < result.arrayOfSteps.size(); i++) { 
            output += result.arrayOfSteps.get(i).getRemainder();
            if(i != result.arrayOfSteps.size()-1) { output += ", "; }
        }
        output += "]";
        
        output += "\n}";
        return output;
    }
}
