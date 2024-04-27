package labs.yates.view.components;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.DecimalFormat;

public class Receipt extends JPanel {
    private ItemDisplay display;
    private JLabel crustType;
    private JLabel pizzaSize;

    public Receipt() {
        setLayout(new MigLayout());
        setBorder(new LineBorder(Color.LIGHT_GRAY));

        display = new ItemDisplay();
        crustType = display.addItem("Crust Type:");
        pizzaSize = display.addItem("Pizza Size:");

        display.finish();
        display.seperate("Toppings");

        add(display, "w 40%, pushx, align center");
    }

    public void addTopping(String topping) {
        display.addLI(topping);
    }

    public void finish() {
        display.finish();
    }

    public void setCrust(String crustType) {
        this.crustType.setText(crustType);
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize.setText(pizzaSize);
    }

    public void addCost(int base, int toppings) {
        double subtotal = base + toppings;
        double tax = subtotal * 0.07;
        double total = subtotal + tax;

        DecimalFormat df = new DecimalFormat("#.##");

        display.seperate();
        display.addItem("Base Cost:").setText("$" + df.format(base));
        display.addItem("Toppings:").setText("$" + df.format(toppings));
        display.addItem("Subtotal:").setText("$" + df.format(subtotal));
        display.addItem("Tax:").setText("$" + df.format(tax));
        display.addItem("Total:").setText("$" + df.format(total));
        display.finish();
    }
}
