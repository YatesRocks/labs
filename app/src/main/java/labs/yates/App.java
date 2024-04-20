package labs.yates;

import labs.yates.view.Window;
import labs.yates.view.panel.FileLister;
import labs.yates.controller.CardController;

import javax.swing.SwingUtilities;
import com.formdev.flatlaf.FlatLightLaf;

public class App {
    private static void run() {
        FlatLightLaf.setup();
        // Configures the window & launches
        Window _win = new Window(600, 600);
        CardController.registerComponent("FileLister", new FileLister());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::run);
    }
}
