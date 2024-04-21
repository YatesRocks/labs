package labs.yates.view.panels;

import labs.yates.controller.FileFilterController;
import labs.yates.view.components.FileDisplayer;
import labs.yates.view.components.InputField;

import java.io.File;

public class TextFilterBox extends BasePanel {
    private final FileFilterController controller;
    // TODO: should *probably* be private but idrc
    public FileDisplayer original = new FileDisplayer();
    public FileDisplayer filtered = new FileDisplayer();

    public TextFilterBox() {
        super("Load a file");

        controller = new FileFilterController(this);

        InputField inputField = new InputField("Type a regular expression", "Search");
        inputField.addActionListener(e -> controller.highlight(inputField.getText()));

        add(inputField, "dock north");

        add(original, "pad 0 5 -5 -5, push, grow");
        add(filtered, "pad 0 5 -5 -5, push, grow, wrap");
        add(buttonPane(), "dock south");

        setAction(e -> {
            File file = getFile();
            if (file != null)
                controller.loadFile(file);
        });
    }
}
