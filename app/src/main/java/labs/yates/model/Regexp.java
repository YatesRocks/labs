package labs.yates.model;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Regexp is a utility class for anything to do
 * with regular expressions.
 */
public class Regexp {
    private final String input;

    /**
     * @param input Input to apply filters to
     */
    public Regexp(String input) {
        this.input = input;
    }

    /**
     * Given the input supplied, finds all matching lines based
     * on a given regex.
     *
     * @param regexp The regular expression to apply
     * @return Null if invalid regular expression, all line matches otherwise
     */
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
