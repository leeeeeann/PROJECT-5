package project1;
import javax.swing.*;

// This class extends the MenuManager class and overrides 
//its methods to implement specific menu functionality.
public class Showmenu extends MenuManager {
    @Override //annotation indicates that a method overrides a method declaration in a superclass.
    //create an array containing a list of menus that will be displayed to the user in Showmenu method
    public String showMenu() {
        String[] menu = {
            "Rice + Spicy Fried Chicken Rp20.000",
            "Rice + Spicy Fried Chicken with Green Chili Rp25.000",
            "Rice + Spicy Fried Chicken with Matah Sauce Rp20.000",
            "Rice + Spicy Fried Chicken with Shrimp Paste Sauce Rp20.000",
            "Mozzarella Cheese Rp5.000",
            "Fried Cabbage Rp7.000",
            "Rice Rp6.000",
            "Mineral Water Rp5.000",
            "Iced Tea Rp4.000"
        };
        
        //customer choose an item by entering its number. formatted string containing the menu items and their prices, 
        //then prompts the user for input.
        StringBuilder menuString = new StringBuilder();
        for (int i = 0; i < menu.length; i++) {
            menuString.append((i + 1)).append(". ").append(menu[i]).append("\n");
        }

        // It validates the input to ensure it corresponds to a valid menu item index.
        String input = JOptionPane.showInputDialog("=====Welcome to GoldChick===== \n"
                + "Choose Menu:\n" + menuString + "Enter item number:");
        try {
            int choice = Integer.parseInt(input);
            // If the input is valid, it returns the chosen menu item.
            if (choice >= 1 && choice <= menu.length) {
                return menu[choice - 1];
            } else {
                // If the input is invalid, it display a warning message using the showInvalidInputWarning method and 
                //recursively calls itself to prompt the user again.
                showInvalidInputWarning(); //Call the method to display an invalid input warning
                return showMenu(); 
            }
        } catch (NumberFormatException e) {
            showInvalidInputWarning(); // Call the method to display an invalid input warning
            return showMenu();
        }
    }

    @Override
    // The getItemPrice method retrieves the price of the selected item based on its name.
    public int getItemPrice(String item) {
        // It uses a switch statement to match the item name and return the corresponding price.
        switch (item) {
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
            // If the item is not found, it returns 0.
    }
}
    }
