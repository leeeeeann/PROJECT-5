package project1;
import javax.swing.*;

public class login {
    // Method to perform the login process.
    public static boolean login() {
        // Loop to try login for three times.
        for (int attempt = 1; attempt <= 3; attempt++) {
        //Question box for customers to enter username and password
        String enteredUsername = JOptionPane.showInputDialog("Welcome to Goldchick \n"
                                                              + "Username :");
        String enteredPassword = JOptionPane.showInputDialog("Welcome to Goldchick \n"
                                                              + "Password :");
        //to set username and password
        String validUsername = "user0000";
        String validPassword = "0000";
        
        // Checking if the entered username and password are correct.
        if (enteredUsername.equals(validUsername) && enteredPassword.equals(validPassword)) {
            JOptionPane.showMessageDialog(null, "Welcome!");
            return true;
        } else if (attempt < 3) {
            JOptionPane.showMessageDialog(null, "Failed to Login. Please check your Username and Password.");
        }
    }
        // If failed to login for three times, show a message.
        JOptionPane.showMessageDialog(null, "Failed to Login. Maximum attempts reached.");
        return false;
    }
}


