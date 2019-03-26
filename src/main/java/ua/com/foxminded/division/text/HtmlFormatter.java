package ua.com.foxminded.division.text;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.Result;

public class HtmlFormatter implements Formatter {
    private Result result;

    public String format(Result result) {
        String output = "";
        output += "<html>\n<title>Division</title>\n<body>\n<pre>\n";
        
        Formatter formatter = new ClassicFormatter();
        output += formatter.format(result);
        
        output += "\n</pre>\n</body>\n</html>";
        
        return output;
    }

}