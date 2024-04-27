package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Two components docked north and south, with
 * a component in the middle.
 */
public class SandwichPanel extends JPanel {
    public SandwichPanel(Component north, Component south, Component middle) {
        setLayout(new MigLayout());
        add(north, "dock north");
        add(middle, "dock center, push, grow");
        add(south, "dock south");
    }

    public void setMiddle(Component middle) {
        remove(1);
        add(middle, "dock center, push, grow", 1);
    }
}
