package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.Vector;

public class RadioGroup extends JPanel {
    private final Vector<JRadioButton> buttonVector = new Vector<>();
    private final ButtonGroup buttonGroup = new ButtonGroup();

    public RadioGroup(String title) {
        setLayout(new MigLayout());
        setBorder(BorderFactory.createTitledBorder(title));
    }

    public void addButton(String label) {
        JRadioButton button = new JRadioButton(label);
        buttonVector.add(button);
        buttonGroup.add(button);
        add(button);
    }

    public void clear() {
        buttonGroup.clearSelection();
    }

    public String getSelected() {
        for (JRadioButton button : buttonVector) {
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
