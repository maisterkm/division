package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Result;

public class JsonFormatter implements Formatter {
    private Result result;
    
    public String format(Result r) {
        result = r;
        String output = "";
        
        output += "{";
        
        output += "\"dividend\":" + result.getDividend() + ", ";
        output += "\"divisor\":" + result.getDivisor() + ", ";
        output += "\"partialDividend\":" + result.partialDividend.get(0) + ", ";
        output += "\"digitsOfDividend\":" + "[";
        for(int i = 0; i < result.digitsOfDividend.size(); i++) { 
            output += result.digitsOfDividend.get(i);
            if(i != result.digitsOfDividend.size()-1) { output += ", "; }
        }
        output += "], ";
        
        output += "\"digitsOfQuotient\":" + "[";
        for(int i = 0; i < result.digitsOfQuotient.size(); i++) { 
            output += result.digitsOfQuotient.get(i);
            if(i != result.digitsOfQuotient.size()-1) { output += ", "; }
        }
        output += "], ";
        
        output += "\"product\":" + "[";
        for(int i = 0; i < result.product.size(); i++) { 
            output += result.product.get(i);
            if(i != result.product.size()-1) { output += ", "; }
        }
        output += "], ";
        
        output += "\"integralPartialDividend\":" + "[";
        for(int i = 0; i < result.integralPartialDividend.size(); i++) { 
            output += result.integralPartialDividend.get(i);
            if(i != result.integralPartialDividend.size()-1) { output += ", "; }
        }
        output += "], ";
        
        output += "\"remainder\":" + "[";
        for(int i = 0; i < result.remainder.size(); i++) { 
            output += result.remainder.get(i);
            if(i != result.remainder.size()-1) { output += ", "; }
        }
        output += "]";
        
        output += "}";
        return output;
    }

}
