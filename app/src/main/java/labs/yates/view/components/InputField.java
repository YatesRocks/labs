package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionListener;

// TODO: Document class
public class InputField extends JPanel {
    private final JTextField textField;
    private JButton acceptButton;

    // TODO: Switch to new API
    @Deprecated
    public InputField(String ghostText, String buttonText) {
        setLayout(new MigLayout());

        textField = new HintTextField(ghostText);
        acceptButton = new JButton(buttonText);

        add(textField, "push, grow");
        add(acceptButton, "wrap");
    }

    public InputField(String ghostText) {
        setLayout(new MigLayout());

        textField = new HintTextField(ghostText);
        add(textField, "push, grow");
    }

    public void addButton(JButton button) {
        // Shouldn't need "wrap" here because this is docked downstream
        add(button);
    }

    // TODO: make it so it returns null, not the ghost text on an empty field
    public String getText() {
        return textField.getText();
    }

    @Deprecated
    public void addActionListener(ActionListener actionListener) {
        acceptButton.addActionListener(actionListener);
    }
}
