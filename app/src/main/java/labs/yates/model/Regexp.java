package labs.yates.model;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Regexp {
    private final String input;

    public Regexp(String input) {
        this.input = input;
    }

    public ArrayList<String> matchingLines(String regexp) {
        ArrayList<String> matches = new ArrayList<>();

        Pattern pattern;
        try {
            pattern = Pattern.compile(regexp);
        } catch (PatternSyntaxException e) {
            return null;
        }

        for (String line : input.split("\n")) {
            if (pattern.matcher(line).find()) {
                matches.add(line);
                System.out.println(line);
            }
        }
        return matches;
    }
}
