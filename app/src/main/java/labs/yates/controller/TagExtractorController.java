package labs.yates.controller;

import labs.yates.model.TextStripper;
import labs.yates.view.panels.TagExtractor;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.TreeMap;

// TODO: Class documentation
public class TagExtractorController {
    private final TagExtractor tagExtractor;
    private TextStripper textStripper = null;

    public TagExtractorController(TagExtractor tagExtractor) {
        this.tagExtractor = tagExtractor;
    }

    public void load() {
        if (textStripper == null) {
            tagExtractor.warnSW();
            return;
        }

        File file = tagExtractor.getFile(JFileChooser.FILES_ONLY);

        TreeMap<String, Integer> occ;

        try {
             occ = textStripper.mapping(Files.readString(file.toPath()));
        } catch (IOException e) {
            tagExtractor.warnFile();
            e.printStackTrace();
            return;
        }
    }

    public void save() {

    }

    public void loadSW() {
        try {
            File file = tagExtractor.getFile(JFileChooser.FILES_ONLY);
            textStripper = new TextStripper(file.toPath());
        } catch (IOException e) {
            // TODO: more robust yada yada
            e.printStackTrace();
        }
    }
}
