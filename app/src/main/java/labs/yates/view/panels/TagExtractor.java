package labs.yates.view.panels;

import labs.yates.controller.TagExtractorController;
import labs.yates.view.components.FileDisplayer;
import labs.yates.view.components.LabeledActionRow;
import labs.yates.view.components.TagTable;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TagExtractor extends BasePanel {
    private final TagExtractorController controller = new TagExtractorController(this);
    // Used by the controller
    public TagTable tagTable = new TagTable();
    public LabeledActionRow labeledActionRow;

    public TagExtractor() {
        // TODO: Inline these?
        ActionListener loadText = e -> controller.load();
        ActionListener loadStopWords = e -> controller.loadSW();
        ActionListener save = e -> controller.save();
        labeledActionRow = new LabeledActionRow("Path");
        labeledActionRow.addButton(button("Load File", loadText));
        labeledActionRow.addButton(button("Save File", save));
        add(labeledActionRow, "dock north, push, grow");
        add(new JScrollPane(tagTable), "push, grow, pad 0 5 -5 -5");
        add(buttonPane(button("Load stop words", loadStopWords)), "dock south, push, grow");
    }

    public void warnSW() {
        JOptionPane.showMessageDialog(this, "Whoops! You need to load stop words first.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
