package labs.yates.controller;

import javax.management.openmbean.KeyAlreadyExistsException;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;

/**
 * A utility class for quickly setting up
 * and prototyping a basic application, it
 * enables quick use of different "panes", or
 * "views" into the application (usually a
 * JPanel) that take the full screen. Follows
 * the singleton design pattern.
 */
public class CardController {
    // Stores the names of the Panels currently managed by
    // our CardLayout.
    private static final Vector<String> components = new Vector<>();
    // This is the driver - we register this with the JFrame
    // and maintain the list of panels in it.
    private static CardLayout layout = null;
    // We add this to a JFrame to act as the
    // container for our layouts.
    private static JPanel rootPanel = null;
    // Where we are currently in the Vector
    private static int cursor = 0;

    /**
     * Cycles to the next card. Wraps from back to front.
     * Most similar to a carousel.
     */
    public static void nextComponent() {
        if (rootPanel == null || layout == null)
            throw new IllegalStateException("Can't call nextComponent without a view being defined");
        cursor = (cursor + 1) % components.size();
        layout.show(rootPanel, components.elementAt(cursor));
    }

    /**
     * Fills the view with the specified component.
     *
     * @param label What the component is called
     */
    public static void showComponent(String label) {
        cursor = components.indexOf(label);
        layout.show(rootPanel, label);
    }

    /**
     * Registers a component with the controller's database.
     *
     * @param label What you would like to call the component
     * @param component The component to add to the database
     */
    public static void registerComponent(String label, JComponent component) {
        if (components.contains(label))
            throw new KeyAlreadyExistsException("Key already exists in component database: " + label);
        if (rootPanel == null)
            throw new IllegalStateException("Attempted to register component without a root view");
        components.add(label);
        rootPanel.add(label, component);
    }

    /**
     * This takes your JFrame and registers it with
     * the CardController, and registers the CardController
     * with it respectively. We add a JPanel to your frame,
     * this will contain the panel displaying your cards.
     * <p><i>
     * Registering multiple views is not supported at this
     * time.
     * </i></p>
     *
     * @param frame The JFrame to register with.
     */
    public static void registerView(JFrame frame) {
        // TODO: I think multiple views is possible - can add if need be
        if (layout != null || rootPanel != null)
            throw new UnsupportedOperationException("CardController does not support multiple views");
        frame.setLayout(layout = new CardLayout());
        rootPanel = new JPanel(layout);
        frame.add(rootPanel);
    }
}
