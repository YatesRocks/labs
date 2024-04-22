package labs.yates.view.panels;

import labs.yates.model.TextStripper;
import labs.yates.view.components.FileDisplayer;
import labs.yates.view.components.SerifFont;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TagExtractor extends BasePanel {
    private final JTextField pathField = pathField();
    private Path filePath = null;
    private final Path stopWordsPath = null;
    private final TextStripper textStripper = null;
    private final FileDisplayer fileDisplayer = new FileDisplayer();

    public TagExtractor() {
        // The file dock is for opening a new text file
        add(fileDock(), "dock north, push, grow");
        // Displays the file
        add(fileDisplayer, "gap 5 5 5 5, push, grow");
        JButton loadStopWords = button("Load stop words", this::loadStopWords);
        add(buttonPane(loadStopWords), "dock south, push, grow");
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

    private void loadStopWords(ActionEvent e) {
        // TODO
    }

    private void save(ActionEvent e) {
        // TODO
    }

    private void openFile(ActionEvent e) {
        filePath = getFile(JFileChooser.FILES_ONLY).toPath();
        // Space is so it's not too close to the edge
        pathField.setText(" " + filePath);
        try {
            String contents = Files.readString(filePath);
            if (textStripper == null)
                JOptionPane.showMessageDialog(null, "No stop word list available", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Hoorah!");
        } catch (IOException ex) {
            // TODO: Make more robust
            throw new RuntimeException(ex);
        }
    }
}
