package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Result;

public class HtmlFormatter implements Formatter {
    private Result result;

    public String format(Result r) {
        result = r;
        String output = "";
        int positionsBeforProduct = 0;
        int positionBiforeIntegralPartialDividend = 1;
        //BEGIN OF HEAD
        output += "<html>\n<body>\n";
        output += "_" + result.getDividend() + "|" + result.getDivisor() + "<br>";
        positionsBeforProduct = result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0);
        output += "&nbsp;";
        for(int i=0; i < positionsBeforProduct; i++) { output += "&nbsp;"; }
        output += Integer.toString(result.product.get(0));
        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.getLength(); i++) { output += "&nbsp;"; } 
        }
        output += "|";
        for (int i = 0; i < result.digitsOfQuotient.size(); i++) { output +="-"; }
        output += "<br>";
        output += "&nbsp;";
        for(int i=0; i < positionsBeforProduct; i++) { output += "<span>&nbsp;</span>"; }
        for(int i=0; i < result.countDigitsInProduct(0); i++) { output += "<span>-</span>"; }
        
        //END OF HEAD
        output += "</body>\n</html>";
        
        return output;
    }

}


//BEGIN OF HEAD
//o = "_" + result.getDividend() + "|" + result.getDivisor() + "\n";
//positionsBeforProduct = result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0);
//o += " ";
//for(int i=0; i < positionsBeforProduct; i++) { o += " "; }
//o += Integer.toString(result.product.get(0)); //System.out.print(product.get(0));
//if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
//    for (int i = 0; i < result.getLength(); i++) {
//        o += " ";
//    } 
//}
//o += "|";
//for (int i = 0; i < result.digitsOfQuotient.size(); i++) { o +="-"; }
//o += "\n";
//o += " ";
//for(int i=0; i < positionsBeforProduct; i++) { o += " "; }
//for(int i=0; i < result.countDigitsInProduct(0); i++) { o += "-"; }
//if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
//    for (int i = 0; i < result.getLength(); i++) {
//        o += " ";
//    } 
//}
//o += "|";
//for (int item : result.digitsOfQuotient) { o += Integer.toString(item); }
//o += "\n";
//if (result.integralPartialDividend.size() == 1) { //If there is only one iteration
//    if (result.remainder.get(0) != 0) {
//        positionsBeforProduct += result.countDigitsInProduct(0) - result.countDigitsInIntegralPartialDividend(0) + 1;
//    }
//    if(result.remainder.get(0) == 0) { 
//        for (int i = 0; i < result.countDigitsInIntegralPartialDividend(0); i++) { positionsBeforProduct++; }
//    }
//    for(int i=0; i < positionsBeforProduct; i++) { o += " "; }
//    if (result.remainder.size() > 1) {
//        o += "_" + result.integralPartialDividend.get(0);
//    } else { 
//            if(result.remainder.get(0) == 0) {
//                for(int i = 0; i < result.countDigitsInProduct(0); i++) { o += " "; } 
//                o += result.integralPartialDividend.get(0);
//            } else {
//                for(int i = 0; i < result.product.size(); i++) { o += " "; } 
//                o += result.integralPartialDividend.get(0);
//            }
//        }
//} else if(result.integralPartialDividend.size() == 0) {
//    positionsBeforProduct += result.countDigitsInProduct(0) - result.countDigitsInRemainder(0) + 1;
//    for(int i=0; i < positionsBeforProduct; i++) { o += " "; }
//    o += result.remainder.get(0);
//}
//if (result.integralPartialDividend.size() > 1) {
//    switch (result.countDigitsInIntegralPartialDividend(0)) {
//    case (1):
//        if (result.countDigitsInProduct(0) == 2) {
//            positionBiforeIntegralPartialDividend += 1;
//        }
//        break;
//    case (2):
//        positionBiforeIntegralPartialDividend = result.countDigitsInProduct(0) - 1;
//        break;
//    }
//    for(int i=0; i < positionBiforeIntegralPartialDividend; i++) { o +=" "; }
//    if (result.digitsOfDividend.size() - result.countDigitsInArray(result.partialDividend) + 1 == 1) {
//        o += result.integralPartialDividend.get(0);
//    } else if(result.integralPartialDividend.size() == 1) { /////////////?????? without minus!!!
//               o += " " + result.integralPartialDividend.get(0); 
//           } else { o += "_" + result.integralPartialDividend.get(0); }
//}
//END OF HEAD