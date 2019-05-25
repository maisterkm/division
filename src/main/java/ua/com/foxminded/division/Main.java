package ua.com.foxminded.division;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;
import ua.com.foxminded.division.text.Formatter;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            printWrongArgument();
            System.exit(1);
        }

        Divider divider = new Divider();
        Result result = divider.divide(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        Factory factory = new Factory();
        Formatter formatter = factory.getFormatter(args[2]);
        String output = formatter.format(result);
        System.out.printf(output);

        if (args[2].equals("-h")) {
            File file = new File("index.html");
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(output);
            writer.flush();
            writer.close();
        }
    }

    private static void printWrongArgument() {
        System.out.println("Wrong argument\n" + "You should enter three arguments.\n"
                + "The first argument is integer dividend, the second is integer divisor, the third is key.\n"
                + "There are three kind of keys:\n" + "\t\"-c\" to display division in console\n"
                + "\t\"-h\" to generate html code and to display division on the web page\n"
                + "\t\"-j\" to generate the string in JSON format");
    }
}
