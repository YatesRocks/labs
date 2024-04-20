package labs.yates.view;

import labs.yates.controller.*;

import javax.swing.*;

public class Window extends JFrame {
    private final WindowController cont = new WindowController();
    
    public Window(int width, int height) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(width, height);
        setTitle("Labs");

        CardController.registerView(this);

        setVisible(true);
    }
}
