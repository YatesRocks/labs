package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class CheckBoxPane extends JPanel {
    private final Vector<JCheckBox> checkBoxes = new Vector<>();

    public CheckBoxPane(String title) {
        setLayout(new MigLayout());
        setBorder(BorderFactory.createTitledBorder(title));
    }

    public void clear() {
        for (JCheckBox checkBox : checkBoxes) {
            checkBox.setSelected(false);
        }
    }

    public void addCheckBox(String label) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBoxes.add(checkBox);
        add(checkBox);
    }

    public void addCheckBox(String label, String constraints) {
        JCheckBox checkBox = new JCheckBox(label);
        checkBoxes.add(checkBox);
        add(checkBox, constraints);
    }

    public void addNote(String note) {
        add(new JLabel(note));
    }

    public Vector<String> getSelected() {
        Vector<String> selected = new Vector<>();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selected.add(checkBox.getText());
            }
        }
        return selected;
    }
}
