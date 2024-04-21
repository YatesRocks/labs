package labs.yates.controller;

import labs.yates.model.Regexp;
import labs.yates.view.panels.TextFilterBox;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FileFilterController {
    private final TextFilterBox textFilterBox;
    private Regexp regexp;

    public FileFilterController(TextFilterBox textFilterBox) {
        this.textFilterBox = textFilterBox;
    }

    // Load the file as a stream
    public void loadFile(File file) {
        assert !file.isDirectory();
        assert file.canRead();

        try {
            String contents = Files.readString(file.toPath());
            textFilterBox.original.setContents(contents);
            regexp = new Regexp(contents);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void highlight(String regex) {
        if (regexp == null)
            return;

        StringBuilder builder = new StringBuilder();

        for (String line : this.regexp.matchingLines(regex))
            builder.append(line).append("\n");

        textFilterBox.filtered.setContents(builder.toString());
        textFilterBox.original.highlight(regex);
    }
}
