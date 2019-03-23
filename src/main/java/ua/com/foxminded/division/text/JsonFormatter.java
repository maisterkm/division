package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Result;

public class JsonFormatter implements Formatter {
    private Result result;
    
    public String format(Result r) {
        result = r;
        String output = "";
        int positionsBeforProduct = 0;
        int positionBiforeIntegralPartialDividend = 1;
        
        output = "JSON File";
        
        return output;
    }

}
