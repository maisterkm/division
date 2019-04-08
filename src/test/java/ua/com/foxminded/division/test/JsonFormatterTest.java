package ua.com.foxminded.division.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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
        String expected = "{\n" + "\"dividend\":5,\n" + "\"divisor\":5,\n" + "\"partialDividend\":5,\n"
                + "\"digitsOfDividend\":[5],\n" + "\"digitsOfQuotient\":[1],\n" + "\"product\":[5],\n"
                + "\"integralPartialDividend\":[0],\n" + "\"remainder\":[0]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division5By8ShouldReturn0() {
        result = divider.divide(5, 8);
        String expected = "{\n" + "\"dividend\":5,\n" + "\"divisor\":8,\n" + "\"partialDividend\":5,\n"
                + "\"digitsOfDividend\":[5],\n" + "\"digitsOfQuotient\":[0],\n" + "\"product\":[0],\n"
                + "\"integralPartialDividend\":[0],\n" + "\"remainder\":[5]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division0By5ShouldReturn0() {
        result = divider.divide(0, 5);
        String expected = "{\n" + "\"dividend\":0,\n" + "\"divisor\":5,\n" + "\"partialDividend\":0,\n"
                + "\"digitsOfDividend\":[0],\n" + "\"digitsOfQuotient\":[0],\n" + "\"product\":[0],\n"
                + "\"integralPartialDividend\":[0],\n" + "\"remainder\":[0]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division78945By4ShouldReturn19736() {
        result = divider.divide(78945, 4);
        String expected = "{\n" + "\"dividend\":78945,\n" + "\"divisor\":4,\n" + "\"partialDividend\":7,\n"
                + "\"digitsOfDividend\":[7, 8, 9, 4, 5],\n" + "\"digitsOfQuotient\":[1, 9, 7, 3, 6],\n"
                + "\"product\":[4, 36, 28, 12, 24],\n" + "\"integralPartialDividend\":[38, 29, 14, 25, 0],\n"
                + "\"remainder\":[3, 2, 1, 2, 1]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division512By8ShouldReturn64() {
        result = divider.divide(512, 8);
        String expected = "{\n" + "\"dividend\":512,\n" + "\"divisor\":8,\n" + "\"partialDividend\":51,\n"
                + "\"digitsOfDividend\":[5, 1, 2],\n" + "\"digitsOfQuotient\":[6, 4],\n" + "\"product\":[48, 32],\n"
                + "\"integralPartialDividend\":[32, 0],\n" + "\"remainder\":[3, 0]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1564By23ShouldReturn68() {
        result = divider.divide(1564, 23);
        String expected = "{\n" + "\"dividend\":1564,\n" + "\"divisor\":23,\n" + "\"partialDividend\":156,\n"
                + "\"digitsOfDividend\":[1, 5, 6, 4],\n" + "\"digitsOfQuotient\":[6, 8],\n"
                + "\"product\":[138, 184],\n" + "\"integralPartialDividend\":[184, 0],\n" + "\"remainder\":[18, 0]\n"
                + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division92By9ShouldReturn10() {
        result = divider.divide(92, 9);
        String expected = "{\n" + "\"dividend\":92,\n" + "\"divisor\":9,\n" + "\"partialDividend\":9,\n"
                + "\"digitsOfDividend\":[9, 2],\n" + "\"digitsOfQuotient\":[10],\n" + "\"product\":[9],\n"
                + "\"integralPartialDividend\":[2],\n" + "\"remainder\":[0]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division3333By33ShouldReturn101() {
        result = divider.divide(3333, 33);
        String expected = "{\n" + "\"dividend\":3333,\n" + "\"divisor\":33,\n" + "\"partialDividend\":33,\n"
                + "\"digitsOfDividend\":[3, 3, 3, 3],\n" + "\"digitsOfQuotient\":[10, 1],\n" + "\"product\":[33, 33],\n"
                + "\"integralPartialDividend\":[33, 0],\n" + "\"remainder\":[0, 0]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division333By33ShouldReturn10() {
        result = divider.divide(333, 33);
        String expected = "{\n" + "\"dividend\":333,\n" + "\"divisor\":33,\n" + "\"partialDividend\":33,\n"
                + "\"digitsOfDividend\":[3, 3, 3],\n" + "\"digitsOfQuotient\":[10],\n" + "\"product\":[33],\n"
                + "\"integralPartialDividend\":[3],\n" + "\"remainder\":[0]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division103By33ShouldReturn3() {
        result = divider.divide(103, 33);
        String expected = "{\n" + "\"dividend\":103,\n" + "\"divisor\":33,\n" + "\"partialDividend\":103,\n"
                + "\"digitsOfDividend\":[1, 0, 3],\n" + "\"digitsOfQuotient\":[3],\n" + "\"product\":[99],\n"
                + "\"integralPartialDividend\":[0],\n" + "\"remainder\":[4]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1260257By37ShouldReturn34061() {
        result = divider.divide(1260257, 37);
        String expected = "{\n" + "\"dividend\":1260257,\n" + "\"divisor\":37,\n" + "\"partialDividend\":126,\n"
                + "\"digitsOfDividend\":[1, 2, 6, 0, 2, 5, 7],\n" + "\"digitsOfQuotient\":[3, 4, 06, 1],\n"
                + "\"product\":[111, 148, 222, 37],\n" + "\"integralPartialDividend\":[150, 225, 37, 0],\n"
                + "\"remainder\":[15, 2, 3, 0]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division777By16ShouldReturn48() {
        result = divider.divide(777, 16);
        String expected = "{\n" + "\"dividend\":777,\n" + "\"divisor\":16,\n" + "\"partialDividend\":77,\n"
                + "\"digitsOfDividend\":[7, 7, 7],\n" + "\"digitsOfQuotient\":[4, 8],\n" + "\"product\":[64, 128],\n"
                + "\"integralPartialDividend\":[137, 0],\n" + "\"remainder\":[13, 9]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1001By22ShouldReturn45() {
        result = divider.divide(1001, 22);
        String expected = "{\n" + "\"dividend\":1001,\n" + "\"divisor\":22,\n" + "\"partialDividend\":100,\n"
                + "\"digitsOfDividend\":[1, 0, 0, 1],\n" + "\"digitsOfQuotient\":[4, 5],\n" + "\"product\":[88, 110],\n"
                + "\"integralPartialDividend\":[121, 0],\n" + "\"remainder\":[12, 11]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division100By8ShouldReturn12() {
        result = divider.divide(100, 8);
        String expected = "{\n" + "\"dividend\":100,\n" + "\"divisor\":8,\n" + "\"partialDividend\":10,\n"
                + "\"digitsOfDividend\":[1, 0, 0],\n" + "\"digitsOfQuotient\":[1, 2],\n" + "\"product\":[8, 16],\n"
                + "\"integralPartialDividend\":[20, 0],\n" + "\"remainder\":[2, 4]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1001By8ShouldReturn125() {
        result = divider.divide(1001, 8);
        String expected = "{\n" + "\"dividend\":1001,\n" + "\"divisor\":8,\n" + "\"partialDividend\":10,\n"
                + "\"digitsOfDividend\":[1, 0, 0, 1],\n" + "\"digitsOfQuotient\":[1, 2, 5],\n"
                + "\"product\":[8, 16, 40],\n" + "\"integralPartialDividend\":[20, 41, 0],\n"
                + "\"remainder\":[2, 4, 1]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division512By48ShouldReturn10() {
        result = divider.divide(512, 48);
        String expected = "{\n" + "\"dividend\":512,\n" + "\"divisor\":48,\n" + "\"partialDividend\":51,\n"
                + "\"digitsOfDividend\":[5, 1, 2],\n" + "\"digitsOfQuotient\":[10],\n" + "\"product\":[48],\n"
                + "\"integralPartialDividend\":[32],\n" + "\"remainder\":[3]\n" + "}";
        assertEquals(expected, formatter.format(result));
    }

}
