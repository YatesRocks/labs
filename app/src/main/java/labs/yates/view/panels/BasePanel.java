package labs.yates.view.panels;

import labs.yates.controller.CardController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public abstract class BasePanel extends JPanel {
    private final JButton actionButton = new JButton();

    protected BasePanel(String actionCommand) {
        setLayout(new MigLayout());
        actionButton.setText(actionCommand);
    }

    protected JPanel buttonPane() {
        JPanel contentPane = new JPanel(new MigLayout());
        contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));

        JButton menuButton = new JButton("Menu");
        menuButton.addActionListener(e -> CardController.showComponent("Menu"));

        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(e -> System.exit(0));

        contentPane.add(actionButton, "push, grow");
        contentPane.add(menuButton, "push, grow");
        contentPane.add(quitButton, "push, grow");

        return contentPane;
    }

    protected void setAction(ActionListener actionListener) {
        actionButton.addActionListener(actionListener);
    }

    protected File getFile() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }
}
