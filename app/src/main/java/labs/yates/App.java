package labs.yates;

import labs.yates.view.Window;
import labs.yates.view.panel.FileLister;
import labs.yates.controller.CardController;

import javax.swing.SwingUtilities;
import com.formdev.flatlaf.FlatLightLaf;
import labs.yates.view.panel.LabMenu;

public class App {
    private static void run() {
        FlatLightLaf.setup();
        // Configures the window & launches
        Window _win = new Window(600, 600);
        CardController.registerComponent("Menu", new LabMenu());
        CardController.registerComponent("Lab11", new FileLister());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::run);
    }
}
