package lab5.Napisy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubtitleParser {


    public String[] parse(String in) throws NumberFormatException, NoMatchFoundExepction {

        Pattern goodSubtitleLine = Pattern.compile("\\{(\\d+)\\}\\{(\\d+)\\}(.+)");
        Matcher subtitleMatcher = goodSubtitleLine.matcher(in);

        if (subtitleMatcher.find())
        {
            String [] parsedSubtitle = new String[3];
            parsedSubtitle[0]=subtitleMatcher.group(1);
            parsedSubtitle[1]=subtitleMatcher.group(2);
            parsedSubtitle[2]=subtitleMatcher.group(3);
            return parsedSubtitle;
        }
        else
        {
            throw new NoMatchFoundExepction(in);
        }
    }
}
