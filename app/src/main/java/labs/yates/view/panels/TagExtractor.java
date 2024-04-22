package labs.yates.view.panels;

import labs.yates.controller.TagExtractorController;
import labs.yates.view.components.FileDisplayer;
import labs.yates.view.components.LabeledActionRow;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TagExtractor extends BasePanel {
    private final TagExtractorController controller = new TagExtractorController(this);
    // Displays the tagged output.
    public FileDisplayer tagFile = new FileDisplayer();

    public TagExtractor() {
        ActionListener loadText = e -> controller.load(getFile(JFileChooser.FILES_ONLY));
        ActionListener loadStopWords = e -> controller.loadSW(getFile(JFileChooser.FILES_ONLY));
        ActionListener save = e -> controller.save();
        LabeledActionRow labeledActionRow = new LabeledActionRow("Path");
        labeledActionRow.addButton(button("Load File", loadText));
        labeledActionRow.addButton(button("Save File", save));
        add(labeledActionRow, "dock north, push, grow");
        add(tagFile, "push, grow, pad 0 5 -5 -5");
        add(buttonPane(button("Load stop words", loadStopWords)), "dock south, push, grow");
    }
}
