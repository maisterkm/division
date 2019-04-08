package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Result;

public class ClassicFormatter implements Formatter {
    private Result result;
    private String output = "";
    private int positionsBeforProduct = 0;
    private int positionBiforeIntegralPartialDividend = 1;

    public String format(Result r) {
        result = r;
        if (result.arrayOfSteps.size() <= 2) {
            concatenateFirstStep();
            return output;
        } else {
            concatenateFirstStep();
        }
        output += "\n";
        int j = 1;
        positionsBeforProduct = positionBiforeIntegralPartialDividend;
        while (j < result.arrayOfSteps.size()) {
            positionsBeforProduct = positionBiforeIntegralPartialDividend + 1;
            for (int i = 0; i < positionsBeforProduct; i++) {
                output += " ";
            }
            output += result.arrayOfSteps.get(j).getProduct() + "\n";
            for (int i = 0; i < positionsBeforProduct; i++) {
                output += " ";
            }
            for (int i = 0; i < result.countDigitsInProduct(j); i++) {
                output += "-";
            }
            output += "\n";
            positionBiforeIntegralPartialDividend = positionsBeforProduct + result.countDigitsInProduct(j)
                    - result.countDigitsInRemainder(j) - 1;
            for (int i = 0; i < positionBiforeIntegralPartialDividend; i++) {
                output += " ";
            }
            if (j < result.arrayOfSteps.size() - 1) {
                output += "_" + result.arrayOfSteps.get(j).getIntegralPartialDividend() + "\n";
            } else {
                output += " " + result.arrayOfSteps.get(j).getRemainder();
            }
            j++;
        }
        return output;
    }

    private void concatenateFirstStep() {
        output = "_" + result.getDividend() + "|" + result.getDivisor() + "\n";
        positionsBeforProduct = result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0);
        output += " ";
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += " ";
        }
        output += Integer.toString(result.arrayOfSteps.get(0).getProduct());
        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.digitsOfDividend.size() - result.countDigitsInProduct(0)
                    - positionsBeforProduct; i++) {
                output += " ";
            }
        }
        output += "|";
        for (int i = 0; i < result.getTotalSizeDigitsOfQuotient(); i++) {
            output += "-";
        }
        output += "\n";
        output += " ";
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += " ";
        }
        for (int i = 0; i < result.countDigitsInProduct(0); i++) {
            output += "-";
        }
        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.digitsOfDividend.size() - result.countDigitsInProduct(0)
                    - positionsBeforProduct; i++) {
                output += " ";
            }
        }
        output += "|";
        output += result.getQuotientAsString();
        output += "\n";
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
        output += "\n";
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += " ";
        }
        if (result.digitsOfDividend.size() - result.countDigitsInArray(result.partialDividend) + 1 == 1) {
            output += result.arrayOfSteps.get(0).getIntegralPartialDividend();
        } else if (result.getValueOfLastIntegralPartialDividend() == 0) { // without minus
            output += " " + result.arrayOfSteps.get(1).getProduct();
        } else {
            output += "_" + result.arrayOfSteps.get(1).getProduct();
        }
        output += "\n ";
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += " ";
        }
        for (int i = 0; i < result.countDigitsInProduct(1); i++) {
            output += "-";
        }
        output += "\n";
        positionsBeforProduct += 1 + result.countDigitsInProduct(1) - result.countDigitsInRemainder(1);
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += " ";
        }
        output += result.arrayOfSteps.get(1).getRemainder();
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
            output += " ";
        }
        if (result.arrayOfSteps.size() > 1) {
            output += "_" + result.arrayOfSteps.get(0).getIntegralPartialDividend();
        } else {
            if (result.arrayOfSteps.get(0).getRemainder() == 0) {
                output += result.arrayOfSteps.get(0).getIntegralPartialDividend();
            } else {
                for (int i = 0; i < result.countDigitsInProduct(0) - result.countDigitsInRemainder(0); i++) {
                    output += " ";
                }
                output += result.arrayOfSteps.get(0).getIntegralPartialDividend();
            }
        }
    }

    private void concatenateIfIntegralPartialDividendZero() {
        positionsBeforProduct += result.countDigitsInProduct(0) - result.countDigitsInRemainder(0) + 1;
        for (int i = 0; i < positionsBeforProduct; i++) {
            output += " ";
        }
        output += result.arrayOfSteps.get(0).getRemainder();
    }
}