package ua.com.foxminded.division.text;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;

public class ClassicFormatterTest {
    Divider divider;
    Result result;
    Formatter formatter;
    
    @Before
    public void before() {
        divider = new Divider();
        result = new Result();
        formatter = new ClassicFormatter();
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
        String expected = "_78945|4\n 4    |-----\n -    |19736\n_38\n 36\n --\n _29\n" + 
                "  28\n  --\n  _14\n   12\n   --\n   _25\n    24\n    --\n     1";
        assertEquals(expected, formatter.format(result));
    }

}



