import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== WELCOME TO THE PIZZA PARLOR ===");

        // 1. Select Pizza Type
        int pizzaType = getValidChoice("Select Pizza Type:\n1. Normal Pizza\n2. Deluxe Pizza", 1, 2);

        // 2. Select Crust/Veg Type
        int vegChoice = getValidChoice("Select Category:\n1. Vegetarian\n2. Non-Vegetarian", 1, 2);
        boolean isVeg = (vegChoice == 1);

        Pizza pizza;

        if (pizzaType == 1) {
            pizza = new Pizza(isVeg);

            // Ask for add-ons only for Normal Pizza
            int cheeseChoice = getValidChoice("Want Extra Cheese?\n1. Yes\n2. No", 1, 2);
            if (cheeseChoice == 1) pizza.addExtraCheese();

            int toppingChoice = getValidChoice("Want Extra Toppings?\n1. Yes\n2. No", 1, 2);
            if (toppingChoice == 1) pizza.addExtraToppings();
        } else {
            System.out.println("\n-> Deluxe Pizza selected. (Extra Cheese & Toppings are included!)");
            pizza = new DeluxPizza(isVeg);
        }

        // 3. Delivery Method
        int deliveryChoice = getValidChoice("Order Type:\n1. Dine-In\n2. Take Away", 1, 2);
        if (deliveryChoice == 2) {
            pizza.takeAway();
        }

        // 4. Final Bill Output
        System.out.println("\n=================================");
        System.out.println("           FINAL BILL            ");
        System.out.println("=================================");
        pizza.getBill();
        System.out.println("=================================");
        System.out.println("   Thank you for your order!     ");

        sc.close();
    }

    /**
     * Helper method to ensure the user enters a valid integer within a given range.
     */
    private static int getValidChoice(String prompt, int min, int max) {
        int choice;
        while (true) {
            System.out.println("\n" + prompt);
            System.out.print("Enter your choice (" + min + "-" + max + "): ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                sc.next(); // Clear invalid input token
            }
            System.out.println("Invalid input! Please enter a valid number between " + min + " and " + max + ".");
        }
    }
}
