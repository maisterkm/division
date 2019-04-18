package ua.com.foxminded.division.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;
import ua.com.foxminded.division.text.Formatter;
import ua.com.foxminded.division.text.HtmlFormatter;

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
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">5</span>"
                + "<span class=\"item\">|</span><span class=\"item\">5</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">5</span><span class=\"item\">|</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">-</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">1</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">0</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division5By8ShouldReturn0() {
        result = divider.divide(5, 8);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">5</span>"
                + "<span class=\"item\">|</span><span class=\"item\">8</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">0</span><span class=\"item\">|</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">-</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">0</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">5</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division0By5ShouldReturn0() {
        result = divider.divide(0, 5);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">0</span>"
                + "<span class=\"item\">|</span><span class=\"item\">5</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">0</span><span class=\"item\">|</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">-</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">0</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">0</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division78945By4ShouldReturn19736() {
        result = divider.divide(78945, 4);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">7</span>"
                + "<span class=\"item\">8</span><span class=\"item\">9</span><span class=\"item\">4</span><span class=\"item\">5</span>"
                + "<span class=\"item\">|</span><span class=\"item\">4</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">4</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">1</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">9</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-2\">7</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-3\">3</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-4\">6</span><br><span class=\"item\">_</span>"
                + "<span class=\"item step-0\">3</span><span class=\"item step-0\">8</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-1\">3</span><span class=\"item step-1\">6</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">_</span><span class=\"item step-1\">2</span><span class=\"item step-1\">9</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-2\">2</span>"
                + "<span class=\"item step-2\">8</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">_</span><span class=\"item step-2\">1</span>"
                + "<span class=\"item step-2\">4</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-3\">1</span><span class=\"item step-3\">2</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">_</span>"
                + "<span class=\"item step-3\">2</span><span class=\"item step-3\">5</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-4\">2</span><span class=\"item step-4\">4</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-4\">1</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division512By8ShouldReturn64() {
        result = divider.divide(512, 8);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">5</span>"
                + "<span class=\"item\">1</span><span class=\"item\">2</span><span class=\"item\">|</span><span class=\"item\">8</span>"
                + "<br><span class=\"item\">&nbsp;</span><span class=\"item step-0\">4</span><span class=\"item step-0\">8</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">|</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">6</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">4</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">_</span><span class=\"item step-0\">3</span><span class=\"item step-0\">2</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-1\">3</span>"
                + "<span class=\"item step-1\">2</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-1\">0</span>"
                + "</body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1564By23ShouldReturn68() {
        result = divider.divide(1564, 23);
        String expected = "<html><title>Division</title>"
                + "<head><link rel=\"stylesheet\" href=\"styles.css\"><script src=\"javascript.js\"></script></head>"
                + "<body><span class=\"item\">_</span><span class=\"item\">1</span>"
                + "<span class=\"item\">5</span><span class=\"item\">6</span><span class=\"item\">4</span>"
                + "<span class=\"item\">|</span><span class=\"item\">2</span>"
                + "<span class=\"item\">3</span><br><span class=\"item\">&nbsp;</span><span class=\"item step-0\">1</span>"
                + "<span class=\"item step-0\">3</span><span class=\"item step-0\">8</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">|</span><span class=\"item\">-</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">-</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">6</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">8</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">_</span><span class=\"item step-0\">1</span>"
                + "<span class=\"item step-0\">8</span><span class=\"item step-0\">4</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-1\">1</span><span class=\"item step-1\">8</span>"
                + "<span class=\"item step-1\">4</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-1\">0</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division92By9ShouldReturn10() {
        result = divider.divide(92, 9);
        String expected = "<html><title>Division</title><head>"
                + "<link rel=\"stylesheet\" href=\"styles.css\"><script src=\"javascript.js\"></script></head>"
                + "<body><span class=\"item\">_</span><span class=\"item\">9</span>"
                + "<span class=\"item\">2</span><span class=\"item\">|</span><span class=\"item\">9</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-0\">9</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">|</span><span class=\"item\">-</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">-</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">|</span><span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">1</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">0</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-0\">2</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division3333By33ShouldReturn101() {
        result = divider.divide(3333, 33);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">3</span>"
                + "<span class=\"item\">3</span><span class=\"item\">3</span><span class=\"item\">3</span><span class=\"item\">|</span>"
                + "<span class=\"item\">3</span><span class=\"item\">3</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">3</span><span class=\"item step-0\">3</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">|</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">1</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">0</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">1</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">_</span>"
                + "<span class=\"item step-0\">3</span><span class=\"item step-0\">3</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-1\">3</span>"
                + "<span class=\"item step-1\">3</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-1\">0</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division333By33ShouldReturn10() {
        result = divider.divide(333, 33);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">3</span>"
                + "<span class=\"item\">3</span><span class=\"item\">3</span><span class=\"item\">|</span><span class=\"item\">3</span>"
                + "<span class=\"item\">3</span><br><span class=\"item\">&nbsp;</span><span class=\"item step-0\">3</span>"
                + "<span class=\"item step-0\">3</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">1</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">0</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-0\">3</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division103By33ShouldReturn3() {
        result = divider.divide(103, 33);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">1</span>"
                + "<span class=\"item\">0</span><span class=\"item\">3</span><span class=\"item\">|</span><span class=\"item\">3</span>"
                + "<span class=\"item\">3</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">9</span><span class=\"item step-0\">9</span><span class=\"item\">|</span>"
                + "<span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">3</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-0\">4</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1260257By37ShouldReturn34061() {
        result = divider.divide(1260257, 37);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">1</span>"
                + "<span class=\"item\">2</span><span class=\"item\">6</span><span class=\"item\">0</span><span class=\"item\">2</span>"
                + "<span class=\"item\">5</span><span class=\"item\">7</span><span class=\"item\">|</span><span class=\"item\">3</span>"
                + "<span class=\"item\">7</span><br><span class=\"item\">&nbsp;</span><span class=\"item step-0\">1</span>"
                + "<span class=\"item step-0\">1</span><span class=\"item step-0\">1</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">|</span><span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">|</span><span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">3</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">4</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-2\">0</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-2\">6</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-3\">1</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">_</span><span class=\"item step-0\">1</span>"
                + "<span class=\"item step-0\">5</span><span class=\"item step-0\">0</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-1\">1</span><span class=\"item step-1\">4</span>"
                + "<span class=\"item step-1\">8</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;"
                + "</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">_</span>"
                + "<span class=\"item step-1\">2</span><span class=\"item step-1\">2</span><span class=\"item step-1\">5</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-2\">2</span><span class=\"item step-2\">2</span>"
                + "<span class=\"item step-2\">2</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">_</span><span class=\"item step-2\">3</span>"
                + "<span class=\"item step-2\">7</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-3\">3</span><span class=\"item step-3\">7</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-3\">0</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division777By16ShouldReturn48() {
        result = divider.divide(777, 16);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">7</span>"
                + "<span class=\"item\">7</span><span class=\"item\">7</span><span class=\"item\">|</span><span class=\"item\">1</span>"
                + "<span class=\"item\">6</span><br><span class=\"item\">&nbsp;</span><span class=\"item step-0\">6</span>"
                + "<span class=\"item step-0\">4</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">4</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">8</span><br><span class=\"item\">_</span>"
                + "<span class=\"item step-0\">1</span><span class=\"item step-0\">3</span><span class=\"item step-0\">7</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-1\">1</span><span class=\"item step-1\">2</span>"
                + "<span class=\"item step-1\">8</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-1\">9</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1001By22ShouldReturn45() {
        result = divider.divide(1001, 22);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">1</span>"
                + "<span class=\"item\">0</span><span class=\"item\">0</span><span class=\"item\">1</span><span class=\"item\">|</span>"
                + "<span class=\"item\">2</span><span class=\"item\">2</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-0\">8</span><span class=\"item step-0\">8</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">|</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">4</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">5</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">_</span><span class=\"item step-0\">1</span>"
                + "<span class=\"item step-0\">2</span><span class=\"item step-0\">1</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-1\">1</span><span class=\"item step-1\">1</span>"
                + "<span class=\"item step-1\">0</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;"
                + "</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-1\">1</span>"
                + "<span class=\"item step-1\">1</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division100By8ShouldReturn12() {
        result = divider.divide(100, 8);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">1</span>"
                + "<span class=\"item\">0</span><span class=\"item\">0</span><span class=\"item\">|</span><span class=\"item\">8</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-0\">8</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">|</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">1</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">2</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">_</span><span class=\"item step-0\">2</span><span class=\"item step-0\">0</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-1\">1</span>"
                + "<span class=\"item step-1\">6</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-1\">4</span>"
                + "</body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division1001By8ShouldReturn125() {
        result = divider.divide(1001, 8);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">1</span>"
                + "<span class=\"item\">0</span><span class=\"item\">0</span><span class=\"item\">1</span><span class=\"item\">|</span>"
                + "<span class=\"item\">8</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">8</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">|</span><span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">1</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">2</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-2\">5</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">_</span><span class=\"item step-0\">2</span><span class=\"item step-0\">0</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-1\">1</span>"
                + "<span class=\"item step-1\">6</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">_</span><span class=\"item step-1\">4</span>"
                + "<span class=\"item step-1\">1</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-2\">4</span><span class=\"item step-2\">0</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-2\">1</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division512By48ShouldReturn10() {
        result = divider.divide(512, 48);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">5</span>"
                + "<span class=\"item\">1</span><span class=\"item\">2</span><span class=\"item\">|</span><span class=\"item\">4</span>"
                + "<span class=\"item\">8</span><br><span class=\"item\">&nbsp;</span><span class=\"item step-0\">4</span>"
                + "<span class=\"item step-0\">8</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">&nbsp;</span><span class=\"item\">|</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">1</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">0</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-0\">3</span><span class=\"item step-0\">2</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

    @Test
    public void division123456789By1ShouldReturn123456789() {
        result = divider.divide(123456789, 1);
        String expected = "<html><title>Division</title><head><link rel=\"stylesheet\" href=\"styles.css\">"
                + "<script src=\"javascript.js\"></script></head><body><span class=\"item\">_</span><span class=\"item\">1</span>"
                + "<span class=\"item\">2</span><span class=\"item\">3</span><span class=\"item\">4</span><span class=\"item\">5</span>"
                + "<span class=\"item\">6</span><span class=\"item\">7</span><span class=\"item\">8</span><span class=\"item\">9</span>"
                + "<span class=\"item\">|</span><span class=\"item\">1</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-0\">1</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">|</span><span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span><span class=\"item\">-</span>"
                + "<span class=\"item\">-</span><span class=\"item\">-</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">-</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">|</span><span \" onClick=\"changeColor(this.className)\" class=\"item step-0\">1</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-1\">2</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-2\">3</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-3\">4</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-4\">5</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-5\">6</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-6\">7</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-7\">8</span>"
                + "<span \" onClick=\"changeColor(this.className)\" class=\"item step-8\">9</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">_</span><span class=\"item step-0\">2</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-1\">2</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">_</span>"
                + "<span class=\"item step-1\">3</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-2\">3</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">_</span><span class=\"item step-2\">4</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-3\">4</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">_</span><span class=\"item step-3\">5</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-4\">5</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">_</span>"
                + "<span class=\"item step-4\">6</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-5\">6</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">_</span><span class=\"item step-5\">7</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-6\">7</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">_</span><span class=\"item step-6\">8</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item step-7\">8</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">_</span>"
                + "<span class=\"item step-7\">9</span><br><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item step-8\">9</span><br><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">-</span><br>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span><span class=\"item\">&nbsp;</span>"
                + "<span class=\"item step-8\">0</span></body></html>";
        assertEquals(expected, formatter.format(result));
    }

}
