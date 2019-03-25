package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;

public class HtmlFormatter implements Formatter {
    private Result result;

    public String format(Result result) {
//        result = r;
        String output = "";
        output += "<html>\n<title>Division</title><body>\n<pre>\n";
        
        Formatter formatter = new ClassicFormatter();
        output += formatter.format(result);
        
//        output += "<pre>_" + result.getDividend() + "|" + result.getDivisor() + "<br>";
//        positionsBeforProduct = result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0);
//        output += "&nbsp;";
//        for(int i=0; i < positionsBeforProduct; i++) { output += "&nbsp;"; }
//        output += Integer.toString(result.product.get(0));
//        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
//            for (int i = 0; i < result.getLength(); i++) { output += "&nbsp;"; } 
//        }
//        output += "|";
//        for (int i = 0; i < result.digitsOfQuotient.size(); i++) { output +="-"; }
//        output += "<br>";
//        output += "&nbsp;";
//        for(int i=0; i < positionsBeforProduct; i++) { output += "&nbsp;"; }
//        for(int i=0; i < result.countDigitsInProduct(0); i++) { output += "-</pre>"; }
        
        output += "\n</pre>\n</body>\n</html>";
        
        return output;
    }

}