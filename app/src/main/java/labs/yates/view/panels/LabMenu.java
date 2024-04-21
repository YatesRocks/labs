package labs.yates.view.panels;

import labs.yates.controller.CardController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class LabMenu extends JPanel {
    public LabMenu() {
        setLayout(new MigLayout(""));
        JPanel container = new JPanel(new MigLayout());
        button("Lab 11: FileLister", container, "Lab11");
        button("Lab 09: Data Streams", container, "Lab9");
        add(container, "push, align center, center");
    }

    private void button(String label, Container container, String componentName) {
        JButton button = new JButton(label);
        button.addActionListener(e -> {
            CardController.showComponent(componentName);
        });
        container.add(button, "wrap, growx");
    }
}
