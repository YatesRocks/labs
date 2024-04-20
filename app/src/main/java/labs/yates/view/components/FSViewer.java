package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class FSViewer extends JTextArea {
    private final StringBuilder contents = new StringBuilder();

    public void inject(String path) {
        contents.append(path)
                .append("\n");
    }

    public void finish() {
        setText(contents.toString());
    }
}
