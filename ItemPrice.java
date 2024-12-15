package project1;
import javax.swing.*;
// Class to handle item prices, inheriting from MenuManager
public class ItemPrice extends MenuManager {
    @Override //annotation indicates that a method overrides method declaration in a superclass.
    public String showMenu() {
        return null; // Not applicable for this class, return null
    }
    @Override
    // Method to get the price of an item based on its name.
    public int getItemPrice(String item) {
        switch(item) {
            case "Rice + Spicy Fried Chicken Rp20.000":
                return 20000;
            case "Rice + Spicy Fried Chicken with Green Chili Rp25.000":
                return 25000;
            case "Rice + Spicy Fried Chicken with Matah Sauce Rp20.000":
                return 20000;
            case "Rice + Spicy Fried Chicken with Shrimp Paste Sauce Rp20.000":
                return 20000;
            case "Mozzarella Cheese Rp5.000":
                return 5000;
            case "Fried Cabbage Rp7.000":
                return 7000;
            case "Rice Rp6.000":
                return 6000;
            case "Mineral Water Rp5.000":
                return 5000;
            case "Iced Tea Rp4.000":
                return 4000;
            default:
                return 0;
        }
    }
}


