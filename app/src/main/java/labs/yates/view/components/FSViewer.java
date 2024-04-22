package labs.yates.view.components;

import javax.swing.*;

// TODO: Document & expand or mark deprecated & rewrite. Either or.
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
