package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Result;

public abstract class AbstractFormatter {
    protected abstract String concatenateSpace();
    protected abstract String concatenateUnderscore();
    protected abstract String concatenateIntegralPartialDividend(int i);
    
    protected String concatenateIfIntegralPartialDividendNotZero(Result result) {
        String output = "";
        if (result.arrayOfSteps.get(0).getRemainder() != 0) {
            if (result.countDigitsInProduct(0) == 2 && result.countDigitsInIntegralPartialDividend(0) == 3) {
                result.setPositionBiforeIntegralPartialDividend(
                        Math.abs(result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0)));
            } else if (result.countDigitsInArray(result.partialDividend) > result.countDigitsInProduct(0)) {
                result.setPositionBiforeIntegralPartialDividend(
                        Math.abs(result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0)));
            } else {
                result.setPositionBiforeIntegralPartialDividend(
                        Math.abs(result.countDigitsInProduct(0) - result.countDigitsInRemainder(0)));
            }
        }
        if (result.arrayOfSteps.get(0).getRemainder() == 0) {
            if (result.arrayOfSteps.size() == 1 && result.arrayOfSteps.get(0).getIntegralPartialDividend() != 0) {
                for (int i = 0; i < result.countDigitsInProduct(0); i++) {
                    result.setPositionBiforeIntegralPartialDividend(
                            result.getPositionBiforeIntegralPartialDividend() + 1);
                }
            } else {
                for (int i = 0; i < result.countDigitsInProduct(0) - 1; i++) {
                    result.setPositionBiforeIntegralPartialDividend(
                            result.getPositionBiforeIntegralPartialDividend() + 1);
                }
            }
        }
        for (int i = 0; i < result.getPositionBiforeIntegralPartialDividend(); i++) {
            output += concatenateSpace();
        }
        if (result.arrayOfSteps.size() > 1) {
            output += concatenateUnderscore();
            output += concatenateIntegralPartialDividend(0);
        } else {
            if (result.arrayOfSteps.get(0).getRemainder() == 0) {
                output += concatenateIntegralPartialDividend(0);
            } else {
                for (int i = 0; i < result.countDigitsInProduct(0) - result.countDigitsInRemainder(0); i++) {
                    output += concatenateSpace();
                }
                output += concatenateIntegralPartialDividend(0);
            }
        }
        return output;
    }
}
