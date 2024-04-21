package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionListener;

public class InputField extends JPanel {
    private final JTextField textField;
    private final JButton acceptButton;

    public InputField(String ghostText, String buttonText) {
        setLayout(new MigLayout());

        textField = new HintTextField(ghostText);
        acceptButton = new JButton(buttonText);

        add(textField, "push, grow");
        add(acceptButton, "wrap");
    }

    // TODO: make it so it returns null, not the ghost text on an empty field
    public String getText() {
        return textField.getText();
    }

    public void addActionListener(ActionListener actionListener) {
        acceptButton.addActionListener(actionListener);
    }
}
