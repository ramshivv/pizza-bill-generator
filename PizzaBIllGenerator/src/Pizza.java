public class Pizza {
    private int price;
    private boolean veg;
    private final int extraCheesePrice = 100;
    private final int extraToppingsPrice = 150;
    private final int bagPackPrice = 20;

    private final int basePizzaPrice;

    private boolean isExtraCheeseAdded = false;
    private boolean isExtraToppingAdded = false;
    private boolean isOptedTakeAway = false;

    public Pizza(boolean veg) {
        this.veg = veg;
        this.price = this.veg ? 300 : 400; // Using ternary operator for brevity
        this.basePizzaPrice = this.price;
    }

    public void addExtraCheese() {
        if (!isExtraCheeseAdded) {
            isExtraCheeseAdded = true;
            this.price += extraCheesePrice;
        }
    }

    public void addExtraToppings() {
        if (!isExtraToppingAdded) {
            isExtraToppingAdded = true;
            this.price += extraToppingsPrice;
        }
    }

    public void takeAway(){
        if (!isOptedTakeAway) {
            isOptedTakeAway = true;
            this.price += bagPackPrice;
        }
    }

    public void getBill() {
        StringBuilder bill = new StringBuilder();
        bill.append(String.format("%-25s: Rs. %d\n", (veg ? "Veg Pizza" : "Non-Veg Pizza"), basePizzaPrice));

        if (isExtraCheeseAdded) {
            bill.append(String.format("%-25s: Rs. %d\n", "Extra Cheese", extraCheesePrice));
        }
        if (isExtraToppingAdded) {
            bill.append(String.format("%-25s: Rs. %d\n", "Extra Toppings", extraToppingsPrice));
        }
        if (isOptedTakeAway) {
            bill.append(String.format("%-25s: Rs. %d\n", "Take Away Charges", bagPackPrice));
        }

        bill.append("---------------------------------\n");
        bill.append(String.format("%-25s: Rs. %d\n", "Total Bill", this.price));
        System.out.println(bill.toString());
    }
}