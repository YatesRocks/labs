package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ItemDisplay extends JPanel {
    private final JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
    private final Vector<JPanel> history = new Vector<>();
    private JPanel panel = new JPanel(new MigLayout());

    public ItemDisplay() {
        setLayout(new MigLayout());
        separator.setForeground(Color.BLACK);
        separator.setBackground(Color.BLACK);
    }

    public void seperate() {
        history.add(panel);
        panel = new JPanel(new MigLayout());
        add(separator, "w 100%, pushx, growx, wrap");
    }

    public void seperate(String title) {
        history.add(panel);
        panel = new JPanel(new MigLayout());
        add(new JLabel(title), "align center, wrap");
        add(separator, "w 100%, pushx, growx, wrap");
    }

    public JLabel addItem(String label) {
        JLabel labelComponent = new JLabel(label);
        labelComponent.setFont(new Font("Sans-serif", Font.BOLD, 14));
        JLabel valueComponent = new JLabel("-");

        JPanel row = new JPanel(new MigLayout());

        row.add(labelComponent, "align left");
        row.add(valueComponent, "pushx, align right");

        panel.add(row, "pushx, growx, wrap");

        return valueComponent;
    }

    public void finish() {
        add(panel, "growx, wrap");
    }

    public void addLI(String name) {
        JLabel labelComponent = new JLabel("- ");
        labelComponent.setFont(new Font("Sans-serif", Font.BOLD, 14));
        JLabel valueComponent = new JLabel(name);
        JPanel row = new JPanel(new MigLayout());
        row.add(labelComponent, "align left");
        row.add(valueComponent, "pushx, align right");
        panel.add(row, "pushx, growx, wrap");
    }

    public void clear() {
        history.clear();
        panel = new JPanel(new MigLayout());
    }
}
