package CoffeeMachine;

import java.util.Scanner;

/**
 * The CoffeeMachine class serves as the entry point for the coffee machine simulation.
 *
 * It initializes the coffee machine, processes user inputs, and controls the simulation loop.
 *
 * @version 1.20 13 Aug 2023
 * @author Clayton Mercer
 */
public class CoffeeMachine {

    /**
     * The main method that starts the coffee machine simulation.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create a Scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Initialize the coffee machine with initial resource values
        Machine machine = new Machine(400, 540, 120, 9, 550);

        // Process user input until the coffee machine is turned off
        while (machine.isMachineWorking()) {

            // Read and process user input
            machine.execute(scanner.next());
        }

        // Close the scanner
        scanner.close();
    }
}
