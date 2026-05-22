package com.mycompany.registration;

import java.util.Scanner;

public class Registration {

    private String userName;
    private String password;
    private String phoneNumber;

    public boolean checkUserName(String userName) {
        return userName.contains("_") && userName.length() <= 5;
    }

    public boolean checkPassword(String password) {
        if (password.length() < 8)
            return false;

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char checkLetters = password.charAt(i);

            if (Character.isUpperCase(checkLetters)) {
                hasUpper = true;
            } else if (Character.isDigit(checkLetters)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(checkLetters)) {
                hasSpecial = true;
            }
        }

        return hasUpper && hasNumber && hasSpecial;
    }

    public boolean checkCellphoneNumber(String number) {
        if (!number.startsWith("+27")) {
            return false;
        }

        if (number.length() != 12) {
            return false;
        }

        for (int i = 3; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public void register(Scanner sc) {
        System.out.println("=== REGISTER ===");

        System.out.print("Enter username: ");
        String username = sc.next();

        if (checkUserName(username)) {
            System.out.println("Username successfully entered.");
        } else {
            System.out.println("Invalid username.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Registration reg = new Registration();
        reg.register(sc);
    }
}

