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

public class FileLister extends BasePanel {
    private final FileListerController cont = new FileListerController(this);
    // Components
    private JLabel notice = new JLabel("Press start to pick a directory to recurse");
    private final JScrollPane pane = new JScrollPane();

    public FileLister() {
        setLayout(new MigLayout());
        add(new JLabel("Lab 11: File Lister"), "align center, center, wrap");
        add(notice, "push, align center, center, wrap");
        ActionListener start = e -> cont.recurse(getFile(JFileChooser.DIRECTORIES_ONLY).toPath());
        add(buttonPane(button("Pick a directory", start)), "dock south, align center, center");
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
