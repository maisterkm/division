package ua.com.foxminded.division;

import ua.com.foxminded.division.text.Formatter;
import ua.com.foxminded.division.text.HtmlFormatter;

public class HtmlFormatterFactory implements FormatterFactory {

    public Formatter createFormatter() {
        return new HtmlFormatter();
    }

}
