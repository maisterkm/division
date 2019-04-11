package ua.com.foxminded.division.text;

import java.util.ArrayList;
import java.util.Collections;

import ua.com.foxminded.division.math.Result;

public class HtmlFormatter implements Formatter {
    private Result result;
    String output = "<html>\n<title>Division</title>\n"
            + "<head><script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>"
            + "</head>" + "<body>\n" + "<style>\n" + "\n" + "span.item {\n" + "    display: inline-block;\n"
            + "    border: 1px solid green;\n" + "    text-align: center;\n" + "    height: 25px;\n"
            + "    width: 25px; \n" + "    margin: 1px;\n" + "}\n" + "span.quotient:hover {color: red;}\n" + "</style>";
    private int positionsBeforProduct = 0;
    private int positionBiforeIntegralPartialDividend = 1;
    private ArrayList<Integer> arrDivisor = new ArrayList<Integer>();

    public String format(Result r) {
        result = r;
        if (result.arrayOfSteps.size() <= 2) {
            concatenateFirstStep();
            output += "\n</body>\n</html>";
            return output;
        } else {
            concatenateFirstStep();
        }
        output += "<br>";
        int j = 1;
        positionsBeforProduct = positionBiforeIntegralPartialDividend;
        while (j < result.arrayOfSteps.size()) {
            positionsBeforProduct = positionBiforeIntegralPartialDividend + 1;
            for (int i = 0; i < positionsBeforProduct; i++) {
                output += "<span class=\"item\">&nbsp;</span>";
            }
            output += insertProducInSpan(j);
            output += "<br>";
            for (int i = 0; i < positionsBeforProduct; i++) {
                output += "<span class=\"item\">&nbsp;</span>";
            }
            for (int i = 0; i < result.countDigitsInProduct(j); i++) {
                output += "<span class=\"item\">-</span>";
            }
            output += "<br>";
            positionBiforeIntegralPartialDividend = positionsBeforProduct + result.countDigitsInProduct(j)
                    - result.countDigitsInRemainder(j) - 1;
            for (int i = 0; i < positionBiforeIntegralPartialDividend; i++) {
                output += "<span class=\"item\">&nbsp;</span>";
            }
            if (j < result.arrayOfSteps.size() - 1) {
                output += "<span class=\"item\">_</span>";
                output += insertIntegralPartialDividendInSpan(j);
                output += "<br>";
            } else {
                output += "<span class=\"item\">&nbsp;</span>";
                output += insertRemainderInSpan(j);
            }
            j++;
        }
        output += "\n</body>\n</html>";
        return output;
    }

    private void concatenateFirstStep() {
        output += "<span class=\"item\">_</span>";
        for (int i = 0; i < result.digitsOfDividend.size(); i++) {
            output += "<span class=\"item step-" + i + "\"\">" + result.digitsOfDividend.get(i) + "</span>";
        }
        output += "<span class=\"item\">|</span>";
        arrDivisor.clear();
        arrDivisor = splitDivisorToDigits();
        for (int i : arrDivisor) {
            output += "<span class=\"item\">" + i + "</span>";
        }
        output += "<br>";
        positionsBeforProduct = result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0);
        output += "<span class=\"item\">&nbsp;</span>";
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        output += insertProducInSpan(0);
        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.digitsOfDividend.size() - result.countDigitsInProduct(0)
                    - positionsBeforProduct; i++) {
                output += "<span class=\"item\">&nbsp;</span>";
            }
        }
        output += "<span class=\"item\">|</span>";
        for (int i = 0; i < result.getTotalSizeDigitsOfQuotient(); i++) {
            output += "<span class=\"item\">-</span>";
        }
        output += "<br>";
        output += "<span class=\"item\">&nbsp;</span>";
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        for (int i = 0; i < result.countDigitsInProduct(0); i++) {
            output += "<span class=\"item\">-</span>";
        }
        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.digitsOfDividend.size() - result.countDigitsInProduct(0)
                    - positionsBeforProduct; i++) {
                output += "<span class=\"item\">&nbsp;</span>";
            }
        }
        output += "<span class=\"item\">|</span>";
        output += insertQuotientInSpan();
        output += "<br>";
        if (result.arrayOfSteps.size() <= 2 && result.arrayOfSteps.get(0).getIntegralPartialDividend() != 0) {
            concatenateIfIntegralPartialDividendNotZero();
        } else if (result.arrayOfSteps.size() == 1 && result.arrayOfSteps.get(0).getIntegralPartialDividend() == 0) {
            concatenateIfIntegralPartialDividendZero();
        } else if (result.arrayOfSteps.size() > 2) {
            if (result.arrayOfSteps.get(0).getIntegralPartialDividend() != 0) {
                concatenateIfIntegralPartialDividendNotZero();
            } else if (result.arrayOfSteps.get(0).getIntegralPartialDividend() == 0) {
                concatenateIfIntegralPartialDividendZero();
            }
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
            positionsBeforProduct = positionBiforeIntegralPartialDividend
                    + (result.countDigitsInIntegralPartialDividend(0) - result.countDigitsInProduct(1));
            break;
        }
        output += "<br>";
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        if (result.digitsOfDividend.size() - result.countDigitsInArray(result.partialDividend) + 1 == 1) {
            output += insertIntegralPartialDividendInSpan(0);
        } else if (result.getValueOfLastIntegralPartialDividend() == 0) { // without minus
            output += "<span class=\"item\">&nbsp;</span>";
            output += insertProducInSpan(1);
        } else {
            output += "<span class=\"item\">_</span>";
            output += insertProducInSpan(1);
        }
        output += "<br>" + "<span class=\"item\">&nbsp;</span>";
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        for (int i = 0; i < result.countDigitsInProduct(1); i++) {
            output += "<span class=\"item\">-</span>";
        }
        output += "<br>";
        positionsBeforProduct += 1 + result.countDigitsInProduct(1) - result.countDigitsInRemainder(1);
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        output += insertRemainderInSpan(1);
    }

    private void concatenateIfIntegralPartialDividendNotZero() {
        if (result.arrayOfSteps.get(0).getRemainder() != 0) {
            if (result.countDigitsInProduct(0) == 2 && result.countDigitsInIntegralPartialDividend(0) == 3) {
                positionBiforeIntegralPartialDividend = Math
                        .abs(result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0));
            } else if (result.countDigitsInArray(result.partialDividend) > result.countDigitsInProduct(0)) {
                positionBiforeIntegralPartialDividend = Math
                        .abs(result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0));
            } else {
                positionBiforeIntegralPartialDividend = Math
                        .abs(result.countDigitsInProduct(0) - result.countDigitsInRemainder(0));
            }
        }
        if (result.arrayOfSteps.get(0).getRemainder() == 0) {
            if (result.arrayOfSteps.size() == 1 && result.arrayOfSteps.get(0).getIntegralPartialDividend() != 0) {
                for (int i = 0; i < result.countDigitsInProduct(0); i++) {
                    positionBiforeIntegralPartialDividend++;
                }
            } else {
                for (int i = 0; i < result.countDigitsInProduct(0) - 1; i++) {
                    positionBiforeIntegralPartialDividend++;
                }
            }
        }
        for (int i = 0; i < positionBiforeIntegralPartialDividend; i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        if (result.arrayOfSteps.size() > 1) {
            output += "<span class=\"item\">_</span>";
            output += insertIntegralPartialDividendInSpan(0);
        } else {
            if (result.arrayOfSteps.get(0).getRemainder() == 0) {
                output += insertIntegralPartialDividendInSpan(0);
            } else {
                for (int i = 0; i < result.countDigitsInProduct(0) - result.countDigitsInRemainder(0); i++) {
                    output += "<span class=\"item\">&nbsp;</span>";
                }
                output += insertIntegralPartialDividendInSpan(0);
            }
        }
    }

    private void concatenateIfIntegralPartialDividendZero() {
        positionsBeforProduct += result.countDigitsInProduct(0) - result.countDigitsInRemainder(0) + 1;
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        output += insertRemainderInSpan(0);
    }

    private ArrayList<Integer> splitDivisorToDigits() {
        int divisor = result.getDivisor();
        ArrayList<Integer> tmpArr = new ArrayList<Integer>();
        if (divisor == 0) {
            tmpArr.add(0);
        }
        for (int j = 10; divisor % j != 0 || divisor != 0;) {
            tmpArr.add(divisor % j);
            divisor = divisor - (divisor % j);
            divisor /= j;
        }
        Collections.reverse(tmpArr);
        return tmpArr;
    }

    private String insertQuotientInSpan() {
        String str = "";
        ArrayList<ArrayList<Integer>> tmpQuotientArr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < result.arrayOfSteps.size(); i++) {
            tmpQuotientArr.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < result.arrayOfSteps.size(); i++) {
            for (int j = 0; j < result.arrayOfSteps.get(i).digitsOfQuotient.size(); j++) {
                tmpQuotientArr.get(i).add(result.arrayOfSteps.get(i).digitsOfQuotient.get(j));
            }
        }

        for (int i = 0; i < tmpQuotientArr.size(); i++) {
            for (int j = 0; j < tmpQuotientArr.get(i).size(); j++) {
                str += "<span class=\"item step-" + i + " quotient\">" + tmpQuotientArr.get(i).get(j) + "</span>";
            }
        }

        return str;
    }

    private String insertProducInSpan(int i) {
        String str = "";
        ArrayList<Integer> tmpArr = new ArrayList<Integer>();
        if (result.arrayOfSteps.get(i).getProduct() == 0) {
            tmpArr.add(0);
        }
        int product = result.arrayOfSteps.get(i).getProduct();
        for (int j = 10; product % j != 0 || product != 0;) {
            tmpArr.add(product % j);
            product = product - (product % j);
            product /= j;
        }
        Collections.reverse(tmpArr);

        for (int j = 0; j < tmpArr.size(); j++) {
            str += "<span class=\"item step-" + i + "\">" + tmpArr.get(j) + "</span>";
        }

        return str;
    }

    private String insertIntegralPartialDividendInSpan(int i) {
        String str = "";
        ArrayList<Integer> tmpArr = new ArrayList<Integer>();
        if (result.arrayOfSteps.get(i).getIntegralPartialDividend() == 0) {
            tmpArr.add(0);
        }
        int integralPartialDividend = result.arrayOfSteps.get(i).getIntegralPartialDividend();
        for (int j = 10; integralPartialDividend % j != 0 || integralPartialDividend != 0;) {
            tmpArr.add(integralPartialDividend % j);
            integralPartialDividend = integralPartialDividend - (integralPartialDividend % j);
            integralPartialDividend /= j;
        }
        Collections.reverse(tmpArr);

        for (int j = 0; j < tmpArr.size(); j++) {
            str += "<span class=\"item step-" + i + "\"\">" + tmpArr.get(j) + "</span>";
        }
        return str;
    }

    private String insertRemainderInSpan(int i) {
        String str = "";
        ArrayList<Integer> tmpArr = new ArrayList<Integer>();
        if (result.arrayOfSteps.get(i).getRemainder() == 0) {
            tmpArr.add(0);
        }
        int remainder = result.arrayOfSteps.get(i).getRemainder();
        for (int j = 10; remainder % j != 0 || remainder != 0;) {
            tmpArr.add(remainder % j);
            remainder = remainder - (remainder % j);
            remainder /= j;
        }
        Collections.reverse(tmpArr);

        for (int j = 0; j < tmpArr.size(); j++) {
            str += "<span class=\"item step-" + i + "\"\">" + tmpArr.get(j) + "</span>";
        }
        return str;
    }
}