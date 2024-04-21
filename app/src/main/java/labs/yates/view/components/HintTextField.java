package labs.yates.view.components;

// Adapted and modified from an online tutorial.
// Credit: http://javaswingcomponents.blogspot.com/2012/05/how-to-create-simple-hinttextfield-in.html

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;

/**
 * HintTextField provides a utility class for input
 * boxes that adds a "Ghost text" for the user to
 * better understand what the field is for.
 */
public class HintTextField extends JTextField {
    protected Font gainFont = new Font("Sans-serif", Font.PLAIN, 12);
    protected Font lostFont = new Font("Serif", Font.ITALIC, 12);

    /**
     * Equivalent to a JTextField in functionality, just with
     * extra ghost text.
     *
     * @param hint the ghost text to display in the field
     */
    public HintTextField(final String hint) {
        setText(hint);
        setFont(lostFont);
        setForeground(Color.GRAY);

        this.addFocusListener(new FocusAdapter() {

            // If a user clicks into the field, make the text
            // disappear
            @Override
            public void focusGained(FocusEvent e) {
                setForeground(Color.BLACK);
                if (getText().equals(hint)) {
                    setText("");
                    setFont(gainFont);
                } else {
                    setText(getText());
                    setFont(gainFont);
                }
            }

            // If a user clicks out of the field,
            // and the field is unchanged, display
            // the ghost text again.
            @Override
            public void focusLost(FocusEvent e) {
                if (getText().equals(hint) || getText().isEmpty()) {
                    setText(hint);
                    setFont(lostFont);
                    setForeground(Color.GRAY);
                } else {
                    setText(getText());
                    setFont(gainFont);
                }
            }
        });
    }
}