package ua.com.foxminded.division;

import ua.com.foxminded.division.text.Formatter;
import ua.com.foxminded.division.text.JsonFormatter;

public class JsonFormatterFactotory implements FormatterFactory {

    public Formatter createFormatter() {
        return new JsonFormatter();
    }

}
