package ua.com.foxminded.division.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;
import ua.com.foxminded.division.text.ClassicFormatter;
import ua.com.foxminded.division.text.Formatter;

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
    public void division5By5ShouldReturn1() {
        result = divider.divide(5, 5);
        String expected = "_5|5\n" + 
                          " 5|-\n" + 
                          " -|1\n" + 
                          " 0";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division5By8ShouldReturn0() {
        result = divider.divide(5, 8);
        String expected = "_5|8\n" + 
                          " 0|-\n" + 
                          " -|0\n" + 
                          " 5";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division0By5ShouldReturn0() {
        result = divider.divide(0, 5);
        String expected = "_0|5\n" + 
                          " 0|-\n" + 
                          " -|0\n" + 
                          " 0";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division78945By4ShouldReturn19736() {
        result = divider.divide(78945, 4);
        String expected = "_78945|4\n" + 
                          " 4    |-----\n" + 
                          " -    |19736\n" + 
                          "_38\n" + 
                          " 36\n" + 
                          " --\n" + 
                          " _29\n" + 
                          "  28\n" + 
                          "  --\n" + 
                          "  _14\n" + 
                          "   12\n" + 
                          "   --\n" + 
                          "   _25\n" + 
                          "    24\n" + 
                          "    --\n" + 
                          "     1";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division512By8ShouldReturn64() {
        result = divider.divide(512, 8);
        String expected = "_512|8\n" + 
                          " 48 |--\n" + 
                          " -- |64\n" + 
                           " _32\n" + 
                           "  32\n" + 
                           "  --\n" + 
                           "   0";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1564By23ShouldReturn68() {
        result = divider.divide(1564, 23);
        String expected = "_1564|23\n" + 
                          " 138 |--\n" + 
                          " --- |68\n" + 
                          " _184\n" + 
                          "  184\n" + 
                          "  ---\n" + 
                          "    0";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division92By9ShouldReturn10() {
        result = divider.divide(92, 9);
        String expected = "_92|9\n" + 
                          " 9 |--\n" + 
                          " - |10\n" + 
                          "  2";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division3333By33ShouldReturn101() {
        result = divider.divide(3333, 33);
        String expected = "_3333|33\n" + 
                          " 33  |---\n" + 
                          " --  |101\n" + 
                          "  _33\n" + 
                          "   33\n" + 
                          "   --\n" + 
                          "    0";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division333By33ShouldReturn10() {
        result = divider.divide(333, 33);
        String expected = "_333|33\n" + 
                          " 33 |--\n" + 
                          " -- |10\n" + 
                          "   3";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division103By33ShouldReturn3() {
        result = divider.divide(103, 33);
        String expected = "_103|33\n" + 
                          "  99|-\n" + 
                          "  --|3\n" + 
                          "   4";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1260257By37ShouldReturn34061() {
        result = divider.divide(1260257, 37);
        String expected = "_1260257|37\n" + 
                          " 111    |-----\n" + 
                          " ---    |34061\n" + 
                          " _150\n" + 
                          "  148\n" + 
                          "  ---\n" + 
                          "   _225\n" + 
                          "    222\n" + 
                          "    ---\n" + 
                          "     _37\n" + 
                          "      37\n" + 
                          "      --\n" + 
                          "       0";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division777By16ShouldReturn48() {
        result = divider.divide(777, 16);
        String expected = "_777|16\n" + 
                          " 64 |--\n" + 
                          " -- |48\n" + 
                          "_137\n" + 
                          " 128\n" + 
                          " ---\n" + 
                          "   9";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1001By22ShouldReturn45() {
        result = divider.divide(1001, 22);
        String expected = "_1001|22\n" + 
                          "  88 |--\n" + 
                          "  -- |45\n" + 
                           " _121\n" + 
                           "  110\n" + 
                           "  ---\n" + 
                           "   11";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division100By8ShouldReturn12() {
        result = divider.divide(100, 8);
        String expected = "_100|8\n" + 
                          "  8 |--\n" + 
                          "  - |12\n" + 
                          " _20\n" + 
                          "  16\n" + 
                          "  --\n" + 
                          "   4";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1001By8ShouldReturn125() {
        result = divider.divide(1001, 8);
        String expected = "_1001|8\n" + 
                          "  8  |---\n" + 
                          "  -  |125\n" + 
                          " _20\n" + 
                          "  16\n" + 
                          "  --\n" + 
                          "  _41\n" + 
                          "   40\n" + 
                          "   --\n" + 
                          "    1";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division512By48ShouldReturn10() {
        result = divider.divide(512, 48);
        String expected = "_512|48\n" + 
                           " 48 |--\n" + 
                           " -- |10\n" + 
                           "  32";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division123456789By1ShouldReturn123456789() {
        result = divider.divide(123456789, 1);
        String expected = "_123456789|1\n" + 
                          " 1        |---------\n" + 
                          " -        |123456789\n" + 
                          " _2\n" + 
                          "  2\n" + 
                          "  -\n" + 
                          "  _3\n" + 
                          "   3\n" + 
                          "   -\n" + 
                          "   _4\n" + 
                          "    4\n" + 
                          "    -\n" + 
                          "    _5\n" + 
                          "     5\n" + 
                          "     -\n" + 
                          "     _6\n" + 
                          "      6\n" + 
                          "      -\n" + 
                          "      _7\n" + 
                          "       7\n" + 
                          "       -\n" + 
                          "       _8\n" + 
                          "        8\n" + 
                          "        -\n" + 
                          "        _9\n" + 
                          "         9\n" + 
                          "         -\n" + 
                          "         0";
        assertEquals(expected, formatter.format(result));
    }
}
