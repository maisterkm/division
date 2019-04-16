package ua.com.foxminded.division;

import ua.com.foxminded.division.text.Formatter;

public class Factory {
    public Formatter getFormatter(String str) {
        if (str.equals("-c")) {
            ClassicFormatterFactory classicFormatterFactory = new ClassicFormatterFactory();
            return classicFormatterFactory.createFormatter();
        } else if (str.equals("-j")) {
            JsonFormatterFactotory jsonFormatterFactory = new JsonFormatterFactotory();
            return jsonFormatterFactory.createFormatter();
        } else if (str.equals("-h")) {
            HtmlFormatterFactory htmlFormatterFactory = new HtmlFormatterFactory();
            return htmlFormatterFactory.createFormatter();
        } else {
            return null;
        }
    }
}
