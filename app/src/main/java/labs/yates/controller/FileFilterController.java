package labs.yates.controller;

import labs.yates.model.Regexp;
import labs.yates.view.panels.FileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileFilterController {
    private final FileFilter fileFilter;
    private Regexp regexp;

    public FileFilterController(FileFilter textFilterBox) {
        this.fileFilter = textFilterBox;
    }

    /**
     * Loads the file into the left display,
     * or if there is an error does nothing,
     * only reporting the error.
     *
     * @param file the file to load
     */
    public void loadFile(File file) {
        try {
            String contents = Files.readString(file.toPath());
            fileFilter.original.setContents(contents);
            regexp = new Regexp(contents);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Highlights the left side, and puts
     * all matching lines on the right side.
     *
     * @param regex the regular expression to use
     */
    public void highlight(String regex) {
        // they haven't loaded a file yet,
        // do nothing.
        if (regexp == null)
            return;

        StringBuilder builder = new StringBuilder();

        for (String line : this.regexp.matchingLines(regex))
            builder.append(line).append("\n");

        fileFilter.filtered.setContents(builder.toString());
        fileFilter.original.highlight(regex);
    }
}
