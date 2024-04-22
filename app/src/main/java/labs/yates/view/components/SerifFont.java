package labs.yates.view.components;

import java.awt.*;

// NOTE: This may not need to be in its own class

/**
 * Ease-of-use component for creating serif fonts.
 */
public class SerifFont extends Font {
    public SerifFont(int size) {
        super("Serif", Font.PLAIN, size);
    }
}
