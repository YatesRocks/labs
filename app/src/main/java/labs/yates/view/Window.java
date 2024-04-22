package labs.yates.view;

import labs.yates.controller.CardController;

import javax.swing.*;

public class Window extends JFrame {
    public Window(int width, int height) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(width, height);
        setTitle("Labs");

        // note: take a look at registerView(),
        // the implementation is very simple.
        CardController.registerView(this);

        setVisible(true);
    }
}
