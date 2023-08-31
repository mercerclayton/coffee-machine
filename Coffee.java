package CoffeeMachine;

/**
 * The Coffee enum represents different types of coffee available in the coffee machine.
 *
 * Each coffee type has specific ingredient requirements (water, milk, coffee beans) and a price.
 *
 * @version 1.20 13 Aug 2023
 * @author Clayton Mercer
 */
public enum Coffee {

    /**
     * Represents an Espresso coffee type.
     */
    ESPRESSO(250, 0, 16, 4),

    /**
     * Represents a Latte coffee type.
     */
    LATTE(350, 75, 20 ,7),

    /**
     * Represents a Cappuccino coffee type.
     */
    CAPPUCCINO(200, 100, 12, 6);

    private final int water;
    private final int milk;
    private final int coffee;
    private final int price;

    /**
     * Constructor to initialize the ingredient requirements and price of each coffee type.
     *
     * @param water Water required for the coffee type (in ml)
     * @param milk Milk required for the coffee type (in ml)
     * @param coffee Coffee beans required for the coffee type (in grams)
     * @param price Price of the coffee type (in dollars)
     */
    Coffee(int water, int milk, int coffee, int price) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.price = price;
    }

    /**
     * Gets the amount of water required for the coffee type.
     *
     * @return Amount of water required (in ml)
     */
    public int getWater() {
        return water;
    }

    /**
     * Gets the amount of milk required for the coffee type.
     *
     * @return Amount of milk required (in ml)
     */
    public int getMilk() {
        return milk;
    }

    /**
     * Gets the amount of coffee beans required for the coffee type.
     *
     * @return Amount of coffee beans required (in grams)
     */
    public int getCoffee() {
        return coffee;
    }

    /**
     * Gets the price of the coffee type.
     *
     * @return Price of the coffee (in dollars)
     */
    public int getPrice() {
        return price;
    }
}