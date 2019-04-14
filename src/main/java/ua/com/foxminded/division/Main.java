package ua.com.foxminded.division;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;
import ua.com.foxminded.division.text.ClassicFormatter;
import ua.com.foxminded.division.text.Formatter;
import ua.com.foxminded.division.text.HtmlFormatter;
import ua.com.foxminded.division.text.JsonFormatter;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            printWrongArgument();
            System.exit(1);
        }

        if (args[2].contentEquals("-c")) {
            Result result = divide(args[0], args[1]);
            Formatter formatter = new ClassicFormatter();
            String output = formatter.format(result);
            System.out.printf(output);
        }

        if (args[2].equals("-h")) {
            Result result = divide(args[0], args[1]);
            Formatter formatter = new HtmlFormatter();
            String output = formatter.format(result);
            System.out.printf(output);

            File file = new File("index.html");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(output);
            writer.flush();
            writer.close();

        }

        if (args[2].equals("-j")) {
            Result result = divide(args[0], args[1]);
            Formatter formatter = new JsonFormatter();
            String output = formatter.format(result);
            System.out.printf(output);
        }
    }

    private static Result divide(String arg1, String arg2) {
        int dividend = Integer.parseInt(arg1);
        int divisor = Integer.parseInt(arg2);
        Divider divider = new Divider();
        return divider.divide(dividend, divisor);
    }

    private static void printWrongArgument() {
        System.out.println("Wrong argument\n" + "You should enter three arguments.\n"
                + "The first argument is integer dividend, the second is integer divisor, the third is key.\n"
                + "There are three kind of keys:\n" + "\t\"-c\" to display division in console\n"
                + "\t\"-h\" to generate html code and to display division on the web page\n"
                + "\t\"-j\" to generate the string in JSON format");
    }
}
