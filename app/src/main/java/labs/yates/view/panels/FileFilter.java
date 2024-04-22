package labs.yates.view.panels;

import labs.yates.controller.FileFilterController;
import labs.yates.view.components.FileDisplayer;
import labs.yates.view.components.InputField;

import javax.swing.*;
import java.io.File;

public class FileFilter extends BasePanel {
    private final FileFilterController controller;
    // TODO: should *probably* be private but oh well
    public final FileDisplayer original = new FileDisplayer();
    public final FileDisplayer filtered = new FileDisplayer();

    public FileFilter() {
        super("Load a file");

        controller = new FileFilterController(this);

        InputField inputField = new InputField("Type a regular expression", "Search");
        inputField.addActionListener(e -> controller.highlight(inputField.getText()));

        add(inputField, "dock north");

        add(original, "pad 0 5 -5 -5, push, grow");
        add(filtered, "pad 0 5 -5 -5, push, grow, wrap");
        add(buttonPane(), "dock south");

        setAction(e -> {
            File file = getFile(JFileChooser.FILES_ONLY);
            if (file != null)
                controller.loadFile(file);
        });
    }
}
