package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Result;

public interface Formatter {
    String format(Result r);

    default String addSpacesToString(int positionsBeforProduct, Result result) {
        String output = "";
        if (result.countDigitsInProduct(0) + positionsBeforProduct < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.digitsOfDividend.size() - result.countDigitsInProduct(0)
                    - positionsBeforProduct; i++) {
                output += "<span class=\"item\">&nbsp;</span>";
            }
        }
        return output;
    }

    default void getPositionBeforProduct(Result result) {
        switch (result.countDigitsInIntegralPartialDividend(0)) {
        case (1):
            if (result.countDigitsInProduct(0) == 2) {
                result.setPositionBiforeIntegralPartialDividend(result.getPositionBiforeIntegralPartialDividend() + 1);
            }
            break;
        case (2):
        case (3):
            result.setPositionsBeforProduct(result.getPositionBiforeIntegralPartialDividend()
                    + (result.countDigitsInIntegralPartialDividend(0) - result.countDigitsInProduct(1)));
//            positionsBeforProduct = positionBiforeIntegralPartialDividend
//                    + (result.countDigitsInIntegralPartialDividend(0) - result.countDigitsInProduct(1));
            break;
        }
    }
}
