public class DeluxPizza extends Pizza {

    public DeluxPizza(boolean veg) {
        super(veg);
        // Deluxe automatically includes these
        super.addExtraCheese();
        super.addExtraToppings();
    }

    // Overriding to prevent manual additions/double charging
    @Override
    public void addExtraCheese() {}

    @Override
    public void addExtraToppings() {}
}