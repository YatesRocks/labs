package labs.yates.controller;

import labs.yates.view.panels.PizzaOrderForm;

import java.util.Vector;

public class PizzaOrderController {
    private PizzaOrderForm pizzaOrderForm;

    public PizzaOrderController(PizzaOrderForm pizzaOrderForm) {
        this.pizzaOrderForm = pizzaOrderForm;
    }

    private int getSizeCost(String size) {
        return switch (size) {
            case "Small ($8)" -> 8;
            case "Medium ($12)" -> 12;
            case "Large ($16)" -> 16;
            case "Super ($20)" -> 20;
            default -> 0;
        };
    }

    public void order() {
        // -- crust
        String crustType = pizzaOrderForm.crustType.getSelected();
        if (crustType == null) return;
        pizzaOrderForm.receipt.setCrust(crustType);
        // -- size
        String sizeOption = pizzaOrderForm.sizeOption.getSelectedLabel();
        pizzaOrderForm.receipt.setPizzaSize(sizeOption);
        int baseCost = getSizeCost(sizeOption);
        int toppings = 0;
        Vector<String> st = pizzaOrderForm.toppings.getSelected();
        for (String topping : st) {
            pizzaOrderForm.receipt.addTopping(topping);
            toppings += 1;
        }
        pizzaOrderForm.receipt.finish();
        pizzaOrderForm.receipt.addCost(baseCost, toppings);
    }
}
