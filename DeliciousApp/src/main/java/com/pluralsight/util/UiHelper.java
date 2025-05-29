package com.pluralsight.util;

import java.util.Scanner;

public class UiHelper {

    //================================ Loading Spinner ===============================

    // gives the user a visual spinner for loading. Useful and looks professional.
    public static void showLoadingSpinner(int durationMillis) {
        char[] spinner = {'|', '/', '-', '\\'};
        long startTime = System.currentTimeMillis();

        while (System.currentTimeMillis() - startTime < durationMillis) {
            for (char ch : spinner) {
                System.out.print("\rLoading " + ch);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    System.out.println("\nLoading interrupted.");
                    return;
                }
            }
        }

        System.out.print("\rLoading done!         \n");
    }

    //Method waits until user presses Enter gives control to user.
    public static void waitForEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    //Method to assist with making the first letter of our string to capital to avoid error
    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private String getValidatedSize(Scanner scanner) {
        while (true) {
            System.out.print("Enter the size you want (4/8/12): ");
            String size = scanner.nextLine().trim();

            if (size.equals("4") || size.equals("8") || size.equals("12")) {
                return size;
            }
            System.out.println(" Invalid size. Please enter 4, 8, or 12.");
        }
    }

    private boolean getValidatedToasted(Scanner scanner) {
        while (true) {
            System.out.print("Would you like it toasted? (yes/no): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("yes")) return true;
            if (input.equals("no")) return false;

            System.out.println(" Invalid input. Please enter 'yes' or 'no'.");
        }
    }
}
