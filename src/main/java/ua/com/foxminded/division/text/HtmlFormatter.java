package ua.com.foxminded.division.text;

import java.util.ArrayList;
import java.util.Collections;

import ua.com.foxminded.division.math.Result;

public class HtmlFormatter extends ConcatenationIntegralPartialDividend implements Formatter {
    private Result result;
    String output = "<html><title>Division</title>" + "<head><link rel=\"stylesheet\" href=\"styles.css\">"
            + "<script src=\"javascript.js\"></script>" + "</head>" + "<body>";
    private ArrayList<Integer> arrDivisor = new ArrayList<Integer>();

    public String format(Result r) {
        result = r;
        if (result.arrayOfSteps.size() <= 2) {
            concatenateFirstStep();
            output += "</body></html>";
            return output;
        } else {
            concatenateFirstStep();
        }
        output += "<br>";
        int j = 1;
        result.setPositionsBeforProduct(result.getPositionBiforeIntegralPartialDividend());
        while (j < result.arrayOfSteps.size()) {
            result.setPositionsBeforProduct(result.getPositionBiforeIntegralPartialDividend() + 1);
            for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
                output += "<span class=\"item\">&nbsp;</span>";
            }
            output += insertProducInSpan(j);
            output += "<br>";
            for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
                output += "<span class=\"item\">&nbsp;</span>";
            }
            for (int i = 0; i < result.countDigitsInProduct(j); i++) {
                output += "<span class=\"item\">-</span>";
            }
            output += "<br>";
            if (result.countDigitsInProduct(j) == 1 && result.arrayOfSteps.get(j).getRemainder() == 0
                    && result.arrayOfSteps.size() - 1 != j) {
                result.setPositionsBeforProduct(result.getPositionsBeforProduct() + 1);
                result.setPositionBiforeIntegralPartialDividend(result.getPositionsBeforProduct()
                        + result.countDigitsInProduct(j) - result.countDigitsInRemainder(j) - 1);
            } else {
                result.setPositionBiforeIntegralPartialDividend(result.getPositionsBeforProduct()
                        + result.countDigitsInProduct(j) - result.countDigitsInRemainder(j) - 1);
            }
            for (int i = 0; i < result.getPositionBiforeIntegralPartialDividend(); i++) {
                output += "<span class=\"item\">&nbsp;</span>";
            }
            if (j < result.arrayOfSteps.size() - 1) {
                output += "<span class=\"item\">_</span>";
                output += concatenateIntegralPartialDividend(j);
                output += "<br>";
            } else {
                output += "<span class=\"item\">&nbsp;</span>";
                output += insertRemainderInSpan(j);
            }
            j++;
        }
        output += "</body></html>";
        return output;
    }

    private void concatenateFirstStep() {
        output += "<span class=\"item\">_</span>";
        for (int i = 0; i < result.digitsOfDividend.size(); i++) {
            output += "<span class=\"item" + "\">" + result.digitsOfDividend.get(i) + "</span>";
        }
        output += "<span class=\"item\">|</span>";
        arrDivisor.clear();
        arrDivisor = splitDivisorToDigits();
        for (int i : arrDivisor) {
            output += "<span class=\"item\">" + i + "</span>";
        }
        output += "<br>";
        result.setPositionsBeforProduct(
                result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0));
        output += "<span class=\"item\">&nbsp;</span>";
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        output += insertProducInSpan(0);
        output += addSpacesToString(result);
        output += "<span class=\"item\">|</span>";
        for (int i = 0; i < result.getTotalSizeDigitsOfQuotient(); i++) {
            output += "<span class=\"item\">-</span>";
        }
        output += "<br>";
        output += "<span class=\"item\">&nbsp;</span>";
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        for (int i = 0; i < result.countDigitsInProduct(0); i++) {
            output += "<span class=\"item\">-</span>";
        }
        output += addSpacesToString(result);
        output += "<span class=\"item\">|</span>";
        output += insertQuotientInSpan();
        output += "<br>";
        if (result.arrayOfSteps.size() <= 2 && result.arrayOfSteps.get(0).getIntegralPartialDividend() != 0) {
            output += concatenateIfIntegralPartialDividendNotZero(result);
        } else if (result.arrayOfSteps.size() == 1 && result.arrayOfSteps.get(0).getIntegralPartialDividend() == 0) {
            concatenateIfIntegralPartialDividendZero();
        } else if (result.arrayOfSteps.size() > 2) {
            if (result.arrayOfSteps.get(0).getIntegralPartialDividend() != 0) {
                output += concatenateIfIntegralPartialDividendNotZero(result);
            } else if (result.arrayOfSteps.get(0).getIntegralPartialDividend() == 0) {
                concatenateIfIntegralPartialDividendZero();
            }
        }
        if (result.arrayOfSteps.size() == 2) {
            concatenateIfIntegralPartialDividendMoreOne();
        }
    }

    private void concatenateIfIntegralPartialDividendMoreOne() {
        getPositionBeforProduct(result);
        output += "<br>";
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        if (result.digitsOfDividend.size() - result.countDigitsInArray(result.partialDividend) + 1 == 1) {
            output += concatenateIntegralPartialDividend(0);
        } else if (result.getValueOfLastIntegralPartialDividend() == 0) { // without minus
            output += "<span class=\"item\">&nbsp;</span>";
            output += insertProducInSpan(1);
        } else {
            output += "<span class=\"item\">_</span>";
            output += insertProducInSpan(1);
        }
        output += "<br>" + "<span class=\"item\">&nbsp;</span>";
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        for (int i = 0; i < result.countDigitsInProduct(1); i++) {
            output += "<span class=\"item\">-</span>";
        }
        output += "<br>";
        result.setPositionsBeforProduct(result.getPositionsBeforProduct() + 1 + result.countDigitsInProduct(1)
                - result.countDigitsInRemainder(1));
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += "<span class=\"item\">&nbsp;</span>";
        }
        output += insertRemainderInSpan(1);
    }
    
    private void concatenateIfIntegralPartialDividendZero() {
        result.setPositionsBeforProduct(result.getPositionsBeforProduct() + result.countDigitsInProduct(0)
                - result.countDigitsInRemainder(0) + 1);
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
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
                str += "<span class=\"item step-" + i + "\"onmouseover=\"mouseOver(this.className)\" onmouseout=\"mouseOut(this.className)\">"
                        + tmpQuotientArr.get(i).get(j) + "</span>";
            }
        }
        return str;
    }

    private String insertProducInSpan(int i) {
        String str = "";
        if (result.arrayOfSteps.get(i).getProduct() == 0) {
            return insertZeroItemInSpan(i);
        }
        int product = result.arrayOfSteps.get(i).getProduct();
        str = splitItemIntoDigits(product, i);
        return str;
    }

    private String insertRemainderInSpan(int i) {
        String str = "";
        if (result.arrayOfSteps.get(i).getRemainder() == 0) {
            return insertZeroItemInSpan(i);
        }
        int remainder = result.arrayOfSteps.get(i).getRemainder();
        str = splitItemIntoDigits(remainder, i);
        return str;
    }
    
    @Override
    public String concatenateSpace() {
        String output = "<span class=\"item\">&nbsp;</span>";
        return output;
    }
    
    @Override
    public String concatenateUnderscore() {
        String output = "<span class=\"item\">_</span>";
        return output;
    }
    
    @Override
    public String concatenateIntegralPartialDividend(int i) {
        String str = "";
        if (result.arrayOfSteps.get(i).getIntegralPartialDividend() == 0) {
            return insertZeroItemInSpan(i);
        }
        int integralPartialDividend = result.arrayOfSteps.get(i).getIntegralPartialDividend();
        str = splitItemIntoDigits(integralPartialDividend, i);
        return str;
    }
}
