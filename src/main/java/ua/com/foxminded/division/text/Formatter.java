package ua.com.foxminded.division.text;

import java.util.ArrayList;
import java.util.Collections;

import ua.com.foxminded.division.math.Result;

public interface Formatter {
    String format(Result r);

    default String addSpacesToString(Result result) {
        String output = "";
        if (result.countDigitsInProduct(0) + result.getPositionsBeforProduct() < result.digitsOfDividend.size()) {
            for (int i = 0; i < result.digitsOfDividend.size() - result.countDigitsInProduct(0)
                    - result.getPositionsBeforProduct(); i++) {
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
            break;
        }
    }

    default String splitItemIntoDigits(int item, int i) {
        String str = "";
        ArrayList<Integer> tmpArr = new ArrayList<Integer>();
        for (int j = 10; item % j != 0 || item != 0;) {
            tmpArr.add(item % j);
            item = item - (item % j);
            item /= j;
        }
        Collections.reverse(tmpArr);

        for (int j : tmpArr) {
            str += "<span class=\"item step-" + i + "\">" + j + "</span>";
        }
        return str;
    }

    default String insertZeroItemInSpan(int i) {
        return "<span class=\"item step-" + i + "\">" + 0 + "</span>";
    }
}
