package ua.com.foxminded.division;

import ua.com.foxminded.division.text.ClassicFormatter;
import ua.com.foxminded.division.text.Formatter;

public class ClassicFormatterFactory implements FormatterFactory {

    public Formatter createFormatter() {
        return new ClassicFormatter();
    }

}
