package labs.yates;

import labs.yates.view.Window;
import labs.yates.view.panels.FileLister;
import labs.yates.controller.CardController;

import javax.swing.SwingUtilities;
import com.formdev.flatlaf.FlatLightLaf;
import labs.yates.view.panels.LabMenu;
import labs.yates.view.panels.TextFilterBox;

public class App {
    private static void run() {
        FlatLightLaf.setup();
        // Configures the window & launches
        new Window(600, 600);
        // Here we register all the Lab panes w/the global CardLayout / JPanel
        CardController.registerComponent("Menu", new LabMenu());
        CardController.registerComponent("Lab11", new FileLister());
        CardController.registerComponent("Lab9", new TextFilterBox());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::run);
    }
}
