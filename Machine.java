package CoffeeMachine;

/**
 * The Machine class represents a coffee machine with various functionalities.
 *
 * @version 1.20 13 Aug 2023
 * @author Clayton Mercer
 */
public class Machine {

    // Current state of the machine
    private MachineState state;

    // Resources the coffee machine requires
    private static int water;
    private static int milk;
    private static int coffee;
    private static int cups;
    private static int cash;

    /**
     * Constructor to initialize coffee machine with initial resources.
     *
     * @param water Initial water quantity
     * @param milk Initial milk quantity
     * @param coffee Initial coffee quantity
     * @param cups Initial cup quantity
     * @param cash Initial cash amount
     */
    public Machine(int water, int milk, int coffee, int cups, int cash) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.cash = cash;

        // Display main menu to start interaction
        showMainMenu();
    }

    /**
     * Displays the main menu to the user.
     */
    private void showMainMenu() {
        state = MachineState.MAIN;
        System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
    }

    /**
     * Checks if the coffee machine is operational.
     *
     * @return True if the machine is working, otherwise False
     */
    public boolean isMachineWorking() {
        return state != MachineState.OFF;
    }

    /**
     * Executes an action based on user input and the current state of the coffee machine.
     *
     * @param input User input
     */
    public void execute(String input) {
        switch(state) {
            case MAIN -> {
                menuAction(input);
                break;
            }
            case BUYING -> {
                handlePurchase(input);
                showMainMenu();
                break;
            }
            case FILLING_WATER -> {
                water += Integer.parseInt(input);
                System.out.println("Write how many ml of milk you want to add: ");
                state = MachineState.FILLING_MILK;
                break;
            }
            case FILLING_MILK -> {
                milk += Integer.parseInt(input);
                System.out.println("Write how many grams of coffee beans you want to add: ");
                state = MachineState.FILLING_COFFEE;
                break;
            }
            case FILLING_COFFEE -> {
                coffee += Integer.parseInt(input);
                System.out.println("Write how many disposable cups you want to add: ");
                state = MachineState.FILLING_CUPS;
                break;
            }
            case FILLING_CUPS -> {
                cups += Integer.parseInt(input);
                showMainMenu();
                break;
            }
            default -> {
                break;
            }
        }
    }

    /**
     * Handles user input for the menu actions.
     *
     * @param input User input
     */
    private void menuAction(String input) {
        switch (input) {
            case "buy" -> {
                state = MachineState.BUYING;
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                break;
            }
            case "fill" -> {
                state = MachineState.FILLING_WATER;
                System.out.println("\nWrite how many ml of water you want to add: ");
                break;
            }
            case "take" -> {
                takeMoney();
                showMainMenu();
                break;
            }
            case "remaining" -> {
                displayRemaining();
                showMainMenu();
                break;
            }
            case "exit" -> {
                turnMachineOff();
                break;
            }
            default -> {
                break;
            }
        }
    }

    /**
     * Handles user input for purchasing coffee.
     *
     * @param input User input
     */
    private void handlePurchase(String input) {
        Coffee type = null;

        switch (input) {
            case "back" -> {
                return;
            }
            case "1" -> {
                type = Coffee.ESPRESSO;
                break;
            }
            case "2" -> {
                type = Coffee.LATTE;
                break;
            }
            case "3" -> {
                type = Coffee.CAPPUCCINO;
                break;
            }
            default -> {
                System.out.println("Coffee type not found!");
                return;
            }
        }

        makeCoffee(type);

    }

    /**
     * Makes the type of coffee specified.
     *
     * @param type Type of coffee to make
     */
    private void makeCoffee(Coffee type) {
        if (water < type.getWater()) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < type.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (coffee < type.getCoffee()) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough cups!");
            return;
        }

        water -= type.getWater();
        milk -= type.getMilk();
        coffee -= type.getCoffee();
        cups--;

        System.out.println("I have enough resources, making you a coffee!");
        acceptPayment(type.getPrice());

    }

    /**
     * Collects all the money from the coffee machine.
     */
    private void takeMoney() {
        System.out.printf("\nI gave you $%d\n", cash);
        cash = 0;
    }

    /**
     * Displays the amount of available resources.
     */
    private void displayRemaining() {
        System.out.printf("""
                \nThe coffee machine has:
                %d ml of water
                %d ml of milk
                %d g of coffee beans
                %d disposable cups
                $%d of money
                """, water, milk, coffee, cups, cash);
    }

    /**
     * Turns off the coffee machine.
     */
    private void turnMachineOff() {
        state = MachineState.OFF;
    }

    /**
     * Collects payment for the coffee.
     *
     * @param price Price of the coffee
     */
    private void acceptPayment(int price) {
        cash += price;
    }

}
