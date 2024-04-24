package labs.yates.view.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * I found myself needing to display files of some kind
 * in every lab, so here ya go: ready-made file displayer.
 */
public class FileDisplayer extends JScrollPane {
    private final JTextPane contents = new JTextPane();

    public FileDisplayer() {
        contents.setEditable(false);
        contents.setFocusable(false);

        setViewportView(contents);

        setBorder(new LineBorder(Color.LIGHT_GRAY));
    }

    public void setContents(String newContents) {
        contents.setText(newContents);
    }

    public void highlight(String regex) {
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(new Color(212,255,50));

        Pattern pattern;

        try {
            pattern = Pattern.compile(regex);
        } catch (PatternSyntaxException e) {
            return;
        }

        Matcher matcher = pattern.matcher(contents.getText());

        while (matcher.find()) {
            try {
                contents.getHighlighter().addHighlight(matcher.start(), matcher.end(), painter);
            } catch (BadLocationException e) {
                // if Matcher gets an index out of bounds, it's a problem with Matcher, not me
                throw new RuntimeException(e);
            }
        }
    }

    public void clearHighlighting() {
        contents.getHighlighter().removeAllHighlights();
    }
}
