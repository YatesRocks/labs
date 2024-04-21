package labs.yates.view.panels;

import labs.yates.controller.CardController;
import labs.yates.controller.FileListerController;
import labs.yates.view.components.FSViewer;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;

public class FileLister extends JPanel {
    private final FileListerController cont = new FileListerController(this);
    // Components
    private JLabel notice = new JLabel("Press start to pick a directory to recurse");
    private final JScrollPane pane = new JScrollPane();

    public FileLister() {
        setLayout(new MigLayout());
        add(new JLabel("Lab 11: File Lister"), "align center, center, wrap");
        add(notice, "push, align center, center, wrap");
        JPanel container = new JPanel();
        container.add(button("Start", this::start));
        container.add(button("Menu",  e -> CardController.showComponent("Menu")));
        container.add(button("Quit", e -> System.exit(0)));
        add(container, "align center, center");
    }

    public JButton button(String text, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        return button;
    }

    private void start(ActionEvent actionEvent) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            Path path = chooser.getSelectedFile().toPath();
            cont.recurse(path);
        }
    }

    public void setFSViewer(FSViewer fsViewer) {
        fsViewer.setEditable(false);
        if (notice != null) {
            remove(notice);
            notice = null;
            pane.setBorder(new TitledBorder("File Lister Output"));
            add(pane, "push, grow, wrap", 1);
        }
        pane.setViewportView(fsViewer);
        revalidate();
    }
}
