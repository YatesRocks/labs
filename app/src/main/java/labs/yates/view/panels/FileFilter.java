package labs.yates.view.panels;

import labs.yates.controller.FileFilterController;
import labs.yates.view.components.FileDisplayer;
import labs.yates.view.components.InputField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class FileFilter extends BasePanel {
    private final FileFilterController controller;
    public final FileDisplayer original = new FileDisplayer();
    public final FileDisplayer filtered = new FileDisplayer();

    public FileFilter() {
        controller = new FileFilterController(this);

        InputField field = new InputField("Type a regular expression");
        field.addButton(button("Search", e -> controller.highlight(field.getText())));

        add(field, "dock north");

        add(original, "pad 0 5 -5 -5, push, grow");
        add(filtered, "pad 0 5 -5 -5, push, grow, wrap");
        add(buttonPane(button("Load file", this::loadFile)), "dock south");
    }

    private void loadFile(ActionEvent e) {
        File file = getFile(JFileChooser.FILES_ONLY);
        if (file != null)
            controller.loadFile(file);
    }
}
