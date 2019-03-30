package ua.com.foxminded.division.text;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;

public class JsonFormatterTest {

    Divider divider;
    Result result;
    Formatter formatter;
    
    @Before
    public void before() {
        divider = new Divider();
        result = new Result();
//        formatter = new JsonFormatter();
    }
    
    @Test
    public void stringShouldNotBeEmpty() {
        result = divider.divide(35, 5);
        String output = formatter.format(result);
        assertFalse(output.isEmpty());
    }
    
    @Test
    public void stringShouldNotBeNull() {
        result = divider.divide(35, 5);
        String output = formatter.format(result);
        assertNotNull(output);
    }
    
    @Test
    public void classicFormatterShouldReturnExpectedString() {
        result = divider.divide(78945, 4);
        String expected = "{\"dividend\":78945, "
                + "\"divisor\":4, \"partialDividend\":7, \"digitsOfDividend\":[7, 8, 9, 4, 5], "
                + "\"digitsOfQuotient\":[1, 9, 7, 3, 6], \"product\":[4, 36, 28, 12, 24], "
                + "\"integralPartialDividend\":[38, 29, 14, 25], \"remainder\":[3, 2, 1, 2, 1]}";
        assertEquals(expected, formatter.format(result));
    }

}
