package CoffeeMachine;

/**
 * The MachineState enum represents the various states that the coffee machine can be in.
 *
 * @version 1.20 13 Aug 2023
 * @author Clayton Mercer
 */
public enum MachineState {

    /**
     * The coffee machine is turned off and not operational.
     */
    OFF,

    /**
     * The coffee machine is in the main menu state, awaiting user input.
     */
    MAIN,

    /**
     * The coffee machine is in the process of handling a coffee purchase.
     */
    BUYING,

    /**
     * The coffee machine is in the process of filling water.
     */
    FILLING_WATER,

    /**
     * The coffee machine is in the process of filling milk.
     */
    FILLING_MILK,

    /**
     * The coffee machine is in the process of filling coffee beans.
     */
    FILLING_COFFEE,

    /**
     * The coffee machine is in the process of filling disposable cups.
     */
    FILLING_CUPS
}