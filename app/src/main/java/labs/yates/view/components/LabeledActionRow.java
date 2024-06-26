package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;

// TODO: Document
/**
 * Terrible name, but this is just a named JLabel
 * with <i>n</i> buttons next to it.
 */
public class LabeledActionRow extends JPanel {
    private final JTextField label = new JTextField();
    private final JPanel buttonPanel = new JPanel();

    public LabeledActionRow(String labelTitle) {
        setLayout(new MigLayout(""));
        label.setEditable(false);
        TitledBorder serifBorder = new TitledBorder(labelTitle);
        serifBorder.setTitleJustification(TitledBorder.CENTER);
        serifBorder.setTitlePosition(TitledBorder.TOP);
        serifBorder.setTitleFont(new SerifFont(12));
        label.setBorder(serifBorder);
        label.setFocusable(false);
        add(label, "push, growx");
        add(buttonPanel, "align center, center");
    }

    public void addButton(JButton button) {
        buttonPanel.add(button, "growy");
    }

    public void setLabel(String label) {
        this.label.setText(label);
    }
}
