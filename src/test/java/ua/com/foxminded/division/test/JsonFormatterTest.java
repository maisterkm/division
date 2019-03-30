package ua.com.foxminded.division.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;
import ua.com.foxminded.division.text.Formatter;
import ua.com.foxminded.division.text.JsonFormatter;

public class JsonFormatterTest {

    Divider divider;
    Result result;
    Formatter formatter;
    
    @Before
    public void before() {
        divider = new Divider();
        result = new Result();
        formatter = new JsonFormatter();
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
    public void division5By5ShouldReturn1() {
        result = divider.divide(5, 5);
        String expected = "{\n" + 
                "\"dividend\":5,\n" + 
                "\"divisor\":5,\n" + 
                "\"partialDividend\":5,\n" + 
                "\"digitsOfDividend\":[5],\n" + 
                "\"digitsOfQuotient\":[1],\n" + 
                "\"product\":[5],\n" + 
                "\"integralPartialDividend\":[0],\n" + 
                "\"remainder\":[0]\n" + 
                "}";
        assertEquals(expected, formatter.format(result));
    }

}
