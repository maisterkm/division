package ua.com.foxminded.division.text;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;

public class HtmlFormatterTest {

    Divider divider;
    Result result;
    Formatter formatter;
    
    @Before
    public void before() {
        divider = new Divider();
        result = new Result();
        formatter = new HtmlFormatter();
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
        String expected = "<html>\n" + 
                "<title>Division</title>\n" + 
                "<body>\n" + 
                "<pre>\n" + 
                "_5|5\n" + 
                " 5|-\n" + 
                " -|1\n" + 
                " 0\n" + 
                "</pre>\n" + 
                "</body>\n" + 
                "</html>";
        assertEquals(expected, formatter.format(result));
    }

}
