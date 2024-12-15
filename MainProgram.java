
package project1;
import javax.swing.*;

// This is the main program class
public class MainProgram {
    private static int attempt;
    
    public static void main(String[] args) {
        // Performing the login process
        boolean loginSuccess = login.login(); // Calling the login method from the Login class
        if (!loginSuccess) {
            JOptionPane.showMessageDialog(null, "Exiting program...");
            return;
        }
        
        // Initializing array to store menu and prices
        String[][] arrMenu = new String[10][2];
        // Displaying the menu and selecting items
        MenuManager menuManager = new Showmenu(); // Using the ShowMenu class and MenuManager
        String item = menuManager.showMenu(); // Calling the showMenu method through the menuManager object

        int choice;
        // Loop for adding items to the array
        do {
            // Adding items to the array
            addItemToArray(arrMenu, item, menuManager.getItemPrice(item));// Adding item price to the array
            String [] choice1 = {"Yes", "No"};
            // Asking if more items should be added
            choice = JOptionPane.showOptionDialog (null, "Do You want add more Item", "", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, choice1, choice1[0]);
            if (choice == 0) {
                item = menuManager.showMenu(); // Calling the showMenu method through the menuManager object
            }
        } while (choice == 0);

        // Calculating the total price
        int totalPrice = getTotalPrice(arrMenu);
        JOptionPane.showMessageDialog(null, "Total Price: Rp. " + totalPrice);
        
        // Selecting the payment method
        int paymentMethod;
        String [] PaymentMethod = {"Debit", "Cash"};
        paymentMethod = JOptionPane.showOptionDialog (null, "Select Payment Method", "", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, null, PaymentMethod, PaymentMethod[0]);
        
        switch (paymentMethod) {
            case 0:
                JOptionPane.showMessageDialog(null, "You Choose Debit Payment. Please Insert your Card");
                
                for (attempt = 1; attempt <= 3; attempt++) {
                    String enteredPin = JOptionPane.showInputDialog("Please Input Your PIN:");
                    String validPin = "1234";
                    
                    if (enteredPin.equals(validPin)) {
                        JOptionPane.showMessageDialog(null, "Successful Transaction");
                        break;
                    } else if (attempt < 3) {
                        JOptionPane.showMessageDialog(null, "Incorrect PIN. Please re-enter your PIN");
                    }
                }
                
                if (attempt == 4) {
                    JOptionPane.showMessageDialog(null, "Failed to Purchase, your ATM card has been blocked. "
                                                         + "Please go to cashier.");
                    return; // Exiting the method if failed more than 3 times
                }
                break;
                
            case 1:
                JOptionPane.showMessageDialog(null, "You choose cash transaction. "
                                                       + "Please go to the cashier to continue the payment.");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice");
        }
        
        // Displaying the receipt
        receipts(arrMenu, totalPrice); // Pass totalPrice to receipts method
    }
    
    // Method for arranging and displaying the receipt
public static void receipts(String[][] arrMenu, int totalPrice) {
    StringBuilder receipts = new StringBuilder();
    // Adding the receipt title
    receipts.append("===== RECEIPTS ======\n"); // Append to concatenate each menu item into a string
    // Adding the header for Item and Price columns with predetermined column widths
    receipts.append(String.format("%-70s%-30s\n", "Item", "Price"));
    // Iterating through the arrMenu array to add each item and its price to the receipt
    for (int i = 0; i < arrMenu.length; i++) {
        // Checking if the item is not null (hasn't reached an empty slot)
        if (arrMenu[i][0] != null) {
            // Adding the item name and its price to the receipt with the predetermined column widths
            receipts.append(String.format("%-70sRp.%-30s\n", arrMenu[i][0], arrMenu[i][1]));
        } else {
            // If an empty slot is found, exit the loop
            break;
        }
    }
    // Adding a separator line after the list of items
    receipts.append("=======================\n");
    // Adding the total price with the appropriate format
    receipts.append(String.format("%-70sRp.%-30s\n", "Total", totalPrice));
    // Printing the assembled receipt
    System.out.println(receipts.toString());
    }

    // Method for adding items and prices to the array
    public static void addItemToArray(String[][] arrMenu, String item, int price) { // Adding price parameter
        for (int i = 0; i < arrMenu.length; i++) {
            if (arrMenu[i][0] == null) {
                arrMenu[i][0] = item;
                arrMenu[i][1] = String.valueOf(price); // Setting the item price
                break;
            }
        }
    }

    // Method for calculating the total price
    public static int getTotalPrice(String[][] arrMenu) {
        int totalPrice = 0;
        for (int i = 0; i < arrMenu.length; i++) {
            if (arrMenu[i][1] != null) {
                totalPrice += Integer.parseInt(arrMenu[i][1]);
            }
        }
        return totalPrice;
    }
}










