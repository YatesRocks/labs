package labs.yates.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * For Lab11. This class strips text, removing
 * all stop words, then extracts tags from it.
 * Before stripping, text is normalized by removing
 * all punctuation and splitting up by whitespace,
 * as well as converting to entirely lowercase.
 */
public class TextStripper {
    // we check against this
    private final HashSet<String> stopWords = new HashSet<>();
    // some caching would probably be smart
    private HashMap<String, Integer> cached = new HashMap<>();
    private int inputHash;

    /**
     * Normalizes an input String by removing punctuation,
     * and converting to all lowercase.
     *
     * @param input the string to normalize
     * @return the normalized output
     */
    public static String normalize(String input) {
        // NOTE: maybe memoize in future? (could be fun)
        String output = input.toLowerCase(Locale.US);
        output = output.replaceAll("\\p{Punct}", "");
        return output;
    }

    private TextStripper(Collection<String> stopWords) {
        // Populate the set
        this.stopWords.addAll(stopWords);
    }

    /**
     * @param stopWords whitespace-delimited, list of words to ignore
     */
    public TextStripper(String stopWords) {
        this(List.of(normalize(stopWords).split("\\s+")));
    }

    /**
     * @param stopFile The file to pull the stop words from.
     * @throws IOException If Files.readString() fails
     */
    public TextStripper(Path stopFile) throws IOException {
        this(normalize(Files.readString(stopFile)));
    }

    /**
     * Takes an input string, normalizes it, and
     * produces a HashMap with the words <strong>NOT</strong>
     * found in the stop-word list, also counting number
     * of occurrences
     *
     * @param input The string to produce a mapping over
     * @return A hashmap with word / occurrences, no stop words
     */
    public HashMap<String, Integer> mapping(String input) {
        HashMap<String, Integer> mapping = new HashMap<>();
        input = normalize(input);
        // we already calculated this
        if (input.hashCode() == inputHash)
            return cached;
        inputHash = input.hashCode();
        for (String word : input.split("\\s+")) {
            if (!stopWords.contains(word)) {
                mapping.merge(word, 1, Integer::sum);
            }
        }
        cached = mapping;
        return mapping;
    }
}
