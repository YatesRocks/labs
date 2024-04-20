package labs.yates.view.panel;

import labs.yates.controller.CardController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LabMenu extends JPanel {
    public LabMenu() {
        setLayout(new MigLayout(""));
        JPanel container = new JPanel();
        button("Lab 11: FileLister", container, "Lab11");
        add(container, "push, align center, center");
    }

    private void button(String label, Container container, String componentName) {
        JButton button = new JButton(label);
        button.addActionListener(e -> {
            CardController.showComponent(componentName);
        });
        container.add(button, "wrap");
    }
}
