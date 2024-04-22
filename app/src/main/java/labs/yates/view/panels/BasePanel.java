package labs.yates.view.panels;

import labs.yates.controller.CardController;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public abstract class BasePanel extends JPanel {
    @Deprecated
    private JButton actionButton;

    @Deprecated
    protected BasePanel(String actionCommand) {
        setLayout(new MigLayout());
        actionButton = new JButton(actionCommand);
    }

    protected BasePanel() {}

    /**
     * Creates a pane filled with buttons needed across every lab.
     * Stuff like close, menu, and an action button. The action
     * button must be configured through other methods.
     * <hr>
     * Deprecated in favor of the new API.
     * This is marked for removal.
     *
     * @return A JPanel with generic buttons
     */
    @Deprecated
    protected JPanel buttonPane() {
        return buttonPane(actionButton);
    }

    protected JPanel buttonPane(JButton actionButton) {
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

    /**
     * Set the callback for the Action button in the bottom Button Pane.
     * Deprecated, please use the new constructor taking in a JButton instead.
     *
     * @param actionListener The callback for when Action is pressed.
     */
    @Deprecated
    protected void setAction(ActionListener actionListener) {
        actionButton.addActionListener(actionListener);
    }

    /**
     * A convenience function for the action of "I need a file".
     * Returns null if the user escapes out of the dialog
     *
     * @param selectionMode Directories or files?
     * @return a File, or null
     */
    protected File getFile(int selectionMode) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(selectionMode);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    /**
     * A convenience method for creating a button and adding
     * an action listener.
     *
     * @param label The label for the button
     * @param actionListener The action listener to apply
     * @return The customized button
     */
    protected static JButton button(String label, ActionListener actionListener) {
        JButton open = new JButton(label);
        open.addActionListener(actionListener);
        return open;
    }
}
