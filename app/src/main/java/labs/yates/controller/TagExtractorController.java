package labs.yates.controller;

import labs.yates.model.Tag;
import labs.yates.model.TagModel;
import labs.yates.model.TextStripper;
import labs.yates.view.panels.TagExtractor;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.TreeMap;

// TODO: Class documentation
public class TagExtractorController {
    private final TagExtractor tagExtractor;
    private TextStripper textStripper = null;
    private final TagModel tagModel = new TagModel();

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
            return;
        }

        tagExtractor.tagTable.initSorter(tagModel);
        occ.forEach(this::doEmplaceTag);
        tagModel.fireTableDataChanged();
        tagExtractor.labeledActionRow.setLabel(file.getAbsolutePath());
    }

    private void doEmplaceTag(String k, Integer v) {
        System.out.println(k + ":" + v);
        if (v < 4 || v > 200)
            return;
        tagModel.emplaceTag(new Tag<>(k, v));
    }

    public void save() {
        // There's nothing to save.
        if (tagModel.getRowCount() == 0)
            return;

        File file = tagExtractor.saveFile();

        if (file == null)
            return;

        try (FileWriter writer = new FileWriter(file)) {
            for (Tag<String, Integer> tag : tagModel.getTags()) {
                writer.append(tag.key())
                        .append(":")
                        .append(tag.value().toString())
                        .append('\n');
            }
        } catch (IOException e) {
            tagExtractor.warnFile();
        }
    }

    public void loadSW() {
        try {
            File file = tagExtractor.getFile(JFileChooser.FILES_ONLY);
            textStripper = new TextStripper(file.toPath());
        } catch (IOException e) {
            tagExtractor.warnFile();
        }
    }
}
