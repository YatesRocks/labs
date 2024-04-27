package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class ComboGroup extends JPanel {
    private final JComboBox<String> comboBox = new JComboBox<>();

    public ComboGroup(String title) {
        setLayout(new MigLayout());
        setBorder(BorderFactory.createTitledBorder(title));
        add(comboBox);
    }

    public void clear() {
        comboBox.setSelectedIndex(0);
    }

    public void addItem(String label) {
        comboBox.addItem(label);
    }

    public String getSelectedLabel() {
        return (String) comboBox.getSelectedItem();
    }
}
