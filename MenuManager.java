
package project1;
import javax.swing.*;
public abstract class MenuManager {
    // Method to display menu
    public abstract String showMenu();

    // Method to get item price
    public abstract int getItemPrice(String item);

    // Method to display invalid input warning
    // This method can only be accessed by its subclasses.
    protected void showInvalidInputWarning() {
        JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid item number.", 
                                            "Warning", JOptionPane.WARNING_MESSAGE);
    }
}







