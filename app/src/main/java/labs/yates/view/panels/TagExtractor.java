package labs.yates.view.panels;

import com.formdev.flatlaf.util.FontUtils;
import labs.yates.model.TextStripper;
import labs.yates.view.components.FileDisplayer;
import labs.yates.view.components.SerifFont;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TagExtractor extends BasePanel {
    private final JTextField pathField = pathField();
    private Path filePath = null;
    private Path stopWordsPath = null;
    private TextStripper textStripper = null;
    private final FileDisplayer fileDisplayer = new FileDisplayer();

    public TagExtractor() {
        super("Load stop words");
        // TODO: Do stuff on load stop words click
        setAction(e -> {
            stopWordsPath = getFile(JFileChooser.FILES_ONLY).toPath();
            textStripper = new TextStripper(stopWordsPath);
        });

        // The file dock is for opening a new text file
        add(fileDock(), "dock north, push, grow");
        // Displays the file
        add(fileDisplayer, "gap 5 5 5 5, push, grow");
        add(buttonPane(), "dock south, push, grow");
    }

    private JTextField pathField() {
        JTextField path = new JTextField();
        path.setEditable(false);
        path.setFocusable(false);
        path.setBorder(new TitledBorder("Path"));
        path.setFont(new SerifFont(14));
        return path;
    }

    private JPanel fileDock() {
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout());
        // The field showing the path to the current file
        panel.add(pathField, "push, grow");
        panel.add(button("Open", this::openFile), "growy");
        panel.add(button("Save", this::save), "growy");
        return panel;
    }

    private void save(ActionEvent e) {

    }

    private void openFile(ActionEvent e) {
        File file = getFile(JFileChooser.FILES_ONLY);
        filePath = file.toPath();
        // Space is so it's not too close to the edge
        pathField.setText(" " + filePath);
        try {
            fileDisplayer.setContents(Files.readString(filePath));
        } catch (IOException ex) {
            // TODO: Make more robust
            throw new RuntimeException(ex);
        }
    }
}
