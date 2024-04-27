package labs.yates.view.panels;

import labs.yates.controller.PizzaOrderController;
import labs.yates.view.components.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;

public class PizzaOrderForm extends BasePanel {
    public ComboGroup sizeOption = sizeOption();
    public RadioGroup crustType = crustType();
    public CheckBoxPane toppings = toppings();
    public Receipt receipt = new Receipt();
    private JScrollPane receiptScrollPane = new JScrollPane(receipt);
    private final PizzaOrderController controller = new PizzaOrderController(this);

    public PizzaOrderForm() {
        ActionListener order = e -> controller.order();
        receiptScrollPane.setBorder(new TitledBorder("Receipt"));

        // ---- CRUST TYPE / SIZE
        JPanel top = new JPanel(new MigLayout());
        top.add(crustType, "push, grow");
        top.add(new JSeparator(JSeparator.VERTICAL), "growy");
        top.add(sizeOption);

        // ---- RECEIPT
        JPanel middle = new JPanel(new MigLayout());
        middle.add(receiptScrollPane, "push, grow");

        // ---- TOPPINGS / ORDER BUTTON
        JPanel btm = new JPanel(new MigLayout());
        btm.add(toppings, "push, w 75%");
        btm.add(button("Order!", order), "w 25%, growy");

        SandwichPanel sandwichPanel = new SandwichPanel(top, btm, middle);

        ActionListener clear = e -> {
            receipt = new Receipt();
            receiptScrollPane.setViewportView(receipt);
            crustType.clear();
            sizeOption.clear();
            toppings.clear();
            revalidate();
            repaint();
        };

        // ---- CLEAR / MENU / QUIT
        JButton clearButton = button("Clear Order", clear);
        add(buttonPane(clearButton), "dock south, grow");
        // ----

        add(sandwichPanel, "push, grow");
    }

    private ComboGroup sizeOption() {
        ComboGroup size = new ComboGroup("Size");
        size.addItem("Small ($8)");
        size.addItem("Medium ($12)");
        size.addItem("Large ($16)");
        size.addItem("Super ($20)");
        return size;
    }

    private RadioGroup crustType() {
        RadioGroup crustType = new RadioGroup("Crust Type");
        crustType.addButton("Thin");
        crustType.addButton("Regular");
        crustType.addButton("Deep Dish");
        return crustType;
    }

    private CheckBoxPane toppings() {
        CheckBoxPane checkBoxPane = new CheckBoxPane("Toppings");
        checkBoxPane.addCheckBox("Pepperoni");
        checkBoxPane.addCheckBox("Salsa");
        checkBoxPane.addCheckBox("Flowers", "wrap");
        checkBoxPane.addCheckBox("Paper");
        checkBoxPane.addCheckBox("Cheese");
        checkBoxPane.addCheckBox("Veggie");
        checkBoxPane.addNote("($1 Per)");
        return checkBoxPane;
    }
}
