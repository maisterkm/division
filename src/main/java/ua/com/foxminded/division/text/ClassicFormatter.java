package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Result;

public class ClassicFormatter extends ConcatenationIntegralPartialDividend implements Formatter {
    private Result result;
    private String output = "";

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
        result.setPositionsBeforProduct(result.getPositionBiforeIntegralPartialDividend());
        while (j < result.arrayOfSteps.size()) {
            result.setPositionsBeforProduct(result.getPositionBiforeIntegralPartialDividend() + 1);
            for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
                output += " ";
            }
            output += result.arrayOfSteps.get(j).getProduct() + "\n";
            for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
                output += " ";
            }
            for (int i = 0; i < result.countDigitsInProduct(j); i++) {
                output += "-";
            }
            output += "\n";
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
        result.setPositionsBeforProduct(
                result.countDigitsInArray(result.partialDividend) - result.countDigitsInProduct(0));
        output += " ";
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += " ";
        }
        output += Integer.toString(result.arrayOfSteps.get(0).getProduct());
        if (result.countDigitsInProduct(0) + result.getPositionsBeforProduct() < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.digitsOfDividend.size() - result.countDigitsInProduct(0)
                    - result.getPositionsBeforProduct(); i++) {
                output += " ";
            }
        }
        output += "|";
        for (int i = 0; i < result.getTotalSizeDigitsOfQuotient(); i++) {
            output += "-";
        }
        output += "\n";
        output += " ";
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += " ";
        }
        for (int i = 0; i < result.countDigitsInProduct(0); i++) {
            output += "-";
        }
        if (result.countDigitsInProduct(0) + result.getPositionsBeforProduct() < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.digitsOfDividend.size() - result.countDigitsInProduct(0)
                    - result.getPositionsBeforProduct(); i++) {
                output += " ";
            }
        }
        output += "|";
        output += result.getQuotientAsString();
        output += "\n";
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
        output += "\n";
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
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
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += " ";
        }
        for (int i = 0; i < result.countDigitsInProduct(1); i++) {
            output += "-";
        }
        output += "\n";
        result.setPositionsBeforProduct(result.getPositionsBeforProduct() + 1 + result.countDigitsInProduct(1)
                - result.countDigitsInRemainder(1));
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += " ";
        }
        output += result.arrayOfSteps.get(1).getRemainder();
    }

    private void concatenateIfIntegralPartialDividendZero() {
        result.setPositionsBeforProduct(result.getPositionsBeforProduct() + result.countDigitsInProduct(0)
                - result.countDigitsInRemainder(0) + 1);
        for (int i = 0; i < result.getPositionsBeforProduct(); i++) {
            output += " ";
        }
        output += result.arrayOfSteps.get(0).getRemainder();
    }

    @Override
    protected String concatenateSpace() {
        return " ";
    }

    @Override
    protected String concatenateUnderscore() {
        return "_";
    }

    @Override
    protected String concatenateIntegralPartialDividend(int i) {
        return Integer.toString(result.arrayOfSteps.get(0).getIntegralPartialDividend());
    }
}